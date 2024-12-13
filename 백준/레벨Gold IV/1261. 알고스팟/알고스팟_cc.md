# [Gold IV] [알고스팟](https://www.acmicpc.net/problem/1261) - 1261 

NaN0-1 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## C++17 (Clang) 문제풀이

```C++17 (Clang)
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
```

### 성능 요약

시간: 0 ms

메모리: 2348 KB

### 제출 일자

2024년 12월 13일 (금) 15:28

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

