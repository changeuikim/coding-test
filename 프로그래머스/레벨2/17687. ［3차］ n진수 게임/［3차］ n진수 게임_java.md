# [Lv.2] [[3차] n진수 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17687?language=java) - 17687 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder res = new StringBuilder();
        StringBuilder seq = new StringBuilder();
        int num = 0;

        while (res.length() < t) {
            if (seq.length() >= m) {
                res.append(seq.charAt(p - 1));
                seq.delete(0, m);
            } else {
                seq.append(Integer.toString(num++, n).toUpperCase());
            }
        }

        return res.toString();
    }
}
```

### 성능 요약

1. 시간: 14.65 ms, 메모리: 90.1 MB

2. 시간: 13.99 ms, 메모리: 82.3 MB
3. 시간: 12.87 ms, 메모리: 83.4 MB
4. 시간: 7.20 ms, 메모리: 81.8 MB
5. 시간: 6.50 ms, 메모리: 78.3 MB

### 제출 일자

2024년 11월 11일 (월) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges