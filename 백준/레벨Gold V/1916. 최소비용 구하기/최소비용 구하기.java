import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int node, cost;
        Node(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 인접리스트 초기화
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());
        List<List<Node>> graph = new ArrayList<>();
        
        for (int i = 0; i <= N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        st = new StringTokenizer(br.readLine());
        int S = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        // 다익스트라
        int[] costs = new int[N + 1];
        Arrays.fill(costs, Integer.MAX_VALUE);
        costs[S] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, S});

        while (!pq.isEmpty()) {
            int[] parts = pq.poll();
            int currCost = parts[0];
            int u = parts[1];

            if (currCost > costs[u]) continue;
            if (u == E) break;

            for (Node v : graph.get(u)) {
                int nextCost = currCost + v.cost;

                if (nextCost < costs[v.node]) {
                    costs[v.node] = nextCost;
                    pq.add(new int[]{nextCost, v.node});
                }
            }
        }

        System.out.println(costs[E]);
    }
}