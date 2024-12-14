from sys import stdin
from collections import deque

input = stdin.readline

def init_board():
    N, M = map(int, input().split())
    board = []
    red = blue = None

    for i in range(N):
        line = list(input().rstrip())

        for j in range(M):
            if line[j] == 'R':
                red = (i, j)
                line[j] = '.'
            elif line[j] == 'B':
                blue = (i, j)
                line[j] = '.'
        
        board.append(line)

    return red, blue, board

def move(y, x, dy, dx, board):
    count = 0
    while board[y+dy][x+dx] != '#' and board[y][x] != 'O':
        y += dy
        x += dx
        count += 1
    return y, x, count

def solution():
    # 미로 초기화
    red, blue, board = init_board()

    # 방향 초기화 : 좌우상하
    dirs = [(0,1), (0,-1), (-1,0), (1,0)]

    # 덱 초기화
    q = deque()
    visited = set()

    q.append((red, blue, 1))
    visited.add((red, blue))

    # BFS
    while q:
        (ry, rx), (by, bx), moves = q.popleft()

        for dy, dx in dirs:
            n_by, n_bx, b_cnt = move(by, bx, dy, dx, board)
            n_ry, n_rx, r_cnt = move(ry, rx, dy, dx, board)
        
            # 파란구슬 실패
            if board[n_by][n_bx] == 'O':
                continue       

            # 빨간구슬 성공
            if board[n_ry][n_rx] == 'O':
                return moves
            
            # 위치가 겹치면 더 많이 움직인걸 뒤로
            if (n_ry, n_rx) == (n_by, n_bx):
                if r_cnt > b_cnt:
                    n_ry -= dy                    
                    n_rx -= dx
                else:
                    n_by -= dy
                    n_bx -= dx

            # 큐에 추가
            if ((n_ry, n_rx), (n_by, n_bx)) not in visited:
                q.append(((n_ry,n_rx), (n_by,n_bx), moves + 1))                
                visited.add(((n_ry,n_rx), (n_by,n_bx)))

    return -1

print(solution())