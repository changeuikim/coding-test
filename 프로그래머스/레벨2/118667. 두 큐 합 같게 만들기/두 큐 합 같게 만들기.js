function solution(queue1, queue2) {
    // 빠른 반환 : 합이 홀수
    let q1_sum = queue1.reduce((a, b) => BigInt(a) + BigInt(b), BigInt(0));
    let total_sum = q1_sum + queue2.reduce((a, b) => BigInt(a) + BigInt(b), BigInt(0));
    if (total_sum & BigInt(1)) return -1;

    // 종료 조건 : 현재 합이 전체 합의 절반
    let current_sum = q1_sum;
    let target_sum = total_sum >> BigInt(1);
    
    // 원형 큐 : 두 큐를 결합
    let n = queue1.length;
    let size = 2 * n;
    let q = queue1.concat(queue2);

    // 투 포인터 : i나 j가 한바퀴를 돌면 종료
    let cnt = 0, i = 0, j = n - 1;
    while (i < size && j < size) {
        if (current_sum === target_sum) return cnt;

        if (current_sum > target_sum)   current_sum -= BigInt(q[i++ % size]);
        else                            current_sum += BigInt(q[++j % size]);

        cnt++;
    }

    return -1;
}