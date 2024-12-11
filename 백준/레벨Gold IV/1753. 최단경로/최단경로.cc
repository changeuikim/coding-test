#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 인접리스트 초기화
  int V, E, S;
  cin >> V >> E >> S;

  vector<vector<pii>> graph(V + 1);

  while (E--) {
    int u, v, w;
    cin >> u >> v >> w;

    graph[u].emplace_back(v, w);
  }

  // 거리배열 초기화
  int INF = INT_MAX;
  vector<int> distances(V + 1, INF);
  distances[S] = 0;

  // 다익스트라
  priority_queue<pii, vector<pii>, greater<>> pq;
  pq.emplace(0, S);

  while (!pq.empty()) {
    auto [currDist, u] = pq.top();
    pq.pop();

    if (currDist > distances[u]) continue;

    for (auto [v, w] : graph[u]) {
      int nextDist = currDist + w;

      if (nextDist < distances[v]) {
        distances[v] = nextDist;
        pq.emplace(nextDist, v);
      }
    }
  }

  // 출력 처리
  for (size_t i = 1; i < distances.size(); i++) {
    if (distances[i] == INF) {
      cout << "INF";
    } else {
      cout << distances[i];
    }
    cout << "\n";
  }
}  