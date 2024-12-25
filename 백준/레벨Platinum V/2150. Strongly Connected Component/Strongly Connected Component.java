import java.io.*;
import java.util.*;

class Kosaraju {
    static int V, E;
    static List<List<Integer>> fGraph;
    static List<List<Integer>> rGraph;
    static boolean[] visited;
    static Deque<Integer> orderStack;

    public void solution() throws IOException {
        // 정방향, 역방향 인접리스트 초기화
        V = nextInt();
        E = nextInt();
        fGraph = new ArrayList<>();
        rGraph = new ArrayList<>();

        for (int i = 0; i <= V; i++) {
            fGraph.add(new ArrayList<>());
            rGraph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int u = nextInt(), v = nextInt();
            fGraph.get(u).add(v);
            rGraph.get(v).add(u);
        }

        // 모든 정점에 대해 정방향 DFS
        visited = new boolean[V + 1];
        orderStack = new LinkedList<>();

        for (int u = 1; u <= V; u++) {
            if (!visited[u]) fDFS(u);
        }

        // 방문 정점에 대해 역방향 DFS
        visited = new boolean[V + 1];
        List<List<Integer>> sccList = new ArrayList<>();

        while (!orderStack.isEmpty()) {
            int v = orderStack.pop();
            if (!visited[v]) {
                List<Integer> curSCC = new LinkedList<>();
                rDFS(v, curSCC);
                Collections.sort(curSCC);
                sccList.add(curSCC);
            }
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

    static void fDFS(int u) {
        visited[u] = true;
        for (int v : fGraph.get(u)) {
            if (!visited[v]) fDFS(v);
        }
        // 정점방문 순서를 추가
        orderStack.push(u);        
    }

    static void rDFS(int v, List<Integer> curSCC) {
        visited[v] = true;
        // 현재 SCC를 구성
        curSCC.add(v);
        for (int u : rGraph.get(v)) {
          if (!visited[u]) rDFS(u, curSCC);
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
        new Kosaraju().solution();
    }
}
