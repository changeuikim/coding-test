# [Lv.3] [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=javascript) - 42898 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## JavaScript 문제풀이

```js
function solution(m, n, puddles) {
    const MOD = 1000000007;
    const dp = Array.from({ length: n + 1 }, () => Array(m + 1).fill(0));
    
    dp[1][1] = 1;
    for (const [x, y] of puddles) {
        dp[y][x] = -1;
    }
    
    for (let y = 1; y <= n; y++) {
        for (let x = 1; x <= m; x++) {
            if (dp[y][x] === -1) {
                dp[y][x] = 0;
            } else if (!(y === 1 && x === 1)) {
                dp[y][x] = ((dp[y - 1][x] || 0) + (dp[y][x - 1] || 0)) % MOD;
            }
        }
    }

    return dp[n][m];
}
```

### 성능 요약

1. 시간: 0.92 ms, 메모리: 33.1 MB

2. 시간: 0.90 ms, 메모리: 33 MB
3. 시간: 0.79 ms, 메모리: 33.5 MB
4. 시간: 0.78 ms, 메모리: 33.1 MB
5. 시간: 0.75 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 24일 (일) 23:23

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges