# [Platinum IV] [도미노](https://www.acmicpc.net/problem/4196) - 4196 

NaN방향 비순환 그래프, 그래프 이론, 강한 연결 요소, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Solution {
    public void iterativeTarjan() throws IOException {
        // 테스트케이스 T회
        int T = nextInt();
        while (T-- > 0) {
            // SSC그룹핑 -> DAG생성 -> 진입차수 확인
            int V = nextInt(), E = nextInt();

            // 1. 인접리스트 초기화
            List<List<Integer>> graph = new ArrayList<>();

            for (int i = 0; i <= V; i++) {
                graph.add(new ArrayList<>());
            }
    
            for (int i = 0; i < E; i++) {
                int u = nextInt(), v = nextInt();
                graph.get(u).add(v);
            }            

            // SSC 후보 스택, 정점의 스택 포함 여부
            Deque<Integer> sccStack = new LinkedList<>();
            boolean[] inStack = new boolean[V + 1];
            // DFS 방문순서, 카운터
            int[] visited = new int[V + 1];
            int visitedCount = 0;
            // SSC id, 현재
            int[] sccID = new int[V + 1];
            int curSCC = 0;
            // low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
            int[] low = new int[V + 1];

            Arrays.fill(visited, -1);
            Arrays.fill(sccID, -1);
            Arrays.fill(low, -1);            

            // 2. 모든 정점에 대해 DFS
            Deque<int[]> dfsStack = new LinkedList<>();
            for (int start = 1; start <= V; start++) {
                if (visited[start] == -1) {
                    dfsStack.push(new int[]{start, 0});

                    while (!dfsStack.isEmpty()) {
                        int[] current = dfsStack.peek();
                        int u = current[0], i = current[1];
            
                        // 첫 방문
                        if (visited[u] == -1) {
                            // low 갱신 1
                            visited[u] = low[u] = visitedCount++;
                            // 스택에 u를 추가
                            sccStack.push(u);
                            inStack[u] = true;
                          }
            
                        // 인접 정점을 탐색
                        if (i < graph.get(u).size()) {
                            int v = graph.get(u).get(i);
                            dfsStack.pop();
                            dfsStack.push(new int[]{u, i + 1});
            
                            // 첫 방문
                            if (visited[v] == -1) {
                                dfsStack.push(new int[]{v, 0});
                            }
                            // SCC 후보
                            else if (inStack[v]) {
                                // low 갱신 2
                                low[u] = Math.min(low[u], visited[v]);
                            }
                        }
                        // 탐색을 완료하면
                        else {
                            // dfs(v)
                            dfsStack.pop();
                            if (dfsStack.size() > 0) {
                                int parent = dfsStack.peek()[0];
                                // low 갱신 3
                                low[parent] = Math.min(low[parent], low[u]);
                            }
            
                            // u가 SCC 루트 정점
                            if (low[u] == visited[u]) {
                                // u의 SCC 구성하기
                                while (true) {
                                    int top = sccStack.pop();
                                    inStack[top] = false;
                                    sccID[top] = curSCC;
                                    if (top == u) break;
                                }
                                curSCC++;
                            }
                        }
                    }                    
                }
            }

            // 3. SCC 단위로 DAG 생성
            int[] indegree = new int[curSCC];
            for (int u = 1; u <= V; u++) {
                for (int v : graph.get(u)) {
                    // 서로 다른 SCC를 연결하면 진입차수 증가
                    if (sccID[u] != sccID[v]) {
                        indegree[sccID[v]]++;
                    }
                }
            }            

            // 4. 진입차수 0인 SCC의 개수
            System.out.println(Arrays.stream(indegree)
                                     .filter(x -> x == 0)
                                     .count());
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
        new Solution().iterativeTarjan();
    }
}

```

### 성능 요약

시간: 596 ms

메모리: 117524 KB

### 제출 일자

2024년 12월 26일 (목) 10:37

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

