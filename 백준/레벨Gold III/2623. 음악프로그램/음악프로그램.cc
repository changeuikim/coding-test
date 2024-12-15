#include <bits/stdc++.h>

using namespace std;

void topologicalSort() {
    // 인접리스트, 진입차수 초기화
    int N, M;
    cin >> N >> M;

    vector<vector<int>> graph(N + 1);
    vector<int> inDegree(N + 1, 0);

    while (M--) {
        int length, u;
        cin >> length >> u;

        for (int i = 1; i < length; i++) {
            int v;
            cin >> v;
            graph[u].push_back(v);
            inDegree[v]++;
            u = v;
        }
    }

    // 큐 초기화
    queue<int> q;
    vector<int> result;

    for (int i = 1; i <= N; i++) {
        if (inDegree[i] == 0) {
            q.push(i);
        }
    }

    // 위상 정렬
    while (!q.empty()) {
        int u = q.front();
        q.pop();

        result.push_back(u);

        for (int v : graph[u]) {
            inDegree[v]--;
            if (inDegree[v] == 0) {
                q.push(v);
            }
        }
    }

    // 사이클 확인
    if (result.size() == N) {
        for (int t : result) {
            cout << t << "\n";
        }
    } else {
        cout << 0;
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    topologicalSort();
}