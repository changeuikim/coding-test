# [Lv.1] [나누어 떨어지는 숫자 배열](https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=java) - 12910 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] result = Arrays.stream(arr)
                            .filter(e -> e % divisor == 0)
                            .sorted()
                            .toArray();
        return result.length == 0 ? new int[]{-1} : result;
    }
}
```

### 성능 요약

1. 시간: 13.90 ms, 메모리: 64.9 MB

2. 시간: 7.30 ms, 메모리: 91.7 MB
3. 시간: 4.56 ms, 메모리: 74 MB
4. 시간: 4.02 ms, 메모리: 71.2 MB
5. 시간: 3.80 ms, 메모리: 76.4 MB

### 제출 일자

2024년 11월 01일 (금) 22:28

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges