import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 인접리스트, 진입차수 초기화
        int N = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inDegree = new int[N + 1];
        int[] buildTime = new int[N + 1];

        for (int v = 1; v <= N ; v++) {
            st = new StringTokenizer(br.readLine());
            buildTime[v] = Integer.parseInt(st.nextToken());

            while (st.hasMoreTokens()) {
                int u = Integer.parseInt(st.nextToken());
                if (u == -1) break;
                graph.get(u).add(v);
                inDegree[v]++;
            }
        }

        // 위상정렬
        Queue<Integer> q = new LinkedList<>();
        int[] result = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
                result[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : graph.get(u)) {
                inDegree[v]--;
                result[v] = Math.max(result[v], result[u] + buildTime[v]);
                if (inDegree[v] == 0) q.offer(v);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]).append("\n");
        }

        System.out.println(sb);
    }
}