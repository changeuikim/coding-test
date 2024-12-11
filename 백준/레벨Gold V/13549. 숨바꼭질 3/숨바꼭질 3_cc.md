# [Gold V] [숨바꼭질 3](https://www.acmicpc.net/problem/13549) - 13549 

NaN0-1 너비 우선 탐색, 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, K;
  cin >> N >> K;
  
  // 거리배열 초기화
  const int MAX = 100001;
  vector<int> dist(MAX, -1);
  dist[N] = 0;

  // 0-1 BFS
  deque<int> dq;
  dq.push_back(N);
  int result = -1;

  while (!dq.empty()) {
    int u = dq.front();
    dq.pop_front();

    if (u == K) {
      result = dist[u];
      break;
    }

    for (auto [v, w] : {pair{u * 2, 0}, pair{u - 1, 1}, pair{u + 1, 1}}) {
      if (v >= 0 && v < MAX && dist[v] == -1) {
        dist[v] = dist[u] + w;

        if (w == 0) dq.push_front(v);
        else dq.push_back(v);
      }
    }
  }

  cout << result;
}
```

### 성능 요약

시간: 0 ms

메모리: 2604 KB

### 제출 일자

2024년 12월 11일 (수) 23:19

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

