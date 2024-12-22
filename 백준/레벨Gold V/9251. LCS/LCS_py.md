# [Gold V] [LCS](https://www.acmicpc.net/problem/9251) - 9251 

NaN다이나믹 프로그래밍, 문자열

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def LCS_2D():
    word1 = input().rstrip()
    word2 = input().rstrip()
    N, M = len(word1), len(word2)

    # dp[i + 1][j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
    dp = [[0] * (M + 1) for _ in range(N + 1)]

    for i in range(1, N + 1):
        for j in range(1, M + 1):
            # 문자가 같음 : 좌상방 대각선 + 1
            if word1[i - 1] == word2[j - 1]:
                dp[i][j] = dp[i - 1][j - 1] + 1
            # 문자가 다름 : 위쪽 또는 왼쪽 중 큰 값
            else:
                dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

    print(dp[N][M])

def LCS_1D():
    word1 = input().rstrip()
    word2 = input().rstrip()
    N, M = len(word1), len(word2)

    # dp[j + 1]: word1[:i]일때 word2[:j]와의 LCS 길이
    dp = [0] * (M + 1)

    for i in range(1, N + 1):
        pre = 0 # 이전 행의 LCS 값
        for j in range(1, M + 1):
            # 문자가 다름 : dp[i][j] = max(dp[i-1][j], dp[i][j-1])
            if pre < dp[j]:
                pre = dp[j]
            # 문자가 같음 : dp[j] = dp[i-1][j-1] + 1
            elif word1[i - 1] == word2[j - 1]:
                dp[j] = pre + 1

    print(max(dp))

# LCS_2D()
LCS_1D()
```

### 성능 요약

시간: 108 ms

메모리: 110760 KB

### 제출 일자

2024년 12월 22일 (일) 22:27

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

