# [Lv.1] [시저 암호](https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=java) - 12926 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                sb.append(c);
            } else if (Character.isUpperCase(c)) {
                sb.append((char) ((c - 'A' + n) % 26 + 'A'));
            } else {
                sb.append((char) ((c - 'a' + n) % 26 + 'a'));
            }
        }
        
        return sb.toString();
    }
}
```

### 성능 요약

1. 시간: 1.42 ms, 메모리: 76.3 MB

2. 시간: 0.15 ms, 메모리: 75 MB
3. 시간: 0.07 ms, 메모리: 78.1 MB
4. 시간: 0.07 ms, 메모리: 71.8 MB
5. 시간: 0.06 ms, 메모리: 82.6 MB

### 제출 일자

2024년 11월 06일 (수) 19:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges