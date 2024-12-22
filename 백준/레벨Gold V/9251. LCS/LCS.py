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