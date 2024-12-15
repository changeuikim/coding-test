#include <bits/stdc++.h>

using namespace std;
using pii = pair<int,int>;

struct Pos {
    int y, x, count;

    Pos(int y, int x) : y(y), x(x) {}

    Pos(int y, int x, int count) : y(y), x(x), count(count) {}

    bool operator==(const Pos& other) const {
        return y == other.y && x == other.x;
    }

    bool operator<(const Pos& other) const {
        return tie(y, x) < tie(other.y, other.x);
    }
};

struct State {
    Pos red, blue;
    int move;

    State(Pos red, Pos blue, int move) : red(red), blue(blue), move(move) {}

    bool operator==(const State& other) const {
        return red == other.red && blue == other.blue;
    }

    bool operator<(const State& other) const {
        return tie(red, blue) < tie(other.red, other.blue);
    }
};

Pos roll(int y, int x, int dy, int dx, vector<string>& board) {
    int count = 0;
    while (board[y + dy][x + dx] != '#' && board[y][x] != 'O') {
        y += dy;
        x += dx;
        count++;
    }
    return Pos(y, x, count);
}

int solution() {
	// 보드, 빨강, 파랑 초기화
	int N, M;
	cin >> N >> M;

	vector<string> board(N);
	Pos red(0, 0), blue(0, 0);

	for (size_t i = 0; i < N; i++) {
		cin >> board[i];

		for (size_t j = 0; j < M; j++) {
			if (board[i][j] == 'R') {
				red = Pos(i, j);
				board[i][j] = '.';
			} else if (board[i][j] == 'B') {
				blue = Pos(i, j);
				board[i][j] = '.';
			}            
		}
	}

	// 방향 : 좌우상하
	vector<int> dy = { 0, 0, -1, 1};
	vector<int> dx = { -1, 1, 0, 0};

	// 큐, 방문 초기화
	queue<State> q;
	set<State> visited;

    State inits = State(red, blue, 1);
    q.push(inits);
    visited.insert(inits);

    // BFS
    while (!q.empty()) {
        State curState = q.front();
        q.pop();

        Pos cr = curState.red;
        Pos cb = curState.blue;
        int move = curState.move;

        // 좌우상하 굴리기
        for (int i = 0; i < 4; i++) {
            Pos nr = roll(cr.y, cr.x, dy[i], dx[i], board);
            Pos nb = roll(cb.y, cb.x, dy[i], dx[i], board);
    
            // 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
            if (board[nb.y][nb.x] == 'O') continue;
    
            // 빨간 구슬이 구멍에 빠지면 성공
            if (board[nr.y][nr.x] == 'O') return move;
    
            // 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다
            if (nr.y == nb.y && nr.x == nb.x) {
            // 빨간 구슬을 뒤로
            if (nr.count > nb.count) {
                nr.y -= dy[i];
                nr.x -= dx[i];
            }
            // 파란 구슬을 뒤로
            else {
                nb.y -= dy[i];
                nb.x -= dx[i];
            }
            }
    
            // 큐에 추가
            State nxtState = State(nr, nb, move + 1);
            if (visited.find(nxtState) != visited.end()) continue;
    
            q.push(nxtState);
            visited.insert(nxtState);
        }
    }

    return -1;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    cout << solution();
}