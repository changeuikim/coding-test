# [Lv.1] [문자열 내 p와 y의 개수](https://school.programmers.co.kr/learn/courses/30/lessons/12916?language=java) - 12916 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    boolean solution(String s) {
        s = s.toLowerCase();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'p') {
                cnt++;
            } else if (ch == 'y') {
                cnt--;
            }
        }
        return cnt == 0;
    }
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 76.4 MB

2. 시간: 0.05 ms, 메모리: 75.7 MB
3. 시간: 0.05 ms, 메모리: 74.2 MB
4. 시간: 0.05 ms, 메모리: 72.4 MB
5. 시간: 0.05 ms, 메모리: 72.3 MB

### 제출 일자

2024년 11월 01일 (금) 19:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges