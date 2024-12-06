# [Lv.2] [두 큐 합 같게 만들기](https://programmers.co.kr/) - 118667 

### 구분

코딩테스트 연습 > 2022 KAKAO TECH INTERNSHIP

## C++ 문제풀이

```cpp
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
```

### 성능 요약

1. 시간: 5.56 ms, 메모리: 28.2 MB

2. 시간: 4.52 ms, 메모리: 28.8 MB
3. 시간: 4.50 ms, 메모리: 27.9 MB
4. 시간: 4.21 ms, 메모리: 27.7 MB
5. 시간: 4.09 ms, 메모리: 27.6 MB

### 제출 일자

2024년 12월 06일 (금) 20:04

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges