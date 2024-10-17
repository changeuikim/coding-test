# [Lv.0] [코드 처리하기](https://school.programmers.co.kr/learn/courses/30/lessons/181932?language=java) - 181932 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public String solution(String code) {
        int mode = 0;
        StringBuilder ret = new StringBuilder();
        
        for (int idx = 0; idx < code.length(); idx++) {
            if (code.charAt(idx) == '1') {
                mode ^= 1;
            } else {
                if ((idx&1) == mode) {
                    ret.append(code.charAt(idx));
                }
            }
        }
        
        return ret.length() > 0 ? ret.toString() : "EMPTY";
    }
}

```

### 성능 요약

1. 시간: 8.77 ms, 메모리: 79.1 MB

2. 시간: 8.25 ms, 메모리: 80.6 MB
3. 시간: 7.63 ms, 메모리: 74.4 MB
4. 시간: 7.56 ms, 메모리: 86.1 MB
5. 시간: 6.98 ms, 메모리: 78.3 MB

### 제출 일자

2024년 10월 18일 (금) 08:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges