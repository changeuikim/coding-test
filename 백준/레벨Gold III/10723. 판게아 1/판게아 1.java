import java.io.*;
import java.util.*;

class Solution {
    // 전역변수
    private static int N;
    private static int[] parent;

    private static int find(int x) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;

        if (a > b) parent[a] = b;
        else parent[b] = a;
        return true;
    }

    private static long kruskal(List<int[]> edges) {
        // 부모 + 랭크 노드
        parent = new int[N + 1];
        Arrays.setAll(parent, i -> i);

        // 가중치 기준 정렬
        edges.sort(Comparator.comparingInt(o -> o[0]));

        // 최소 신장 트리
        long mstCost = 0;
        int edgeCount = 0;

        for (int[] edge : edges) {
            int w = edge[0], u = edge[1], v = edge[2];
            if (edgeCount >= N - 1) break;
            if (union(u, v)) {
                mstCost += w;
                edgeCount++;
            }
        }

        return mstCost;
    }

    public void solution() throws IOException {
        // 1. 테스트 T회
        int T = nextInt();
        while (T-- > 0) {
            N = nextInt();
            int M = nextInt();

            // 2. 태초의 세계, 엣지 리스트
            List<int[]> edges = new ArrayList<>();
            for (int i = 1; i < N; i++) {
                int u = nextInt(), c = nextInt();
                edges.add(new int[]{c, i, u}); // w, u, v
            }

            // 3. 조물주가 새로이 놓은 도로
            long result = 0;
            for (int j = 1; j <= M; j++) {
                int u = nextInt(), v = nextInt(), c = nextInt();
                edges.add(new int[]{c, u, v}); // w, u, v

                // 5. XOR 연산
                result ^= kruskal(edges); // 4. 크루스칼
            }

            System.out.println(result);
        }
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
        new Solution().solution();
    }
}