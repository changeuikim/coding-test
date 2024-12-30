import java.io.*;
import java.util.*;

class Solution {
    public void tarjan() throws IOException {
        // 테스트 케이스 T회 (T <= 11)
        int T = nextInt();
        while (T-- > 0) {
            // 정점 N 간선 M (1 ≤ N, M ≤ 100,000)
            int N = nextInt(), M = nextInt();

            // 1. 간선 리스트 초기화
            List<List<Integer>> graph = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                graph.add(new ArrayList<>());
            }
            for (int i = 0; i < M; i++) {
                int u = nextInt(), v = nextInt();
                graph.get(u).add(v);
            }

            // SCC 목록
            Map<Integer, List<Integer>> sccMap = new HashMap<>();
            int[] sccID = new int[N];
            int sccNum = 0;

            // SCC 후보
            Deque<Integer> sccStk = new LinkedList<>();
            boolean[] onStk = new boolean[N];

            // 발견
            int[] disc = new int[N];
            int discTime = 0;
            int[] lowlink = new int[N];

            Arrays.fill(sccID, -1);
            Arrays.fill(disc, -1);
            Arrays.fill(lowlink, -1);

            // 2. 모든 정점에 대해 DFS
            Deque<int[]> dsfStk = new LinkedList<>();
            for (int start = 0; start < N; start++) {
                if (disc[start] == -1) {
                    dsfStk.push(new int[]{start, 0});

                    // Iterative Tarjan
                    while (!dsfStk.isEmpty()) {
                        int[] current = dsfStk.peek();
                        int u = current[0], i = current[1];

                        // u를 첫방문
                        if (disc[u] == -1) {
                            // lowlink 갱신 1
                            lowlink[u] = disc[u] = discTime++;

                            // SCC 후보에 u 추가
                            sccStk.push(u);
                            onStk[u] = true;
                        }

                        // 자식 v를 탐색 : for v in graph[u]
                        if (i < graph.get(u).size()) {
                            int v = graph.get(u).get(i);
                            // 다음 v로 미리 이동
                            dsfStk.pop();
                            dsfStk.push(new int[]{u, i + 1});

                            // v를 첫방문
                            if (disc[v] == -1) {
                                dsfStk.push(new int[]{v, 0});
                            }
                            // v가 SCC 후보
                            else if (onStk[v]) {
                                // lowlink 갱신 2
                                lowlink[u] = Math.min(lowlink[u], lowlink[v]);
                            }
                        }
                        // 탐색할 v가 없으면
                        else {
                            // dfs(v)를 콜스택에서 팝
                            dsfStk.pop();

                            // 부모 노드가 남아있다면
                            if (!dsfStk.isEmpty()) {
                                int parent = dsfStk.peek()[0];
                                // lowlink 갱신 3
                                lowlink[parent] = Math.min(lowlink[parent], lowlink[u]);
                            }

                            // u가 새로운 SCC의 루트라면
                            if (lowlink[u] == disc[u]) {
                                List<Integer> cur_scc = new ArrayList<>();

                                // 새로운 SCC 구성하기
                                while (true) {
                                    int top = sccStk.pop();
                                    onStk[top] = false;
                                    cur_scc.add(top);
                                    sccID[top] = sccNum;
                                    if (top == u) break;
                                }

                                sccMap.put(sccNum++, cur_scc);
                            }
                        }
                    }
                }
            }

            // 3. 진입차수 0인 SCC를 확인
            int[] indegree = new int[sccNum];
            for (int u = 0; u < N; u++) {
                for (int v : graph.get(u)) {
                    // 서로 다른 SCC를 연결하면 진입차수 증가
                    if (sccID[v] != sccID[u]) {
                        indegree[sccID[v]]++;
                    }
                }
            }

            // 4. 출력 처리
            List<Integer> entry = new ArrayList<>();
            for (int i = 0; i < sccNum; i++) {
                if (indegree[i] == 0) entry.add(i);
            }
            
            StringBuilder sb = new StringBuilder();
            if (entry.size() == 1) {
                List<Integer> result = sccMap.get(entry.get(0));
                Collections.sort(result);
                for (int v : result) {
                    sb.append(v).append("\n");
                }
            } else {
                sb.append("Confused").append("\n");
            }
            System.out.println(sb);
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
        new Solution().tarjan();
    }
}