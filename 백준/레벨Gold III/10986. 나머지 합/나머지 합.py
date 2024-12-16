from sys import stdin

input = stdin.readline

def range_sum():
    # 누적 합 초기화
    N, M = map(int, input().split())
    nums = list(map(int, input().split()))

    pre = [0] * (N + 1)
    for i in range(N):
        pre[i + 1] = (pre[i] + nums[i]) % M
    
    # 나머지 배열 초기화
    r = [0] * M
    for i in range(1, N+1):
        r[pre[i]] += 1
    
    # 조합
    count = r[0] # 누적합도 구간합
    for i in range(M):
        count += (r[i] * (r[i]-1)) // 2 # nC2 = n * n-1 / 2

    print(count)

range_sum()