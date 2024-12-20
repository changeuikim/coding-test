# [Gold II] [새로운 게임 2](https://www.acmicpc.net/problem/17837) - 17837 

NaN구현, 시뮬레이션

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

struct Horse {
    int y, x, d;
};

void solution() {
    int N, K;
    cin >> N >> K;

    // 방향: →, ←, ↑, ↓
    int dy[] = {0, 0, 0, -1, 1};
    int dx[] = {0, 1, -1, 0, 0};

    // 뒤집기
    map<int, int> r_map = {{1, 2}, {2, 1}, {3, 4}, {4, 3}};

    // 체스판: 둘레 패딩, 1-based
    vector<vector<int>> board(N + 2, vector<int>(N + 2, 2));
    // 스택판 : 체스판과 동기화, 스택 크기 4 => 게임 종료
    vector<vector<vector<int>>> board_stk(N + 2, vector<vector<int>>(N + 2));
    // 엔트리 : 1번마 ~ K번마
    vector<Horse> horse_list(K);

    // 체스판 초기화
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            cin >> board[i][j];
        }
    }

    // 스택판, 엔트리 초기화
    for (int i = 0; i < K; i++) {
        int y, x, d;
        cin >> y >> x >> d;

        board_stk[y][x].push_back(i);
        horse_list[i] = {y, x, d};
    }

    // 게임 1000턴
    for (int turn = 1; turn <= 1000; turn++) {
        for (int h_idx = 0; h_idx < K; h_idx++) {
            auto& horse = horse_list[h_idx];
            int y = horse.y, x = horse.x, d = horse.d;

            // 이동방향 설정
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 파랑칸: 이동방향 뒤집기
            if (board[ny][nx] == 2) {
                // 뒤집기
                d = r_map[d];
                horse.d = d;
                // 이동방향 설정
                ny = y + dy[d];
                nx = x + dx[d];
                // 또 파란벽이면 이동불가
                if (board[ny][nx] == 2) continue;
            }

            // 이동 전처리: 스택 분할
            auto& cur = board_stk[y][x]; // 현재말 스택
            auto it = find(cur.begin(), cur.end(), h_idx); // 현재말 위치
            vector<int> nxt(it, cur.end()); // 현재말 위쪽
            cur.erase(it, cur.end()); // 현재말 아래쪽

            // 빨강칸: 스택 뒤집기
            if (board[ny][nx] == 1) {
                reverse(nxt.begin(), nxt.end());
            }

            // 이동 처리
            board_stk[ny][nx].insert(board_stk[ny][nx].end(), nxt.begin(), nxt.end());
            for (int idx : nxt) {
                horse_list[idx].y = ny;
                horse_list[idx].x = nx;
            }

            // 스택 크기 검증
            if (board_stk[ny][nx].size() >= 4) {
                cout << turn;
                return;
            }
        }
    }

    cout << -1;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}
```

### 성능 요약

시간: 0 ms

메모리: 2220 KB

### 제출 일자

2024년 12월 20일 (금) 23:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

