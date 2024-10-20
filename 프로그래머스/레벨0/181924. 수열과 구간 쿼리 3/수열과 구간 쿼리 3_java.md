# [Lv.0] [수열과 구간 쿼리 3](https://school.programmers.co.kr/learn/courses/30/lessons/181924?language=java) - 181924 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## Java 문제풀이

```java
class Solution {    
    static void swap(int[] arr, int u, int v) {
        int temp = arr[u];
        arr[u] = arr[v];
        arr[v] = temp;
    }
    
    public int[] solution(int[] arr, int[][] queries) {        
        for (int[] query: queries) {
            swap(arr, query[0], query[1]);
        }
        
        return arr;
    }
}
```

### 성능 요약

1. 시간: 0.29 ms, 메모리: 79.2 MB

2. 시간: 0.09 ms, 메모리: 75.6 MB
3. 시간: 0.09 ms, 메모리: 69 MB
4. 시간: 0.09 ms, 메모리: 67.9 MB
5. 시간: 0.08 ms, 메모리: 79.7 MB

### 제출 일자

2024년 10월 20일 (일) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges