# [Gold III] [음악프로그램](https://www.acmicpc.net/problem/2623) - 2623 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## Java 11 문제풀이

```Java 11
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Solution {
    public void topologicalSort() throws IOException {
        // 인접리스트, 진입차수 초기화
        int N = nextInt(), M = nextInt();
        List<List<Integer>> graph = new ArrayList<>(N+1);
        int[] inDegree = new int[N+1];

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        while (M-- > 0) {
            int length = nextInt();
            int u = nextInt();

            for (int i = 1; i < length; i++) {
                int v = nextInt();
                graph.get(u).add(v);
                inDegree[v]++;
                u = v;
            }
        }

        // 큐 초기화
        Queue<Integer> q = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                q.offer(i);
            }
        }

        // 위상 정렬
        while (!q.isEmpty()) {
            int u = q.poll();

            result.add(u);

            for (int v : graph.get(u)) {
                inDegree[v]--;
                if (inDegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // 사이클 확인
        if (result.size() == N) {
            System.out.println(result.stream()
                                     .map(String::valueOf)
                                     .collect(Collectors.joining("\n")));
        }
        else {
            System.out.println(0);
        }
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
        new Solution().topologicalSort();
    }
}
```

### 성능 요약

시간: 116 ms

메모리: 14464 KB

### 제출 일자

2024년 12월 15일 (일) 21:21

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

