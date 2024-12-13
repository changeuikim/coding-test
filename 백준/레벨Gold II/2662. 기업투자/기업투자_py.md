# [Gold II] [기업투자](https://www.acmicpc.net/problem/2662) - 2662 

NaN다이나믹 프로그래밍, 배낭 문제

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

# 이익 2차원 배열 : n축 금액, m축 기업
N, M = map(int, input().split())
profit = [[0] * (M+1)]

for _ in range(N):
    line = list(map(int, input().split()))
    profit.append(line)

# 누산 DP, 기업별 memo
dp = [[0] * (M+1) for _ in range(N+1)]
memo = [[0] * (M+1) for _ in range(N+1)]

# 루프 : 기업 -> 투자액 -> 변동폭
# 점화식 : dp[N][다음] = dp[N-k][이전] + profit[k][다음]
for i in range(1, M+1):
    for j in range(N+1):        
        for k in range(j+1):
            cur_profit = dp[j-k][i-1] + profit[k][i]
            if cur_profit > dp[j][i]:
                dp[j][i] = cur_profit
                memo[j][i] = k

print(dp[N][M])

# memo[N][M]부터 N을 차감하며 역추적
corp = [0] * (M+1)
r = N

for i in range(M, 0, -1):
    corp[i] = memo[r][i]
    r -= memo[r][i]

print(*corp[1:])
```

### 성능 요약

시간: 108 ms

메모리: 111252 KB

### 제출 일자

2024년 12월 13일 (금) 23:18

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

