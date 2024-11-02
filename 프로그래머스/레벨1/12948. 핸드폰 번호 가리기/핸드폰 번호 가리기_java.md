# [Lv.1] [핸드폰 번호 가리기](https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=java) - 12948 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(String phone_number) {
        return phone_number.replaceAll("\\d(?=\\d{4})", "*");
    }
}
```

### 성능 요약

1. 시간: 0.86 ms, 메모리: 74.5 MB

2. 시간: 0.73 ms, 메모리: 73.1 MB
3. 시간: 0.29 ms, 메모리: 74.7 MB
4. 시간: 0.29 ms, 메모리: 74 MB
5. 시간: 0.27 ms, 메모리: 72.4 MB

### 제출 일자

2024년 11월 02일 (토) 21:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges