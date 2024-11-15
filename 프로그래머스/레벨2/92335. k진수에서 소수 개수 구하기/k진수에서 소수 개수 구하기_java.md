# [Lv.2] [k진수에서 소수 개수 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/92335?language=java) - 92335 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
public class Solution {
    public static boolean isPrime(long num) {
        if (num < 2) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;

        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public static int solution(int n, int k) {
        String kNum = Integer.toString(n, k);
        int cnt = 0;

        String[] parts = kNum.split("0");
        for (String part : parts) {
            if (!part.isEmpty()) {
                long num = Long.parseLong(part);
                if (isPrime(num)) {
                    cnt++;
                }
            }
        }

        return cnt;
    }
}
```

### 성능 요약

1. 시간: 3.73 ms, 메모리: 73.9 MB

2. 시간: 0.24 ms, 메모리: 88.9 MB
3. 시간: 0.21 ms, 메모리: 80 MB
4. 시간: 0.15 ms, 메모리: 76 MB
5. 시간: 0.15 ms, 메모리: 72.7 MB

### 제출 일자

2024년 11월 15일 (금) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges