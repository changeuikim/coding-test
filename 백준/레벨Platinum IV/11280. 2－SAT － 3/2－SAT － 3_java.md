# [Platinum IV] [2-SAT - 3](https://www.acmicpc.net/problem/11280) - 11280 

NaN2-sat, 그래프 이론, 강한 연결 요소

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    public void iterativeTarjan() throws IOException {
        int N = nextInt(), M = nextInt();

        // 1. 음수,양수 인접리스트 초기화
        List<List<Integer>> graph = new ArrayList<>(N * 2 + 1);

        for (int i = 0; i <= N * 2; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            int u = nextInt(), v = nextInt();

            // u Or V는 ~u -> v 또는 ~v -> u이다
            int nu1 = u * -1, nv1 = v;
            if (nu1 < 0) nu1 = N - nu1;
            if (nv1 < 0) nv1 = N - nv1;
            graph.get(nu1).add(nv1);

            int nu2 = v * -1, nv2 = u;
            if (nu2 < 0) nu2 = N - nu2;
            if (nv2 < 0) nv2 = N - nv2;
            graph.get(nu2).add(nv2);
        }            

        // SCC 후보
        Deque<Integer> sccStk = new LinkedList<>();
        boolean[] onStk = new boolean[N * 2 + 1];
        // 발견 순서, 발견 시간
        int[] disc = new int[N * 2 + 1];
        int timestamp = 0;
        // SCC id, SCC 번호
        int[] sccID = new int[N * 2 + 1];
        int sccCnt = 0;
        // 정점의 도달 가능한 최소 방문 순서
        int[] lowlink = new int[N * 2 + 1];

        Arrays.fill(disc, -1);
        Arrays.fill(sccID, -1);
        Arrays.fill(lowlink, -1);            

        // 2. 모든 정점에 대해 DFS
        Deque<int[]> dsfStk = new LinkedList<>();
        for (int start = 1; start <= N * 2; start++) {
            if (disc[start] == -1) {
                dsfStk.push(new int[]{start, 0});

                while (!dsfStk.isEmpty()) {
                    int[] current = dsfStk.peek();
                    int u = current[0], i = current[1];
        
                    // u 첫 방문
                    if (disc[u] == -1) {
                        // lowlink 갱신 1
                        disc[u] = lowlink[u] = timestamp++;
                        // SCC 후보에 u 추가
                        sccStk.push(u);
                        onStk[u] = true;
                        }
        
                    // 자식 v를 탐색: for v in graph[u]
                    if (i < graph.get(u).size()) {
                        int v = graph.get(u).get(i);
                        dsfStk.pop();
                        dsfStk.push(new int[]{u, i + 1});
        
                        // v 첫방문
                        if (disc[v] == -1) {
                            dsfStk.push(new int[]{v, 0});
                        }
                        // v가 SCC 후보라면
                        else if (onStk[v]) {
                            // lowlink 갱신 2
                            lowlink[u] = Math.min(lowlink[u], disc[v]);
                        }
                    }
                    // 탐색할 v가 없으면
                    else {
                        // dfs(v)를 콜스택에서 제거
                        dsfStk.pop();
                        // 부모가 있다면
                        if (dsfStk.size() > 0) {
                            int parent = dsfStk.peek()[0];
                            // lowlink 갱신 3 : u의 자식들의 최소값을 u의 부모에 전파
                            lowlink[parent] = Math.min(lowlink[parent], lowlink[u]);
                        }
        
                        // u가 이번 SCC의 루트 : 역방향 간선이 없고, 자식 중에서도 가장 빠르다
                        if (lowlink[u] == disc[u]) {
                            // 새 SCC를 구성
                            while (true) {
                                int top = sccStk.pop();
                                onStk[top] = false;
                                // 정점의 SCC 번호 기록
                                sccID[top] = sccCnt;
                                if (top == u) break;
                            }
                            sccCnt++;
                        }
                    }
                }                    
            }
        }

        // 3. 정점 u와 정점 -u의 scc_cnt를 대조
        for (int u = 1; u <= N; u++) {
            if (sccID[u] == sccID[u + N]) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
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
        new Solution().iterativeTarjan();
    }
}

```

### 성능 요약

시간: 312 ms

메모리: 34256 KB

### 제출 일자

2024년 12월 27일 (금) 11:43

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

