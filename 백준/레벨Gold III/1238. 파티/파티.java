import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node, dist;
        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int[] dijkstra(int N, int S, List<List<Node>> graph) {
        // 거리배열 초기화
        final int MAX = 100001;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);
        dist[S] = 0;

        // 우선순위큐
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] parts = pq.poll();
            int curDist = parts[0], u = parts[1];

            if (curDist > dist[u]) continue;
            
            for (Node v : graph.get(u)) {
                int nxtDist = curDist + v.dist;
                
                if (nxtDist < dist[v.node]) {
                    dist[v.node] = nxtDist;
                    pq.offer(new int[]{nxtDist, v.node});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 정방향, 역방향 인접리스트 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        List<List<Node>> fGraph = new ArrayList<>();
        List<List<Node>> rGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            fGraph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            fGraph.get(u).add(new Node(v, w));
            rGraph.get(v).add(new Node(u, w));
        }

        // 집 -> X -> 집
        int[] homeToParty = dijkstra(N, X, fGraph);
        int[] partyToHome = dijkstra(N, X, rGraph);

        // 최대시간 찾기
        int maxTime = -1;
        for (int i = 1; i <= N; i++) {
            int curTime = homeToParty[i] + partyToHome[i];
            if (curTime > maxTime) {
                maxTime = curTime;
            }
        }

        System.out.println(maxTime);
    }
}