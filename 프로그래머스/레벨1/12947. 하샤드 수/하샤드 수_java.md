# [Lv.1] [하샤드 수](https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=java) - 12947 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public boolean solution(int x) {
        int sum = 0, num = x;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return x % sum == 0;
    }
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 72.6 MB

2. 시간: 0.04 ms, 메모리: 77.1 MB
3. 시간: 0.03 ms, 메모리: 79.8 MB
4. 시간: 0.03 ms, 메모리: 78 MB
5. 시간: 0.03 ms, 메모리: 77 MB

### 제출 일자

2024년 11월 01일 (금) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges