#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 미로 초기화
  int M, N;
  cin >> M >> N;

  vector<string> board(N);
  for (int i = 0; i < N; i++) {
    cin >> board[i];
  }

  // 방향 설정
  vector<int> dy = {0, 0, 1, -1};
  vector<int> dx = {1, -1, 0, 0};

  // 거리배열 초기화
  vector<vector<int>> dist(N, vector<int>(M, -1));
  dist[0][0] = 0;

  // 덱 초기화
  deque<pii> dq;
  dq.emplace_back(0, 0);

  // 0-1 BFS
  while (!dq.empty()) {
    pii p = dq.front();
    dq.pop_front();

    for (int i = 0; i < 4; i++) {
      int ny = p.first + dy[i], nx = p.second + dx[i];

      if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
        if (dist[ny][nx] == -1) {
          if (board[ny][nx] == '0') {
            dq.emplace_front(ny, nx);
            dist[ny][nx] = dist[p.first][p.second];
          } else if (board[ny][nx] == '1') {
            dq.emplace_back(ny, nx);
            dist[ny][nx] = dist[p.first][p.second] + 1;
          }
        }
      }
    }
  }

  cout << dist[N-1][M-1];
}