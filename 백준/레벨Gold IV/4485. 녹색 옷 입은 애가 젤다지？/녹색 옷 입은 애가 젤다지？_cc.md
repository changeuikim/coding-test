# [Gold IV] [녹색 옷 입은 애가 젤다지?](https://www.acmicpc.net/problem/4485) - 4485 

NaN데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;
using Node = pair<int, pii>;

void dijkstra() {
    vector<int> result;

    while (true) {
        int N;
        cin >> N;
        if (N == 0) break;

        // 동굴 초기화
        vector<vector<int>> cave(N, vector<int>(N));
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                cin >> cave[i][j];
            }
        }

        // 방향 초기화 : 상하좌우
        int dy[] = {-1, 1, 0, 0};
        int dx[] = {0, 0, -1, 1};

        // 힙, dp 초기화
        int start = cave[0][0];
        priority_queue<Node, vector<Node>, greater<>> pq;
        pq.emplace(start, make_pair(0, 0));

        int MAX = N * N * 9 + 1;
        vector<vector<int>> dp(N, vector<int>(N, MAX));
        dp[0][0] = start;

        // 다익스트라
        while (!pq.empty()) {
            Node node = pq.top();
            pq.pop();

            int cur = node.first;
            int y = node.second.first, x = node.second.second;

            if (y == N - 1 && x == N - 1) break;

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                    int nxt = cur + cave[ny][nx];
                    if (dp[ny][nx] > nxt) {
                        dp[ny][nx] = nxt;
                        pq.emplace(nxt, make_pair(ny, nx));
                    }
                }
            }
        }

        result.push_back(dp[N - 1][N - 1]);
    }

    // 결과 출력
    for (int i = 0; i < result.size(); i++) {
        cout << "Problem " << i + 1 << ": " << result[i] << "\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    dijkstra();
}
```

### 성능 요약

시간: 4 ms

메모리: 2344 KB

### 제출 일자

2024년 12월 17일 (화) 14:32

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

