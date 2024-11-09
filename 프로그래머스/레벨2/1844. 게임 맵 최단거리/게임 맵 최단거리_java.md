# [Lv.2] [게임 맵 최단거리](https://school.programmers.co.kr/learn/courses/30/lessons/1844?language=java) - 1844 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Java 문제풀이

```java
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int[][] maps) {
        // 초기화
        int n = maps.length;
        int m = maps[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // 동서남북
        int[][] distance = new int[n][m]; // 이동 칸 수
        for (int i = 0; i < n; i++) {
            Arrays.fill(distance[i], 1);
        }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0}); // (y, x)
        
        // BFS
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int y = cur[0];
            int x = cur[1];
            
            // 종료 조건 : n행 m열
            if (y == n - 1 && x == m - 1) {
                return distance[y][x];
            }
            
            // 방향 전환
            for (int[] d : directions) {
                int ny = y + d[0];
                int nx = x + d[1];
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (distance[ny][nx] == 1 && maps[ny][nx] == 1) {
                        distance[ny][nx] = distance[y][x] + 1;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }
        
        return -1;
    }
}
```

### 성능 요약

1. 시간: 13.88 ms, 메모리: 53 MB

2. 시간: 6.60 ms, 메모리: 56.1 MB
3. 시간: 6.03 ms, 메모리: 54.9 MB
4. 시간: 2.99 ms, 메모리: 52.7 MB
5. 시간: 0.21 ms, 메모리: 74.7 MB

### 제출 일자

2024년 11월 09일 (토) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges