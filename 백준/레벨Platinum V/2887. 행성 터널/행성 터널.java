import java.io.*;
import java.util.*;

/*
    비용은 두 행성 간의 최소 축 차이: min(|xA - xB|, |yA - yB|, |zA - zB|)
    모든 행성 간의 간선을 계산하면 nC2 = O(N^2), 이는 N = 1e5일 때 약 50억 개로 시간 초과 발생
    최적화 방법:
        - x, y, z 축별로 좌표를 기준으로 행성을 정렬한 뒤,
        - 인접한 두 행성 사이의 간선만 고려 -> 축별로 N-1개의 간선
        - 총 간선 개수: 3(N-1), 시간 복잡도: O(N log N), 이는 N = 1e5일때 약 170만으로 안전범위
*/

class Edge implements Comparable<Edge> {
    int u, v, w;

    Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        return Integer.compare(this.w, other.w);
    }
}

class Solution {
    static int N;
    static List<int[]> planets;
    static List<Edge> graph;
    static int[] parent;

    public void kruskal() throws IOException {
        // 행성의 개수 N (1 ≤ N ≤ 100,000)
        N = nextInt();

        // 행성정보 0-based
        planets = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            int x = nextInt();
            int y = nextInt();
            int z = nextInt();
            planets.add(new int[]{i, x, y, z});
        }

        // 간선 리스트 초기화
        int M = (N - 1) * 3;
        graph = new ArrayList<>(M);

        for (int i = 1; i <= 3; i++) {
            // x, y, z축 기준 정렬 간선
            final int axis = i;
            planets.sort(Comparator.comparingInt(a -> a[axis]));

            for (int j = 0; j < N - 1; j++) {
                int u = planets.get(j)[0];
                int v = planets.get(j + 1)[0];
                int w = Math.abs(planets.get(j + 1)[axis] - planets.get(j)[axis]);
                graph.add(new Edge(u, v, w));
            }
        }

        // 부모노드 0 ~ N-1 초기화
        parent = new int[N];
        Arrays.setAll(parent, i -> i);

        // 크루스칼
        int mstCost = 0;
        int edgeCount = 0;

        Collections.sort(graph);

        for (Edge edge : graph) {
            int u = edge.u, v = edge.v, w = edge.w;
            if (edgeCount >= N - 1) break;
            if (union(u, v)) {
                mstCost += w;
                edgeCount++;
            }
        }

        System.out.println(mstCost);
    }

    private static int find(int x) {
        while (parent[x] != x) {
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
        new Solution().kruskal();
    }
}