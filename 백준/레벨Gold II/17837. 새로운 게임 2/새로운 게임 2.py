from sys import stdin

input = stdin.readline

def solution():
    N, K = map(int, input().split())

    # 방향 : →, ←, ↑, ↓
    dy = [0, 0, 0, -1, 1]
    dx = [0, 1, -1, 0, 0]

    # 뒤집기
    r_map = {1:2, 2:1, 3:4, 4:3}

    # 체스판 : 둘레 패딩, 1-based
    board = [[2] * (N + 2) for _ in range(N + 2)]
    # 스택판 : 체스판과 동기화, 스택 크기 4 => 게임 종료
    board_stk = [[[] for _ in range(N + 2)] for _ in range(N + 2)]
    # 엔트리 : 1번마 ~ K번마
    horse_list = []

    # 체스판 초기화
    for i in range(1, N + 1):
        line = list(map(int, input().split()))

        for j in range(1, N + 1):
            board[i][j] = line[j - 1]

    # 스택판, 엔트리 초기화
    for i in range(K):
        y, x, d = map(int, input().split())    

        board_stk[y][x].append(i)
        horse_list.append([y, x, d])

    # 게임 1000턴
    for turn in range(1, 1001):
        # 1번마 ~ K번마 순회
        for h_idx in range(K):
            y, x, d = horse_list[h_idx]

            # 이동방향 설정
            ny, nx = y + dy[d], x + dx[d]

            # 파랑칸 : 이동방향 뒤집기
            if board[ny][nx] == 2:
                # 뒤집기
                d = r_map[d]
                horse_list[h_idx][2] = d
                # 이동방향 설정
                ny, nx = y + dy[d], x + dx[d]
                # 또 파란벽이면 이동불가
                if board[ny][nx] == 2:
                    continue

            # 이동 전처리 : 스택 분할
            cur = board_stk[y][x] # 현재말 스택
            slice_ptr = cur.index(h_idx) # 현재말 위치
            nxt = cur[slice_ptr:] # 현재말 위쪽
            board_stk[y][x] = cur[:slice_ptr] # 현재말 아래쪽

            # 빨강칸 : 스택 뒤집기
            if board[ny][nx] == 1:
                nxt.reverse()

            # 이동 처리
            board_stk[ny][nx].extend(nxt)
            for idx in nxt:
                horse_list[idx][0] = ny
                horse_list[idx][1] = nx

            # 스택크기 검증
            if len(board_stk[ny][nx]) >= 4:
                print(turn)
                return
            
    print(-1)

solution()