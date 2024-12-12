# [Gold III] [줄 세우기](https://www.acmicpc.net/problem/2252) - 2252 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

vector<vector<int>> graph;
vector<int> ind;
vector<int> result;
int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, M;
  cin >> N >> M;

  // 인접리스트, 진입차수 초기화
  graph.resize(N + 1);
  ind.resize(N + 1);
  
  while (M--) {
    int u, v;
    cin >> u >> v;
    graph[u].push_back(v);
    ind[v]++;
  }

  // 큐 초기화
  queue<int> q;

  for (size_t i = 1; i <= N; i++) {
    if (ind[i] == 0) q.push(i);
  }

  // 위상정렬
  while (!q.empty()) {
    auto u = q.front();
    q.pop();

    result.push_back(u);

    for (auto v : graph[u]) {
      ind[v]--;
      if (ind[v] == 0) q.push(v);
    }
  }

  for (auto t : result) {
    cout << t << " ";
  }
}
```

### 성능 요약

시간: 24 ms

메모리: 4316 KB

### 제출 일자

2024년 12월 12일 (목) 13:58

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

