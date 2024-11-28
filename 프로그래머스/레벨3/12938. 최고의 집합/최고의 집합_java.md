# [Lv.3] [최고의 집합](https://school.programmers.co.kr/learn/courses/30/lessons/12938?language=java) - 12938 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int s) {
        if (n > s) {
            return new int[]{-1};
        }

        int q = s / n;
        int r = s % n;
        int[] result = new int[n];
        Arrays.fill(result, q);

        for (int i = n - r; i < n; i++) {
            result[i] += 1;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 0.28 ms, 메모리: 56.2 MB

2. 시간: 0.21 ms, 메모리: 72 MB
3. 시간: 0.16 ms, 메모리: 87.5 MB
4. 시간: 0.15 ms, 메모리: 54.7 MB
5. 시간: 0.14 ms, 메모리: 73.4 MB

### 제출 일자

2024년 11월 28일 (목) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges