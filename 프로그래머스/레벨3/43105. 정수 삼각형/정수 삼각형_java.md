# [Lv.3] [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=java) - 43105 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## Java 문제풀이

```java
class Solution {
    public int solution(int[][] triangle) {
        // bottom-up DP
        for (int row = triangle.length - 2; row >= 0; row--) {
            for (int col = 0; col < triangle[row].length; col++) {
                int left = triangle[row + 1][col];
                int right = triangle[row + 1][col + 1];
                triangle[row][col] += (left > right) ? left : right;
            }
        }
        return triangle[0][0];
    }
}
```

### 성능 요약

1. 시간: 8.59 ms, 메모리: 60.9 MB

2. 시간: 7.71 ms, 메모리: 55.8 MB
3. 시간: 7.39 ms, 메모리: 60.9 MB
4. 시간: 7.20 ms, 메모리: 61.1 MB
5. 시간: 6.66 ms, 메모리: 57 MB

### 제출 일자

2024년 11월 07일 (목) 23:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges