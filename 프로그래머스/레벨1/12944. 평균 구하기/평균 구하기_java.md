# [Lv.1] [평균 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/12944?language=java) - 12944 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public double solution(int[] arr) {        
        return Arrays.stream(arr).average().orElse(0.0);
    }
}
```

### 성능 요약

1. 시간: 2.82 ms, 메모리: 75.6 MB

2. 시간: 2.81 ms, 메모리: 78 MB
3. 시간: 2.71 ms, 메모리: 76.8 MB
4. 시간: 2.65 ms, 메모리: 77.7 MB
5. 시간: 2.64 ms, 메모리: 77.3 MB

### 제출 일자

2024년 10월 31일 (목) 20:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges