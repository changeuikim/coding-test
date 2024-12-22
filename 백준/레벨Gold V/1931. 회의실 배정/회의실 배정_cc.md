# [Gold V] [회의실 배정](https://www.acmicpc.net/problem/1931) - 1931 

NaN그리디 알고리즘, 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

void greedy() {
    int N;
    cin >> N;

    vector<pii> meetings(N);
    for (int i = 0; i < N; i++) {
        cin >> meetings[i].first;
        cin >> meetings[i].second;
    }

    // 종료가 빠른 순으로 정렬
    sort(meetings.begin(), meetings.end(), [](const pii& a, const pii& b) {
        return a.second == b.second ? a.first < b.first : a.second < b.second;
    });

    int E = -1, cnt = 0;
    for (const auto& [ns, ne] : meetings) {
        // 현재 종료 <= 다음 시작
        if (E <= ns) {
            E = ne;
            cnt++;
        }
    }

    cout << cnt;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    greedy();
}
```

### 성능 요약

시간: 24 ms

메모리: 2996 KB

### 제출 일자

2024년 12월 22일 (일) 17:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

