# [Silver III] [구간 합 구하기 4](https://www.acmicpc.net/problem/11659) - 11659 

NaN누적 합

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

void rangeSum() {
    // 누적 합 초기화
    int N, M;
    cin >> N >> M;

    vector<int> prefixSum(N + 1, 0);

    for (int i = 0; i < N; i++) {
        int t;
        cin >> t;
        prefixSum[i + 1] = prefixSum[i] + t;
    }

    while (M--) {
        int i, j;
        cin >> i >> j;
        cout << prefixSum[j] - prefixSum[i - 1] << "\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    rangeSum();
}
```

### 성능 요약

시간: 40 ms

메모리: 2604 KB

### 제출 일자

2024년 12월 16일 (월) 08:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

