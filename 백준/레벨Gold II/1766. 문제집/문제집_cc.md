# [Gold II] [문제집](https://www.acmicpc.net/problem/1766) - 1766 

NaN방향 비순환 그래프, 자료 구조, 그래프 이론, 우선순위 큐, 위상 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 인접리스트, 진입차수 초기화
  int N, M;
  cin >> N >> M;

  vector<vector<int>> graph(N + 1, vector<int>());
  vector<int> inDegree(N + 1, 0);

  while (M--) {
    int u, v;
    cin >> u >> v;

    graph[u].push_back(v);
    inDegree[v]++;    
  }

  // 힙 초기화
  priority_queue<int, vector<int>, greater<int>> pq;
  string result;

  for (int i = 1; i <= N; i++) {
    if (inDegree[i] == 0) {
      pq.push(i);
    }
  }  

  // 위상 정렬
  while (!pq.empty()) {
    int u = pq.top();
    pq.pop();

    cout << u << " ";

    for (int v : graph[u]) {
      inDegree[v]--;
      if (inDegree[v] == 0) {
        pq.push(v);
      }
    }
  }
}
```

### 성능 요약

시간: 28 ms

메모리: 4044 KB

### 제출 일자

2024년 12월 13일 (금) 15:37

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

