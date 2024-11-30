# [Lv.3] [단속카메라](https://school.programmers.co.kr/learn/courses/30/lessons/42884?language=java) - 42884 

### 구분

코딩테스트 연습 > 탐욕법（Greedy）

## Java 문제풀이

```java
import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        int camera = -30001;
        int result = 0;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for (int[] route : routes) {
            if (camera < route[0]) {
                result++;
                camera = route[1];
            }
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 14.00 ms, 메모리: 55.4 MB

2. 시간: 10.32 ms, 메모리: 55.4 MB
3. 시간: 3.84 ms, 메모리: 54.7 MB
4. 시간: 2.74 ms, 메모리: 72.8 MB
5. 시간: 1.01 ms, 메모리: 54.1 MB

### 제출 일자

2024년 11월 30일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges