# [Gold II] [문제집](https://www.acmicpc.net/problem/1766) - 1766 

NaN방향 비순환 그래프, 자료 구조, 그래프 이론, 우선순위 큐, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;

public class Main {
    private static int nextInt() throws IOException {
        int n = 0;
        int c;
        while ((c = System.in.read()) <= 32); // 탭 9, 개행 10, 공백 32
        do {
            n = n * 10 + (c - '0'); // 현재 자리를 추가
        } while ((c = System.in.read()) > 32); // 구분자 전까지
        return n;
    }

    public static void main(String[] args) throws IOException {
        // 인접리스트, 진입차수 초기화
        int N = nextInt();
        int M = nextInt();
        List<List<Integer>> graph = new ArrayList<>(N + 1);
        int[] inDegree = new int[N + 1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>(0));
        }

        while (M-- > 0) {
            int u = nextInt(), v = nextInt();
            graph.get(u).add(v);
            inDegree[v]++;
        }

        // 힙 초기화
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                pq.offer(i);
            }
        }

        // 위상 정렬
        while (!pq.isEmpty()) {
            int u = pq.poll();

            sb.append(u).append(" ");

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) pq.offer(v);
            }
        }

        System.out.println(sb);
    }
}
```

### 성능 요약

시간: 276 ms

메모리: 24536 KB

### 제출 일자

2024년 12월 13일 (금) 15:34

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

