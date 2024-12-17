# [Gold IV] [작업](https://www.acmicpc.net/problem/2056) - 2056 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

void topologicalSort() {
    // 선행은 모두 1 이상 (K-1) 이하 : 1부터 N까지 이미 위상 정렬 됨
    int N;
    cin >> N;

    vector<int> dp(N + 1, 0);
    for (int v = 1; v <= N; v++) {
        int time, size;
        cin >> time >> size;

        // 작업시간 설정
        dp[v] = time;
        // 선행시간 반영
        while (size--) {
            int u;
            cin >> u;

            dp[v] = max(dp[v], dp[u] + time);
        }
    }

    // 가장 늦게 끝나는 작업을 반환
    cout << *max_element(dp.begin() + 1, dp.end());
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    topologicalSort();
}
```

### 성능 요약

시간: 52 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 17일 (화) 13:32

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

