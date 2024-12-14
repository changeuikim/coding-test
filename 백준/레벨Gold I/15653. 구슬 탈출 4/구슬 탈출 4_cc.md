# [Gold I] [구슬 탈출 4](https://www.acmicpc.net/problem/15653) - 15653 

NaN너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

struct Pos {
  int y, x, cnt;

  Pos(int y, int x) : y(y), x(x) {}

  Pos(int y, int x, int cnt) : y(y), x(x), cnt(cnt) {}

  bool operator<(const Pos& other) const {
    return tie(y, x, cnt) < tie(other.y, other.x, other.cnt);
  }

  bool operator==(const Pos& other) const {
    return y == other.y && x == other.x;
  }
};

struct State {
  Pos red, blue;
  int moves;

  State(Pos red, Pos blue, int moves) : red(red), blue(blue), moves(moves) {}

  bool operator<(const State& other) const {
    return tie(red, blue, moves) < tie(other.red, other.blue, other.moves);
  }

  bool operator==(const State& other) const {
    return red == other.red && blue == other.blue;
  }
};

int N, M;
vector<string> board;

State initBoard() {
  cin >> N >> M;
  board.resize(N);
  Pos red(0, 0), blue(0, 0);

  for (int i = 0; i < N; ++i) {
    cin >> board[i];

    for (int j = 0; j < M; ++j) {
      if (board[i][j] == 'R') {
        red = Pos(i, j);
        board[i][j] = '.';
      } else if (board[i][j] == 'B') {
        blue = Pos(i, j);
        board[i][j] = '.';
      }
    }
  }

  return State(red, blue, 1);
}

Pos move(int y, int x, int dy, int dx) {
  int count = 0;
  while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
    y += dy;
    x += dx;
    count++;
  }
  return Pos(y, x, count);
}

int BFS(State state, const vector<pii>& dirs) {
  // 큐 초기화
  queue<State> q;
  set<pair<Pos, Pos>> visited;

  q.push(state);
  visited.insert({state.red, state.blue});

  // BFS
  while (!q.empty()) {
    State current = q.front();
    q.pop();

    Pos red = current.red;
    Pos blue = current.blue;
    int moves = current.moves;

    for (auto [dy, dx] : dirs) {
      Pos bluePos = move(blue.y, blue.x, dy, dx);
      int nBy = bluePos.y, nBx = bluePos.x, bCnt = bluePos.cnt;

      Pos redPos = move(red.y, red.x, dy, dx);
      int nRy = redPos.y, nRx = redPos.x, rCnt = redPos.cnt;

      // 파란구슬 실패
      if (board[nBy][nBx] == 'O') continue;

      // 빨간구슬 성공
      if (board[nRy][nRx] == 'O') return moves;

      // 위치가 겹치면 더 많이 움직인걸 뒤로
      if (nRy == nBy && nRx == nBx) {
          if (rCnt > bCnt) {
              nRy -= dy;
              nRx -= dx;
          } else {
              nBy -= dy;
              nBx -= dx;
          }
      }

      // 큐에 추가
      State nextState(Pos(nRy, nRx), Pos(nBy, nBx), moves + 1);
      if (visited.find({nextState.red, nextState.blue}) == visited.end()) {
        q.push(nextState);
        visited.insert({nextState.red, nextState.blue});
      }
    }
  }

  return -1;
}

int main(void) {
  ios::sync_with_stdio(0);
  cin.tie(0);

  // 미로 초기화
  State state = initBoard();

  // 방향 초기화
  vector<pii> dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

  // BFS
  int result = BFS(state, dirs);

  cout << result;
}
```

### 성능 요약

시간: 0 ms

메모리: 2224 KB

### 제출 일자

2024년 12월 15일 (일) 01:31

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

