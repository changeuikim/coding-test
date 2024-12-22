from sys import stdin

def greedy():
    N = int(input().rstrip())
    
    meetings = []
    for _ in range(N):
        line = list(map(int, input().split()))
        meetings.append(line)

    # 종료가 빠른 순으로 정렬
    meetings.sort(key=lambda x: (x[1], x[0]))

    E, cnt = -1, 0
    for ns, ne in meetings:
        # 현재 종료 <= 다음 시작
        if E <= ns:
            E = ne
            cnt += 1

    print(cnt)

greedy()