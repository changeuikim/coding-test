# [Lv.1] [나머지가 1이 되는 수 찾기](https://school.programmers.co.kr/learn/courses/30/lessons/87389?language=java) - 87389 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

## Java 문제풀이

```java
class Solution {
    public int solution(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }
        return n - 1;
    }
}
```

### 성능 요약

1. 시간: 5.04 ms, 메모리: 74.4 MB

2. 시간: 0.04 ms, 메모리: 68.5 MB
3. 시간: 0.03 ms, 메모리: 80.1 MB
4. 시간: 0.03 ms, 메모리: 77.6 MB
5. 시간: 0.03 ms, 메모리: 77.4 MB

### 제출 일자

2024년 11월 01일 (금) 18:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges