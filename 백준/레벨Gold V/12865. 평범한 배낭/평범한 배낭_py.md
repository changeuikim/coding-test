# [Gold V] [평범한 배낭](https://www.acmicpc.net/problem/12865) - 12865 

NaN다이나믹 프로그래밍, 배낭 문제

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

# 무게배열, 가치배열
N, K = map(int, input().split())

weight = [0] * (N+1)
value = [0] * (N+1)

for i in range(1, N+1):
    w, v = map(int, input().split())
    weight[i] = w
    value[i] = v

# 가치 DP
dp = [[0] * (K+1) for _ in range(N+1)]

# 루프 : 물건 -> 무게
for i in range(1, N+1):
    for w in range(1, K+1):
        # 0 : 현재무게 w보다 무거운 물건 i는 넣지않음
        if weight[i] > w:
            dp[i][w] = dp[i-1][w]
        # 1 : i를 넣지 않거나, i를 넣는 경우 중 큰 값값
        else:
            dp[i][w] = max(dp[i-1][w], dp[i-1][w-weight[i]] + value[i])

print(dp[N][K])
```

### 성능 요약

시간: 296 ms

메모리: 188728 KB

### 제출 일자

2024년 12월 13일 (금) 23:54

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

