#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

vector<int> dijkstra(int N, int S, const vector<vector<pii>>& graph) {
  // 거리배열 초기화
  const int MAX = 100001;
  vector<int> dist(N + 1, MAX);
  dist[S] = 0;

  // 우선순위큐
  priority_queue<pii, vector<pii>, greater<>> pq;
  pq.emplace(0, S);

  while (!pq.empty()) {
    auto [curDist, u] = pq.top();
    pq.pop();

    if (curDist > dist[u]) continue;

    for (auto [v, w] : graph[u]) {
      int nxtDist = curDist + w;
      if (nxtDist < dist[v]) {
        dist[v] = nxtDist;
        pq.emplace(nxtDist, v);
      }
    }
  }

  return dist;
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  int N, M, X;
  cin >> N >> M >> X;

  // 정방향, 역방향 인접리스트 초기화
  vector<vector<pii>> fGraph(N + 1);
  vector<vector<pii>> rGraph(N + 1);

  while (M--) {
    int u, v, w;
    cin >> u >> v >> w;

    fGraph[u].emplace_back(v, w);
    rGraph[v].emplace_back(u, w);
  }

  // 집 -> X -> 집
  vector<int> homeToParty = dijkstra(N, X, fGraph);
  vector<int> partyToHome = dijkstra(N, X, rGraph);

  // 최대시간 찾기
  int maxTime = -1;
  for (int i = 1; i <= N; i++) {
    int curTime = homeToParty[i] + partyToHome[i];
    if (curTime > maxTime) {
      maxTime = curTime;
    }
  }

  cout << maxTime;
}