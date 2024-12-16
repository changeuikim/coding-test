import java.io.*;
import java.util.*;

class Solution {
    private int[] parent; 

    public void disjointSet() throws IOException {
        // 부모 노드 초기화
        int N = nextInt(), M = nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 분리 집합
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (nextInt() == 1) {
                    union(i, j);
                }
            }
        }

        // 경로 검증
        int[] cities = new int[M];
        for (int i = 0; i < M; i++) {
            cities[i] = nextInt();
        }

        int root = find(cities[0]);
        boolean isPossible = true;
        for (int city : cities) {
            if (find(city) != root) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }

    private int find(int x) {
        List<Integer> nodes = new ArrayList<>();
        while (parent[x] != x) {
            nodes.add(x);
            x = parent[x];
        }
        // 한번에 경로 압축
        for (int node : nodes) {
            parent[node] = x;
        }
        return x;
    }

    private void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA == rootB) return;

        if (rootA > rootB)  parent[rootA] = rootB;
        else parent[rootB] = rootA;
    }

    int nextInt() throws IOException {
        int n = 0;
        int c;

        while ((c = System.in.read()) <= 32); // 탭 2, 개행 10, 공백 32

        do {
            n = n * 10 + (c - '0'); // 한자리씩 추가
        } while ((c = System.in.read()) > 32); // 구분자 : 공백

        return n;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        new Solution().disjointSet();
    }
}