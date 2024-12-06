#include <vector>
#include <numeric>

using namespace std;

int solution(vector<int> queue1, vector<int> queue2) {
    // 빠른 반환 : 합이 홀수    
    long long q1_sum = accumulate(queue1.begin(), queue1.end(), 0LL);
    long long total_sum = q1_sum + accumulate(queue2.begin(), queue2.end(), 0LL);
    if (total_sum & 1) return -1;

    // 종료 조건 : 현재 합이 전체 합의 절반
    long long current_sum = q1_sum;
    long long target_sum = total_sum >> 1;
        
    // 원형 큐 : 두 벡터를 결합    
    int n = queue1.size();
    int size = 2 * n;
    long long* q = new long long[size];
    copy(queue1.begin(), queue1.end(), q);
    copy(queue2.begin(), queue2.end(), q + n);

    // 투 포인터 : i나 j가 한바퀴를 돌면 종료
    int cnt = 0, i = 0, j = n - 1;
    while (i < size && j < size) {
        if (current_sum == target_sum) return cnt;

        if (current_sum > target_sum)   current_sum -= q[i++ % size];
        else                            current_sum += q[++j % size];

        cnt++;
    }

    return -1;
}