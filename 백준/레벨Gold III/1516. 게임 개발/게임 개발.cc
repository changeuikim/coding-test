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