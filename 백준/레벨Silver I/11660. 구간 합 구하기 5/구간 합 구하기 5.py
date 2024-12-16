from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())

    nums = []
    for _ in range(N):
        nums.append(list(map(int, input().split())))

    pre = [[0] * (N + 1) for _ in range(N + 1)]
    for i in range(1, N+1):
        for j in range(1, N+1):
            pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + nums[i-1][j-1]
    
    # 구간 합 처리
    for _ in range(M):
        x1, y1, x2, y2 = map(int, input().split())

        t = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1]
        print(t)

range_sum()