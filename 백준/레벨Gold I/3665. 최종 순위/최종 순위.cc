// 25.02.02
#include <bits/stdc++.h>
using namespace std;

void solution() {
    // 테스트 케이스 T회 (T <= 100)
    int T;
    cin >> T;

    for (int t = 0; t < T; t++) {
        int N; // 2 <= N <= 500
        cin >> N;
        vector<int> rank(N); // 작년 순위 (1 <= t <= N)
        for (int i = 0; i < N; i++) {
            cin >> rank[i];
        }

        // 인접행렬 초기화
        vector<vector<bool>> graph(N + 1, vector<bool>(N + 1, false));
        vector<int> indegree(N + 1, 0);

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                graph[rank[i]][rank[j]] = true;
                indegree[rank[j]]++;
            }
        }

        // 등수 변경 (0 <= M <= 25000)
        int M;
        cin >> M;
        for (int i = 0; i < M; i++) {
            int a, b;
            cin >> a >> b;
            if (graph[a][b]) {
                graph[a][b] = false;
                graph[b][a] = true;
                indegree[b]--;
                indegree[a]++;
            } else {
                graph[b][a] = false;
                graph[a][b] = true;
                indegree[a]--;
                indegree[b]++;
            }
        }

        // 큐 초기화
        queue<int> q;
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.push(i);
            }
        }

        bool impossible = false;
        bool ambiguous = false;

        // 위상 정렬
        vector<int> result;
        for (int i = 0; i < N; i++) {
            // N회 돌기전에 큐가 빈다 -> 사이클
            if (q.empty()) {
                impossible = true;
                break;
            }
            // 큐 크기가 2 이상 -> 순서 보장 X
            if (q.size() > 1) {
                ambiguous = true;
            }

            int u = q.front();
            q.pop();
            result.push_back(u);

            for (int v = 1; v <= N; v++) {
                if (graph[u][v]) {
                    indegree[v]--;
                    if (indegree[v] == 0) {
                        q.push(v);
                    }
                }
            }
        }

        if (impossible) {
            cout << "IMPOSSIBLE\n";
        } else if (ambiguous) {
            cout << "?\n";
        } else {
            for (int x : result) {
                cout << x << " ";
            }
            cout << "\n";
        }
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}