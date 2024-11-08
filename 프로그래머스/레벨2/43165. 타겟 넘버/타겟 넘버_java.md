# [Lv.2] [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=java) - 43165 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## Java 문제풀이

```java
class Solution {
    public static int dfs(int idx, int curSum, int maxSum, int[] numbers, int target) {
        // 베이스 케이스 Base Case
        if (idx == numbers.length) {
            return curSum == target ? 1 : 0;
        }

        // 가지치기 Pruning
        if (target > curSum + maxSum || target < curSum - maxSum) {
            return 0;
        }
        maxSum -= numbers[idx];

        // 재귀 Recursion
        return dfs(idx + 1, curSum - numbers[idx], maxSum, numbers, target) +
               dfs(idx + 1, curSum + numbers[idx], maxSum, numbers, target);
    }

    public static int solution(int[] numbers, int target) {
        int maxSum = 0;
        for (int num : numbers) {
            maxSum += num;
        }
        return dfs(0, 0, maxSum, numbers, target);
    }
}
```

### 성능 요약

1. 시간: 3.54 ms, 메모리: 72.7 MB

2. 시간: 3.14 ms, 메모리: 85.2 MB
3. 시간: 0.44 ms, 메모리: 77.9 MB
4. 시간: 0.34 ms, 메모리: 75.1 MB
5. 시간: 0.16 ms, 메모리: 78.6 MB

### 제출 일자

2024년 11월 08일 (금) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges