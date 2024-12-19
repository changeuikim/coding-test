import java.io.*;
import java.util.*;

class Edge {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }
}

class Solution {
    public void bellmanFord() throws IOException {
        int N = nextInt(), M = nextInt();

        // 간선리스트 초기화
        List<Edge> graph = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            int u = nextInt(), v = nextInt(), w = nextInt();
            graph.add(new Edge(u, v, w));
        }

        // 거리배열 초기화
        long INF = 500 * 10000 + 1;
        long[] dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        // (노드-1)회 반복
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : graph) {
                if (dist[edge.u] == INF) continue;

                long nxt = dist[edge.u] + edge.w;
                if (dist[edge.v] > nxt) dist[edge.v] = nxt;
            }
        }

        // 음의 사이클 검사
        boolean isCycle = false;
        for (Edge edge : graph) {
            if (dist[edge.u] == INF) continue;

            if (dist[edge.v] > dist[edge.u] + edge.w) {
                isCycle = true;
                break;
            }
        }

        // 출력 처리
        StringBuilder sb = new StringBuilder();
        if (isCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i <= N; i++) {
                if (dist[i] == INF) {
                    sb.append(-1);
                } else {
                    sb.append(dist[i]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        boolean neg = false;
        while ((c = System.in.read()) <= 32);
        if (c == '-') {
            neg = true;
            c = System.in.read();
        }
        do {
            n = n * 10 + (c - '0');
        } while ((c = System.in.read()) > 32);
        return neg ? -n : n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().bellmanFord();
    }
}