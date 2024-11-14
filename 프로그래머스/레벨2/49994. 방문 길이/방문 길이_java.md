# [Lv.2] [방문 길이](https://school.programmers.co.kr/learn/courses/30/lessons/49994?language=java) - 49994 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int solution(String dirs) {
        // 방향 설정, 방문 기록, 초기 위치
        Map<Character, int[]> directions = new HashMap<>();
        directions.put('U', new int[]{0, 1});
        directions.put('D', new int[]{0, -1});
        directions.put('R', new int[]{1, 0});
        directions.put('L', new int[]{-1, 0});
        
        Set<String> visited = new HashSet<>();
        int x = 0, y = 0;
        
        // 방향 전환 및 이동 처리
        for (char d : dirs.toCharArray()) {
            int dx = directions.get(d)[0];
            int dy = directions.get(d)[1];
            int nx = x + dx;
            int ny = y + dy;
            
            if (-5 <= nx && nx <= 5 && -5 <= ny && ny <= 5) {
                // 작은 좌표를 항상 시작점으로 정렬
                int[][] path = {{x, y}, {nx, ny}};
                Arrays.sort(path, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
                
                visited.add(Arrays.deepToString(path));
                x = nx;
                y = ny;
            }
        }
        
        // 집합의 길이를 반환
        return visited.size();
    }
}
```

### 성능 요약

1. 시간: 4.23 ms, 메모리: 77.2 MB

2. 시간: 2.94 ms, 메모리: 78.6 MB
3. 시간: 2.82 ms, 메모리: 76.6 MB
4. 시간: 2.73 ms, 메모리: 77.6 MB
5. 시간: 2.60 ms, 메모리: 73.2 MB

### 제출 일자

2024년 11월 14일 (목) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges