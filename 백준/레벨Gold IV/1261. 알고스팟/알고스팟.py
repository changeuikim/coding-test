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