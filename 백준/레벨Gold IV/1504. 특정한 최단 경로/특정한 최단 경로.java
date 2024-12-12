import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 10000001;
    static List<List<Node>> graph;

    static class Node {
        int node, dist;

        Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    static int[] dijkstra(int S, int N) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, MAX);
        dist[S] = 0;

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
                    pq.add(new int[]{nxtDist, v.node});
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인접리스트 초기화
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1, V1, V2에서 출발하는 거리배열
        int[] from1 = dijkstra(1, N);
        int[] fromV1 = dijkstra(v1, N);
        int[] fromV2 = dijkstra(v2, N);

        // 경로1 : 1 -> v1 -> v2 -> N
        // 경로2 : 1 -> v2 -> v1 -> N
        long path1 = (long) from1[v1] + fromV1[v2] + fromV2[N];
        long path2 = (long) from1[v2] + fromV2[v1] + fromV1[N];
        long result = Math.min(path1, path2);

        System.out.println(result >= MAX ? -1 : result);
    }
}