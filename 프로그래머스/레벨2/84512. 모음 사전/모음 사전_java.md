# [Lv.2] [모음 사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=java) - 84512 

### 구분

코딩테스트 연습 > 완전탐색

## Java 문제풀이

```java
class Solution {
    public int solution(String word) {
        String dic = "AEIOU";
        int acc = word.length();

        for (int i = 0, b = 1; i < word.length(); i++, b *= 5) {
            acc += dic.indexOf(word.charAt(i)) * 781 / b;
        }

        return acc;
    }
}

```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 73 MB

2. 시간: 0.05 ms, 메모리: 67.9 MB
3. 시간: 0.04 ms, 메모리: 82.3 MB
4. 시간: 0.04 ms, 메모리: 78.9 MB
5. 시간: 0.04 ms, 메모리: 77.4 MB

### 제출 일자

2024년 11월 16일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges