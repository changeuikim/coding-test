# [Lv.0] [원소들의 곱과 합](https://school.programmers.co.kr/learn/courses/30/lessons/181929?language=java) - 181929 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.stream.IntStream;

class Solution {
    public int solution(int[] num_list) {
        int product = IntStream.of(num_list).reduce(1, (acc, val) -> acc * val);
        int sumSquare = (int) Math.pow(IntStream.of(num_list).sum(), 2);
        
        return product < sumSquare ? 1 : 0;
    }
}
```

### 성능 요약

1. 시간: 1.53 ms, 메모리: 74.3 MB

2. 시간: 1.50 ms, 메모리: 79.2 MB
3. 시간: 1.48 ms, 메모리: 72.5 MB
4. 시간: 1.47 ms, 메모리: 73.6 MB
5. 시간: 1.43 ms, 메모리: 90.1 MB

### 제출 일자

2024년 10월 18일 (금) 10:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges