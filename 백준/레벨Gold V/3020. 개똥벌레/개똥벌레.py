from sys import stdin

input = stdin.readline

# N = 2 * 10^5, H = 5 * 10^5, 최대 10^11
# 일반적인 2차원 배열로는 O(N^2)를 못쓴다

def even_and_odd():
    N, H = map(int, input().split())

    # 석순 even, 종유석 odd
    even = [0] * H
    odd = [0] * H

    # 너비 압축
    for i in range(N):
        t = int(input())
        if i % 2 == 0:
            even[t-1] += 1
        else:
            odd[H - t] += 1

    # 석순 : 위 -> 아래 누적합
    for i in range(H-2, -1, -1):
        even[i] += even[i + 1]
    
    # 종유석 : 아래 -> 위 누적합
    for i in range(1, H):
        odd[i] += odd[i - 1]

    # 높이 별 장애
    height = [0] * H
    min_trap = 500000
    trap_cnt = 0

    for i in range(H):
        t = even[i] + odd[i]
        height[i] = t
        if min_trap > t:
            min_trap = t
            trap_cnt = 1
        elif min_trap == t:
            trap_cnt += 1
    
    print(min_trap, trap_cnt)

def difference():
    N, H = map(int, input().split())
    height = [0] * H

    # 너비 압축
    for i in range(N):
        t = int(input().rstrip())

        # 짝수 : 석순, 홀수 : 종유석
        if i & 1:
            # 석순 : H-t 이전은 0 이후는 1
            height[H - t] += 1
        else:
            # 종유석 : t 이전은 1 이후는 0
            height[0] += 1
            height[t] -= 1

    # 누적 합
    for i in range(1, H):
        height[i] += height[i - 1]

    # 최소값 및 빈도
    min_val = min(height)
    min_cnt = sum(1 for h in height if h == min_val)
    
    print(min_val, min_cnt)

# even_and_odd()
difference()