# [Gold III] [ACM Craft](https://www.acmicpc.net/problem/1005) - 1005 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

int N, K, W;
vector<int> buildTime;
vector<vector<int>> graph;
vector<int> inDegree;

vector<int> topologicalSort() {
    deque<int> stk;
    vector<int> dp(N + 1, 0);

    for (int i = 1; i <= N; i++) {
        if (inDegree[i] == 0) {
            stk.push_back(i);
            dp[i] = buildTime[i];
        }
    }

    while (!stk.empty()) {
        int u = stk.front();
        stk.pop_front();

        for (int v : graph[u]) {
            inDegree[v]--;
            dp[v] = max(dp[v], dp[u] + buildTime[v]);

            if (inDegree[v] == 0) {
                stk.push_back(v);
            }
        }
    }

    return dp;
}

int test() {
  // 빌드타임 초기화  
  cin >> N >> K;

  buildTime.assign(N + 1, 0);

  for (int i = 1; i <= N; i++) {
    cin >> buildTime[i];
  }

  // 인접리스트, 진입차수 초기화
  graph.assign(N + 1, vector<int>());
  inDegree.assign(N + 1, 0);

  while (K--) {
    int u, v;
    cin >> u >> v;

    graph[u].push_back(v);
    inDegree[v]++;
  }

  // 승리 조건
  cin >> W;

  // 위상 정렬
  vector<int> dp = topologicalSort();

  return dp[W];
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int T;
  cin >> T;

  while (T--) {
    cout << test() << "\n";
  }
}
```

### 성능 요약

시간: 148 ms

메모리: 2876 KB

### 제출 일자

2024년 12월 12일 (목) 23:56

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

