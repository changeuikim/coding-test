# [Lv.1] [크기가 작은 부분문자열](https://school.programmers.co.kr/learn/courses/30/lessons/147355?language=java) - 147355 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            String window = t.substring(i, i + p.length());
            if (window.compareTo(p) <= 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
```

### 성능 요약

1. 시간: 2.73 ms, 메모리: 75 MB

2. 시간: 2.71 ms, 메모리: 72.6 MB
3. 시간: 2.61 ms, 메모리: 86 MB
4. 시간: 2.31 ms, 메모리: 75.4 MB
5. 시간: 2.29 ms, 메모리: 74.3 MB

### 제출 일자

2024년 11월 04일 (월) 21:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges