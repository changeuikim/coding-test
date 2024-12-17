# [Gold IV] [녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485) - 4485 

NaN데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## PyPy3 문제풀이

```PyPy3
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
```

### 성능 요약

시간: 164 ms

메모리: 111712 KB

### 제출 일자

2024년 12월 17일 (화) 14:29

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

