# [Platinum V] [Strongly Connected Component](https://www.acmicpc.net/problem/2150) - 2150 

NaN그래프 이론, 강한 연결 요소

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Tarjan {
    static int V, E;
    static List<List<Integer>> graph;
    // SSC 후보 스택, 정점의 스택 포함 여부
    static Deque<Integer> sccStack;
    static boolean[] inStack;
    // DFS 방문순서, 카운터
    static int[] visited;
    static int visitedCount;
    // SSC 목록
    static List<List<Integer>> sccList;

    public void solution() throws IOException {
        // 정방향, 역방향 인접리스트 초기화
        V = nextInt();
        E = nextInt();
        graph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = nextInt(), v = nextInt();
            graph.get(u).add(v);
        }

        sccStack = new LinkedList<>();
        inStack = new boolean[V + 1];
        visited = new int[V + 1];
        visitedCount = 0;
        sccList = new ArrayList<>();

        Arrays.fill(visited, -1);

        // 모든 정점에 대해 DFS
        for (int u = 1; u <= V; u++) {
            if (visited[u] == -1) dfs(u);
        }       
        
        // 첫줄에 SCC의 개수 K를 출력
        // 다음 K개의 줄에는 각 줄에 하나의 SCC에 속한 정점의 번호를 출력
        Collections.sort(sccList, (a, b) -> a.get(0) - b.get(0));

        StringBuilder sb = new StringBuilder();
        sb.append(sccList.size()).append('\n');
        for (List<Integer> scc : sccList) {
            for (int v : scc) {
                sb.append(v).append(' ');
            }
            sb.append("-1\n");
        }        

        System.out.println(sb);        
    }

    static int dfs(int u) {
        // low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
        visited[u] = visitedCount;
        int low = visitedCount++;

        // 스택에 u를 추가
        sccStack.push(u);
        inStack[u] = true;

        // 인접 정점을 탐색
        for (int v : graph.get(u)) {
            // v 방문 전이면 dfs(v)후 low 갱신
            if (visited[v] == -1) {
                low = Math.min(low, dfs(v)); // 두번째 low : 자식 정점의 방문 순서
            }
            // 방문했지만 SSC 후보라면 low 갱신
            else if (inStack[v]) {
                low = Math.min(low, visited[v]); // 세번째 low : 스택에 있는 방문 순서
            }            
        }
        
        // low가 방문순서와 동일 : 먼저 방문된 노드로 돌아갈 수 없어서 여기가 SSC 루트
        if (low == visited[u]) {
            List<Integer> curSCC = new ArrayList<>();
    
            // SCC 구성하기
            while (true) {
                int top = sccStack.pop();
                inStack[top] = false;
                curSCC.add(top);
                if (top == u) break;
            }
            Collections.sort(curSCC);
            sccList.add(curSCC);
        }
    
        return low;
    };

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
        new Tarjan().solution();
    }
}

```

### 성능 요약

시간: 272 ms

메모리: 26300 KB

### 제출 일자

2024년 12월 25일 (수) 21:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

