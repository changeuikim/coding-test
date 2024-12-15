from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))
    prefix_sum = [0] * (N + 1)

    for i in range(N):
        prefix_sum[i + 1] = prefix_sum[i] + nums[i]

    # 구간 합 출력
    for _ in range(M):
        i, j = map(int, input().split())
        print(prefix_sum[j] - prefix_sum[i - 1])

range_sum()