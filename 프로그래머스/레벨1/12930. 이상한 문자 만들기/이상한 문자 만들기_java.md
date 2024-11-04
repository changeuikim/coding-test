# [Lv.1] [이상한 문자 만들기](https://school.programmers.co.kr/learn/courses/30/lessons/12930?language=java) - 12930 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        int wordIdx = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == ' ') {
                sb.append(' ');
                wordIdx = 0;
            } else {
                if (wordIdx % 2 == 0) {
                    sb.append(Character.toUpperCase(c));
                } else {
                    sb.append(Character.toLowerCase(c));
                }
                wordIdx++;
            }            
        }
        
        return sb.toString();
    }
}
```

### 성능 요약

1. 시간: 0.11 ms, 메모리: 77.8 MB

2. 시간: 0.10 ms, 메모리: 76.2 MB
3. 시간: 0.10 ms, 메모리: 75.5 MB
4. 시간: 0.10 ms, 메모리: 74 MB
5. 시간: 0.09 ms, 메모리: 77.2 MB

### 제출 일자

2024년 11월 04일 (월) 23:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges