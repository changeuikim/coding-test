# [Lv.2] [타겟 넘버](https://school.programmers.co.kr/learn/courses/30/lessons/43165?language=javascript) - 43165 

### 구분

코딩테스트 연습 > 깊이／너비 우선 탐색（DFS／BFS）

## JavaScript 문제풀이

```js
const dfs = (idx, curSum, maxSum, numbers, target) => {
    // 베이스 케이스 Base Case
    if (idx === numbers.length) {
        return curSum === target ? 1 : 0;
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

function solution(numbers, target) {    
    const maxSum = numbers.reduce((acc, cur) => acc + cur, 0);
    return dfs(0, 0, maxSum, numbers, target);
}
```

### 성능 요약

1. 시간: 10.59 ms, 메모리: 35.5 MB

2. 시간: 7.95 ms, 메모리: 35.4 MB
3. 시간: 1.75 ms, 메모리: 35.4 MB
4. 시간: 1.52 ms, 메모리: 35.5 MB
5. 시간: 0.23 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 08일 (금) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges