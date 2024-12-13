# [Gold IV] [알고스팟](https://www.acmicpc.net/problem/1261) - 1261 

NaN0-1 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## PyPy3 문제풀이

```PyPy3
from sys import stdin
from collections import deque

input = stdin.readline

# 미로 초기화 
M, N = map(int, input().split())
board = []
 
for i in range(N):
    board.append(input().rstrip())

# 방향 설정
dy = [0, 0, 1, -1]
dx = [1, -1, 0, 0]
 
# 거리배열 초기화
dist = [[-1] * M for _ in range(N)]
dist[0][0] = 0

# 덱 초기화
dq = deque()
dq.append([0, 0])

# 0-1 BFS 
while dq:
    y, x = dq.popleft()

    for i in range(4):
        ny, nx = y + dy[i], x + dx[i]

        if ny >= 0 and ny < N and nx >= 0 and nx < M:
            if dist[ny][nx] == -1:                
                if board[ny][nx] == '0':
                    dq.appendleft([ny, nx])
                    dist[ny][nx] = dist[y][x]
                elif board[ny][nx] == '1':
                    dq.append([ny, nx])
                    dist[ny][nx] = dist[y][x] + 1
 
print(dist[N-1][M-1])
```

### 성능 요약

시간: 124 ms

메모리: 114200 KB

### 제출 일자

2024년 12월 13일 (금) 15:26

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

