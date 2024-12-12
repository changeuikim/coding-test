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