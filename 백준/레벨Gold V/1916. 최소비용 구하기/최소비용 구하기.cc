#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 인접리스트 초기화
  int N, M;
  cin >> N >> M;

  vector<vector<pii>> graph(N + 1);

  while (M--) {
    int u, v, w;
    cin >> u >> v >> w;

    graph[u].emplace_back(w, v);    
  }

  int S, E;
  cin >> S >> E;

  // 다익스트라
  vector<int> costs(N + 1, INT_MAX);
  costs[S] = 0;

  priority_queue<pii, vector<pii>, greater<>> pq;
  pq.emplace(0, S);

  while (!pq.empty()) {
    auto [currCost, u] = pq.top();
    pq.pop();

    if (currCost > costs[u]) continue;
    if (u == E) break;

    for (auto [w, v] : graph[u]) {
      int nextCost = currCost + w;

      if (nextCost < costs[v]) {
        costs[v] = nextCost;
        pq.emplace(nextCost, v);
      }
    }
  }

  cout << costs[E];
}