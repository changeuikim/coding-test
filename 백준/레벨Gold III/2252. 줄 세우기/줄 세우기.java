import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 인접리스트, 진입차수 초기화
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<List<Integer>> graph = new ArrayList<>();
        int[] ind = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph.get(u).add(v);
            ind[v]++;
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            if (ind[i] == 0) q.offer(i);
        }

        // 위상정렬    
        while (!q.isEmpty()) {
            int u = q.poll();

            sb.append(u).append(" ");

            for (int v : graph.get(u)) {
                ind[v]--;
                if (ind[v] == 0) q.offer(v);
            }
        }

        System.out.println(sb);
    }
}