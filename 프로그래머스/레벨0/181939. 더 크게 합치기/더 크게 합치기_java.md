# [Lv.0] [더 크게 합치기](https://school.programmers.co.kr/learn/courses/30/lessons/181939?language=java) - 181939 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public int solution(int a, int b) {
        int a_num = Integer.parseInt(String.format("%d%d", a, b));
        int b_num = Integer.parseInt(String.format("%d%d", b, a));
        return Integer.max(a_num, b_num);
    }
}
```

### 성능 요약

1. 시간: 1.12 ms, 메모리: 78.9 MB

2. 시간: 1.11 ms, 메모리: 65.1 MB
3. 시간: 1.09 ms, 메모리: 74.8 MB
4. 시간: 1.04 ms, 메모리: 73.4 MB
5. 시간: 1.03 ms, 메모리: 76.5 MB

### 제출 일자

2024년 10월 17일 (목) 02:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges