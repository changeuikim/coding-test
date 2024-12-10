# [Gold III] [게임 개발](https://www.acmicpc.net/problem/1516) - 1516 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N;
  cin >> N;  

  // 인접리스트, 진입차수 초기화
  vector<vector<int>> graph(N + 1);
  vector<int> inDegree(N + 1, 0);
  vector<int> buildTime(N + 1, 0);

  for (int v = 1; v <= N; v++) {
    cin >> buildTime[v];

    while (true) {
      int u;
      cin >> u;
      if (u == -1) break;
      graph[u].push_back(v);
      inDegree[v]++;
    }
  }

  // 위상정렬
  queue<int> q;
  vector<int> result(N + 1, 0);

  for (int i = 1; i <= N; i++) {
    if (inDegree[i] == 0) {
      q.push(i);
      result[i] = buildTime[i];
    }
  }

  while (!q.empty()) {
    int u = q.front();
    q.pop();

    for (int v : graph[u]) {
      inDegree[v]--;
      result[v] = max(result[v], result[u] + buildTime[v]);
      if (inDegree[v] == 0) {
        q.push(v);
      }
    }
  }

  for (int i = 1; i <= N; i++) {
    cout << result[i] << "\n";
  }
}
```

### 성능 요약

시간: 4 ms

메모리: 2476 KB

### 제출 일자

2024년 12월 10일 (화) 22:18

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

