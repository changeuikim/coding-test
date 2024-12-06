def solution(queue1, queue2):
    # 빠른 반환 : 합이 홀수
    q1_sum = sum(queue1)
    total_sum = q1_sum + sum(queue2)
    if total_sum & 1:
        return -1

    # 종료 조건 : 현재 합이 전체 합의 절반
    target_sum = total_sum >> 1
    current_sum = q1_sum

    # 원형 큐 : 두 큐를 결합    
    n = len(queue1)
    size = 2 * n
    q = queue1 + queue2

    # 투 포인터 : i나 j가 한바퀴를 돌면 종료
    cnt, i, j = 0, 0, n - 1
    while i < size and j < size:
        if current_sum == target_sum:
            return cnt

        if current_sum > target_sum:
            current_sum -= q[i % size]
            i += 1
        else:
            j += 1
            current_sum += q[j % size]

        cnt += 1

    return -1