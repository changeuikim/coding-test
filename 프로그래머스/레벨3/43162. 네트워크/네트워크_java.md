# [Lv.3] [네트워크](https://school.programmers.co.kr/learn/courses/30/lessons/43162?language=java) - 43162 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Java 문제풀이

```java
class Solution {
    public static void dfs(int i, boolean[] visited, int[][] computers) {
        visited[i] = true;
        for (int j = 0; j < computers[i].length; j++) {
            if (!visited[j] && computers[i][j] == 1) {
                dfs(j, visited, computers);
            }
        }
    }
    
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int count = 0;
        
        for (int i = 0; i < computers.length; i++) {
            if (!visited[i]) {
                dfs(i, visited, computers);
                count++;
            }
        }
        
        return count;
    }
}
```

### 성능 요약

1. 시간: 0.18 ms, 메모리: 75.5 MB

2. 시간: 0.15 ms, 메모리: 79.4 MB
3. 시간: 0.09 ms, 메모리: 77.1 MB
4. 시간: 0.09 ms, 메모리: 76.5 MB
5. 시간: 0.06 ms, 메모리: 78.9 MB

### 제출 일자

2024년 11월 08일 (금) 22:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges