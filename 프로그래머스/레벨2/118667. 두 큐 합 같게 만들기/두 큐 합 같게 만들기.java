import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        // 빠른 반환 : 합이 홀수
        long q1_sum = Arrays.stream(queue1).sum();
        long total_sum = q1_sum + Arrays.stream(queue2).sum();
        if ((total_sum & 1) == 1) return -1;

        // 종료 조건 : 현재 합이 전체 합의 절반
        long current_sum = q1_sum;
        long target_sum = total_sum >> 1;

        // 원형 큐 : 두 큐를 결합
        int n = queue1.length;
        int size = 2 * n;
        int[] q = new int[size];
        System.arraycopy(queue1, 0, q, 0, n);
        System.arraycopy(queue2, 0, q, n, n);

        // 투 포인터 : i나 j가 한바퀴를 돌면 종료
        int cnt = 0, i = 0, j = n - 1;
        while (i < size && j < size) {
            if (current_sum == target_sum)  return cnt;

            if (current_sum > target_sum)   current_sum -= q[i++ % size];
            else                            current_sum += q[++j % size];

            cnt++;
        }

        return -1;
    }
}