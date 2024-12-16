# [Gold III] [나머지 합](https://www.acmicpc.net/problem/10986) - 10986 

NaN수학, 누적 합

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

void rangeSum() {
    // 누적 합 초기화
    int N, M;
    cin >> N >> M;

    vector<int> nums(N);
    for (int i = 0; i < N; i++) {
        cin >> nums[i];
    }

    vector<int> pre(N + 1, 0);
    for (int i = 0; i < N; i++) {
        pre[i + 1] = (pre[i] + nums[i]) % M;
    }

    // 나머지 배열 초기화
    vector<int> r(M, 0);
    for (int i = 1; i <= N; i++) {
        r[pre[i]]++;
    }

    // 조합
    long long count = r[0]; // 누적합도 구간합
    for (int i = 0; i < M; i++) {
        count += (long long) r[i] * (r[i] - 1) / 2; // nC2 = n * (n-1) / 2
    }

    cout << count;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);

    rangeSum();
}
```

### 성능 요약

시간: 140 ms

메모리: 10028 KB

### 제출 일자

2024년 12월 16일 (월) 10:14

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

