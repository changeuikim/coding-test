# [Lv.2] [2 x n 타일링](https://school.programmers.co.kr/learn/courses/30/lessons/12900?language=python3) - 12900 

### 구분

코딩테스트 연습 > 연습문제

## Python 문제풀이

```py
def solution(n):
    MOD = 1000000007
    
    # 빠른 반환
    if n == 1 or n == 2:
        return n
    
    # DP 초기화
    dp = [0] * (n + 1)
    dp[1] = 1
    dp[2] = 2
    
    # DP 점화식
    for i in range(3, n + 1):
        dp[i] = (dp[i - 1] + dp[i - 2]) % MOD
    
    return dp[n]
```

### 성능 요약

1. 시간: 12.03 ms, 메모리: 11.8 MB

2. 시간: 8.64 ms, 메모리: 11.2 MB
3. 시간: 6.90 ms, 메모리: 11 MB
4. 시간: 5.11 ms, 메모리: 10.5 MB
5. 시간: 4.29 ms, 메모리: 10.5 MB

### 제출 일자

2024년 11월 29일 (금) 22:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges