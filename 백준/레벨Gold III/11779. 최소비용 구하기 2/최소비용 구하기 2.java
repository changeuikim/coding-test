import java.io.*;
import java.util.*;

class Solution {
    static class Node {
        int vertex;
        int cost;
        Node prev;

        Node(int vertex, int cost, Node prev) {
            this.vertex = vertex;
            this.cost = cost;
            this.prev = prev;
        }
    }

    public void dijkstra() throws IOException {
        int N = nextInt(), M = nextInt();

        // 인접리스트 초기화
        List<List<int[]>> graph = new ArrayList<>(N + 1);

        for (int i = 0; i <= N; i++) graph.add(new ArrayList<>());

        while (M-- > 0) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            graph.get(u).add(new int[]{v, w});
        }

        // 출발점, 도착점
        int S = nextInt(), E = nextInt();

        // 거리 초기화
        final int INF = (int) 1e9;
        int[] dist = new int[N + 1];
        Arrays.fill(dist, INF);
            
        // 우선순위 큐 초기화
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.cost));
        pq.offer(new Node(S, 0, null));
        
        // 다익스트라
        Node endNode = null;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cur = current.cost, u = current.vertex;

            if (cur > dist[u]) continue;

            if (current.vertex == E) {
                endNode = current;
                break;
            }

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                int nxt = cur + w;
                if (dist[v] > nxt) {
                    dist[v] = nxt;
                    pq.offer(new Node(v, nxt, current));
                }
            }
        }

        // 최단거리 경로복원
        List<Integer> path = new ArrayList<>();
        while (endNode != null) {
            path.add(endNode.vertex);
            endNode = endNode.prev;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(dist[E]).append("\n");
        sb.append(path.size()).append("\n");

        for (int i = path.size() - 1; i >= 0; i--) {
            sb.append(path.get(i)).append(" ");
        }

        System.out.println(sb);
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32);
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().dijkstra();
    }
}