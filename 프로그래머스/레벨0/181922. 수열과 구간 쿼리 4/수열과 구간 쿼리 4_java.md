# [Lv.0] [수열과 구간 쿼리 4](https://school.programmers.co.kr/learn/courses/30/lessons/181922?language=java) - 181922 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
public class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];

            for (int i = s; i <= e; i++) {
                if (i % k == 0) {
                    arr[i] += 1;
                }
            }
        }
        return arr;
    }
}

```

### 성능 요약

1. 시간: 1.87 ms, 메모리: 78.2 MB

2. 시간: 1.84 ms, 메모리: 80.2 MB
3. 시간: 1.70 ms, 메모리: 81.3 MB
4. 시간: 1.42 ms, 메모리: 76.3 MB
5. 시간: 1.38 ms, 메모리: 79.2 MB

### 제출 일자

2024년 10월 20일 (일) 23:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges