# [Lv.3] [등굣길](https://school.programmers.co.kr/learn/courses/30/lessons/42898?language=python3) - 42898 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## Python 문제풀이

```py
def solution(m, n, puddles):
    MOD = 1000000007    
    dp = [[0] * (m + 1) for _ in range(n + 1)]           
    
    dp[1][1] = 1
    for x, y in puddles:
        dp[y][x] = -1
        
    for y in range(1, n + 1):
        for x in range(1, m + 1):
            if dp[y][x] == -1:
                dp[y][x] = 0
            else:
                dp[y][x] += (dp[y - 1][x] + dp[y][x - 1]) % MOD
    
    return dp[n][m]
```

### 성능 요약

1. 시간: 2.44 ms, 메모리: 10.2 MB

2. 시간: 2.13 ms, 메모리: 10.3 MB
3. 시간: 2.06 ms, 메모리: 10.2 MB
4. 시간: 1.80 ms, 메모리: 10.3 MB
5. 시간: 1.71 ms, 메모리: 10.2 MB

### 제출 일자

2024년 11월 24일 (일) 23:22

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges