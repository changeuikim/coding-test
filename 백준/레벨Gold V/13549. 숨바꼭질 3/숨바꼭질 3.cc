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