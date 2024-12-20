# [Lv.2] [2개 이하로 다른 비트](https://school.programmers.co.kr/learn/courses/30/lessons/77885?language=java) - 77885 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## Java 문제풀이

```java
public class Solution {
    public static long[] solution(long[] numbers) {
        long[] result = new long[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            long num = numbers[i];
            
            // 첫번째 0은 1로, 뒤는 모두 0
            long biggerNum = num + 1;
            
            // 첫번째 0 이전은 0, 뒤는 모두 1
            long bitDiff = num ^ (num + 1);
            
            // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
            long minNum = biggerNum + (bitDiff >> 2);

            result[i] = minNum;
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 4.32 ms, 메모리: 108 MB

2. 시간: 2.92 ms, 메모리: 124 MB
3. 시간: 2.86 ms, 메모리: 119 MB
4. 시간: 2.83 ms, 메모리: 128 MB
5. 시간: 2.64 ms, 메모리: 111 MB

### 제출 일자

2024년 12월 02일 (월) 19:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges