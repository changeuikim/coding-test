import java.io.*;
import java.util.*;

class Solution {
    int[] parent;

    public void disjointSet() throws IOException {
        // 부모노드 초기화
        int N = nextInt(), M = nextInt();
        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        // 진실노드 초기화
        int truthSize = nextInt();
        if (truthSize == 0) {
            System.out.println(M);
            return;
        }

        int[] truth = new int[truthSize];
        for (int i = 0; i < truth.length; i++) truth[i] = nextInt();

        // 파티노드 초기화
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            int partySize = nextInt();
            
            int[] party = new int[partySize];
            for (int j = 0; j < party.length; j++) party[j] = nextInt();
            parties.add(party);

            for (int j = 0; j < party.length - 1; j++) union(party[j], party[j + 1]);
        }

        // 진실노드로 병합
        int root = find(truth[0]);
        for (int i = 1; i < truth.length; i++) union(truth[i], root);

        // 파티 처리
        int count = M;
        for (int[] party : parties) {
            if (find(party[0]) == find(root)) count--;
        }

        System.out.println(count);
    }

    int find(int x) {
        List<Integer> nodes = new ArrayList<>();
        while (parent[x] != x) {
            nodes.add(x);
            x = parent[x];
        }

        for (int node : nodes) parent[node] = x;
        return x;
    }
    
    void union(int a, int b) {
        int root_a = find(a);
        int root_b = find(b);

        if (root_a > root_b) parent[root_a] = root_b;
        else parent[root_b] = root_a;
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