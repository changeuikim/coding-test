import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        // 거리배열 초기화
        final int MAX = 100001;
        int[] dist = new int[MAX];
        Arrays.fill(dist, -1);
        dist[N] = 0;

        // 0-1 BFS
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(N);
        int result = -1;

        while (!dq.isEmpty()) {
            int u = dq.removeFirst();

            if (u == K) {
                result = dist[u];
                break;
            }

            for (int[] next : new int[][]{{u * 2, 0}, {u - 1, 1}, {u + 1, 1}}) {
                int v = next[0], w = next[1];
                if (v >= 0 && v < MAX && dist[v] == -1) {
                    dist[v] = dist[u] + w;

                    if (w == 0) dq.addFirst(v);
                    else dq.addLast(v);
                }
            }
        }

        System.out.println(result);
    }
}