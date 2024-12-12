import java.io.*;
import java.util.*;

class Solution {
    static int nextInt() throws IOException {
        int c, n = System.in.read() & 15; // 1의 자리 n, 다음 자리 c
        while((c = System.in.read()) > 32) { // 탭 9, 개행 10, 공백 32
            n = n * 10 + (c & 15); // 한자리씩 올리기
        }
        return n;
    }

    static int N, K, W;
    static int[] buildTime;
    static int[] inDegree;
    static List<List<Integer>> graph;

    private int[] topologicalSort() {
        Deque<Integer> stk = new ArrayDeque<>();
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                stk.push(i);
                dp[i] = buildTime[i];
            }
        }

        while (!stk.isEmpty()) {
            int u = stk.pop();

            for (int v : graph.get(u)) {
                inDegree[v]--;
                dp[v] = Math.max(dp[v], dp[u] + buildTime[v]);

                if (inDegree[v] == 0) {
                    stk.push(v);
                }
            }
        }

        return dp;
    }

    private int test() throws IOException {
        // 빌드타임 초기화
        N = nextInt();
        K = nextInt();
        buildTime = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            buildTime[i] = nextInt();
        }

        // 인접리스트, 진입차수 초기화
        graph = new ArrayList<>();
        inDegree = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (K-- > 0) {
            int u = nextInt();
            int v = nextInt();
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // 승리 조건
        W = nextInt();

        // 위상 정렬
        int[] dp = topologicalSort();

        return dp[W];
    }

    public void solution() throws IOException {
        int T = nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < T; t++) {
            sb.append(test()).append("\n");
        }

        System.out.println(sb);
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().solution();
    }
}