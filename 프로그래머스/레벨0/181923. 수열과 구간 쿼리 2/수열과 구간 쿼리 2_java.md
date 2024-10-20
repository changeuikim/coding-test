# [Lv.0] [수열과 구간 쿼리 2](https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=java) - 181923 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] result = new int[queries.length];
        Arrays.fill(result, -1);
        
        for (int idx = 0; idx < queries.length; idx++) {
            int s = queries[idx][0];
            int e = queries[idx][1];
            int k = queries[idx][2];

            int minVal = Integer.MAX_VALUE;

            for (int i = s; i <= e; i++) {
                if (arr[i] > k) {
                    minVal = Math.min(minVal, arr[i]);
                }
            }

            if (minVal != Integer.MAX_VALUE) {
                result[idx] = minVal;
            }
        }

        return result;
    }
}
```

### 성능 요약

1. 시간: 3.26 ms, 메모리: 84.9 MB

2. 시간: 3.08 ms, 메모리: 75.3 MB
3. 시간: 3.01 ms, 메모리: 84.6 MB
4. 시간: 2.57 ms, 메모리: 85.5 MB
5. 시간: 2.20 ms, 메모리: 77.5 MB

### 제출 일자

2024년 10월 20일 (일) 22:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges