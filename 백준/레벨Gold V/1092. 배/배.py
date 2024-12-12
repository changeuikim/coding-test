from sys import stdin

def solution():
    input = stdin.readline

    # 입력 처리
    N = int(input().rstrip())
    cranes = list(map(int, input().split()))
    M = int(input().rstrip())
    boxes = list(map(int, input().split()))

    # 내림차순 정렬
    cranes.sort(reverse=True)
    boxes.sort(reverse=True)

    if boxes[0] > cranes[0]:
        return -1

    # 시간단위
    time = 0
    idx_list = list(range(M))

    while len(idx_list) > 0:
        time += 1
        new_list = []
        c_idx = 0
        
        for b_idx in idx_list:
            if c_idx < N and boxes[b_idx] <= cranes[c_idx]:
                c_idx += 1
            else:
                new_list.append(b_idx)
        
        idx_list = new_list

    return time

result = solution()
print(result)