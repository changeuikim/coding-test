# [Lv.0] [문자열 겹쳐쓰기](https://school.programmers.co.kr/learn/courses/30/lessons/181943?language=java) - 181943 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string);
        sb.replace(s, s + overwrite_string.length(), overwrite_string);
        return sb.toString();
    }
}
```

### 성능 요약

1. 시간: 0.09 ms, 메모리: 71.4 MB

2. 시간: 0.07 ms, 메모리: 77.3 MB
3. 시간: 0.07 ms, 메모리: 76.8 MB
4. 시간: 0.06 ms, 메모리: 77.2 MB
5. 시간: 0.06 ms, 메모리: 72.1 MB

### 제출 일자

2024년 10월 18일 (금) 01:28

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges