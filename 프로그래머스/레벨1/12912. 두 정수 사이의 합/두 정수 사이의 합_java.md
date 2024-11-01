# [Lv.1] [두 정수 사이의 합](https://school.programmers.co.kr/learn/courses/30/lessons/12912?language=java) - 12912 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public long solution(int a, int b) {
        if (a > b) {
            int temp = a;
            a = b;
            b = temp;
        }
        
        long result = 0;
        for (int i = a; i <= b; i++) {
            result += i;
        }
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 19.53 ms, 메모리: 86 MB

2. 시간: 18.88 ms, 메모리: 76.6 MB
3. 시간: 9.90 ms, 메모리: 82.1 MB
4. 시간: 8.22 ms, 메모리: 74.9 MB
5. 시간: 7.89 ms, 메모리: 83.7 MB

### 제출 일자

2024년 11월 01일 (금) 18:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges