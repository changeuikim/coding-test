# [Lv.1] [3진법 뒤집기](https://school.programmers.co.kr/learn/courses/30/lessons/68935?language=java) - 68935 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## Java 문제풀이

```java
class Solution {
    public int solution(int n) {
        StringBuilder base3 = new StringBuilder();
        while (n > 0) {
            base3.append(n % 3);
            n /= 3;
        }
        return Integer.parseInt(base3.toString(), 3);
    }
}
```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 81.1 MB

2. 시간: 0.06 ms, 메모리: 76.4 MB
3. 시간: 0.06 ms, 메모리: 74.7 MB
4. 시간: 0.06 ms, 메모리: 74.5 MB
5. 시간: 0.06 ms, 메모리: 72.4 MB

### 제출 일자

2024년 11월 05일 (화) 23:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges