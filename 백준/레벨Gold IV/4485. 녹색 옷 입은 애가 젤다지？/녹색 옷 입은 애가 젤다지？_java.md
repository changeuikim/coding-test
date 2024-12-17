# [Gold IV] [녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485) - 4485 

NaN데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

class Node {
    int rupee, y, x;

    public Node(int rupee, int y, int x) {
        this.rupee = rupee;
        this.y = y;
        this.x = x;
    }
}

class Solution {
    public void dijkstra() throws IOException {
        List<Integer> result = new ArrayList<>();
        
        while (true) {
            int N = nextInt();
            if (N == 0) break;
            
            // 동굴 초기화
            int[][] cave = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    cave[i][j] = nextInt();
                }
            }

            // 방향 초기화 : 상하좌우
            int[] dy = {-1, 1, 0, 0};
            int[] dx = {0, 0, -1, 1};            

            // 힙, dp 초기화
            int start = cave[0][0];
            PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.rupee - b.rupee);
            pq.offer(new Node(start, 0, 0));
            
            int MAX = N * N * 9 + 1;
            int[][] dp = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[i], MAX);
            }
            dp[0][0] = start;
            
            // 다익스트라
            while (!pq.isEmpty()) {
                Node node = pq.poll();
                int cur = node.rupee, y = node.y, x = node.x;
                
                if (y == N - 1 && x == N - 1) break;
                
                for (int i = 0; i < 4; i++) {
                    int ny = y + dy[i];
                    int nx = x + dx[i];
                    
                    if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                        int nxt = cur + cave[ny][nx];
                        if (dp[ny][nx] > nxt) {
                            pq.offer(new Node(nxt, ny, nx));
                            dp[ny][nx] = nxt;
                        }
                    }
                }
            }
            
            result.add(dp[N-1][N-1]);
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.size(); i++) {
            sb.append(String.format("Problem %d: %d\n", i + 1, result.get(i)));
        }

        System.out.println(sb);
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
        new Solution().dijkstra();
    }
}
```

### 성능 요약

시간: 176 ms

메모리: 18896 KB

### 제출 일자

2024년 12월 17일 (화) 14:31

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

