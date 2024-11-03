# [Lv.1] [행렬의 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=java) - 12950 

### 구분

코딩테스트 연습 > 연습문제

## Java 문제풀이

```java
class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j <arr1[0].length; j++) {
                arr1[i][j] += arr2[i][j];
            }
        }
        return arr1;
    }
}
```

### 성능 요약

1. 시간: 3.25 ms, 메모리: 128 MB

2. 시간: 0.28 ms, 메모리: 75.5 MB
3. 시간: 0.25 ms, 메모리: 84.9 MB
4. 시간: 0.24 ms, 메모리: 77.3 MB
5. 시간: 0.24 ms, 메모리: 76.7 MB

### 제출 일자

2024년 11월 03일 (일) 21:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges