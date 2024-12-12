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