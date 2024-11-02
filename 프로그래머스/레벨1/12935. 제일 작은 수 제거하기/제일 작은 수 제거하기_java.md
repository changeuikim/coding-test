# [Lv.1] [제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=java) - 12935 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int minNum = Arrays.stream(arr).min().getAsInt();
        int[] result = Arrays.stream(arr)
                            .filter(num -> num > minNum)
                            .toArray();
        return result.length > 0 ? result : new int[]{-1};
    }
}
```

### 성능 요약

1. 시간: 8.54 ms, 메모리: 90.6 MB

2. 시간: 4.53 ms, 메모리: 78.2 MB
3. 시간: 4.16 ms, 메모리: 82.2 MB
4. 시간: 4.06 ms, 메모리: 81.4 MB
5. 시간: 4.00 ms, 메모리: 79.2 MB

### 제출 일자

2024년 11월 02일 (토) 20:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges