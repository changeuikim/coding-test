from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

def dijkstra():
    result = []
    while True:
        N = int(input().rstrip())
        if N == 0:
            break

        # 동굴 초기화
        cave = []
        for _ in range(N):
            cave.append(list(map(int, input().split())))
        
        # 방향 초기화 : 상하좌우
        dy = [-1, 1, 0, 0]
        dx = [0, 0, -1, 1]

        # 힙, dp 초기화
        start = cave[0][0]
        heap = []
        heappush(heap, (start, 0, 0))

        MAX = N * N * 9 + 1
        dp = [[MAX] * N for _ in range(N)]
        dp[0][0] = start

        # 다익스트라
        while heap:
            cur, y, x = heappop(heap)

            if y == N - 1 and x == N - 1:
                break

            for i in range(4):
                ny, nx = y + dy[i], x + dx[i]
                
                if 0 <= ny < N and 0 <= nx < N:
                    nxt = cur + cave[ny][nx]
                    if dp[ny][nx] > nxt:
                        heappush(heap, (nxt, ny, nx))
                        dp[ny][nx] = nxt

        result.append(dp[N-1][N-1])

    # 결과 출력
    for i in range(len(result)):
        print(f'Problem {i+1}: {result[i]}')

dijkstra()