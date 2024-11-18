# [Lv.2] [땅따먹기](https://school.programmers.co.kr/learn/courses/30/lessons/12913?language=java) - 12913 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    int solution(int[][] land) {
        int n = land.length;
        int m = 4;
        
        // 2행부터 DP
        for (int i = 1; i < n; i++) {
            int max1 = -1, idx = -1, max2 = -1;
            
            // 이전행 최대, 차대 찾기
            for (int j = 0; j < m; j++) {
                int cur = land[i - 1][j];
                
                if (cur > max1) {
                    max2 = max1;
                    max1 = cur;
                    idx = j;
                } 
                else if (cur > max2) {
                    max2 = cur;
                }
            }
            
            // 이번행 DP
            for (int j = 0; j < m; j++) {
                int prev = max1;
                if (j == idx) {
                    prev = max2;
                }
                
                land[i][j] += prev;
            }
        }

        return Arrays.stream(land[n - 1]).max().getAsInt();
    }
}
```

### 성능 요약

1. 시간: 12.41 ms, 메모리: 86 MB

2. 시간: 12.29 ms, 메모리: 86.5 MB
3. 시간: 11.81 ms, 메모리: 86.6 MB
4. 시간: 11.14 ms, 메모리: 85.7 MB
5. 시간: 2.12 ms, 메모리: 76.7 MB

### 제출 일자

2024년 11월 18일 (월) 22:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges