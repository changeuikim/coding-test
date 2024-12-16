# [Silver I] [구간 합 구하기 5](https://www.acmicpc.net/problem/11660) - 11660 

NaN다이나믹 프로그래밍, 누적 합

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

void rangeSum() {
    // 누적 합 초기화
    int N, M;
    cin >> N >> M;

    vector<vector<int>> nums(N, vector<int>(N, 0));
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < N; j++) {
            cin >> nums[i][j];
        }
    }    

    vector<vector<int>> pre(N+1, vector<int>(N+1, 0));
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + nums[i-1][j-1];
        }
    }      

    // 구간 합 처리
    while (M-- > 0) {
        int x1, y1, x2, y2;
        cin >> x1 >> y1 >> x2 >> y2;

        int t = pre[x2][y2] - pre[x1-1][y2] - pre[x2][y1-1] + pre[x1-1][y1-1];
        cout << t << "\n";
    }      
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    rangeSum();
}
```

### 성능 요약

시간: 112 ms

메모리: 10396 KB

### 제출 일자

2024년 12월 16일 (월) 09:31

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

