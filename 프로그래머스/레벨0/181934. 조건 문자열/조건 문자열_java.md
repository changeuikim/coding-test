# [Lv.0] [조건 문자열](https://school.programmers.co.kr/learn/courses/30/lessons/181934?language=java) - 181934 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {
    public int solution(String ineq, String eq, int n, int m) {
        if (ineq.equals(">") && eq.equals("=")) {
            return n >= m ? 1 : 0;
        }    
        else if (ineq.equals(">") && eq.equals("!")) {
            return n > m ? 1 : 0;
        }
        else if (ineq.equals("<") && eq.equals("=")) {
            return n <= m ? 1 : 0;
        }    
        else if (ineq.equals("<") && eq.equals("!")) {
            return n < m ? 1 : 0;
        }
        return 0;
    }
}
```

### 성능 요약

1. 시간: 0.04 ms, 메모리: 73.4 MB

2. 시간: 0.03 ms, 메모리: 84.7 MB
3. 시간: 0.03 ms, 메모리: 81 MB
4. 시간: 0.03 ms, 메모리: 80.2 MB
5. 시간: 0.03 ms, 메모리: 79.9 MB

### 제출 일자

2024년 10월 18일 (금) 01:19

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges