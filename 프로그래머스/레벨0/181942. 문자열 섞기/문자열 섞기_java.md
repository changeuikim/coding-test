# [Lv.0] [문자열 섞기](https://school.programmers.co.kr/learn/courses/30/lessons/181942?language=java) - 181942 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public String solution(String str1, String str2) {
        int size = str1.length();
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < size; i++) {
            sb.append(str1.charAt(i)).append(str2.charAt(i));
        }
        
        return sb.toString();
    }
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 77.9 MB

2. 시간: 0.05 ms, 메모리: 73 MB
3. 시간: 0.05 ms, 메모리: 69.7 MB
4. 시간: 0.04 ms, 메모리: 86.7 MB
5. 시간: 0.04 ms, 메모리: 81.3 MB

### 제출 일자

2024년 10월 17일 (목) 01:06

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges