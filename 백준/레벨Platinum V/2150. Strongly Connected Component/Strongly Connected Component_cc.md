# [Platinum V] [Strongly Connected Component](https://www.acmicpc.net/problem/2150) - 2150 

NaN그래프 이론, 강한 연결 요소

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

void solution() {
    // 정방향, 역방향 인접리스트 초기화
    int V, E;
    cin >> V >> E;

    vector<vector<int>> fGraph(V + 1), rGraph(V + 1);

    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        fGraph[u].push_back(v);
        rGraph[v].push_back(u);
    }

    // 모든 정점에 대해 정방향 DFS
    vector<bool> visited(V + 1, false);
    vector<int> orderStack;
    stack<pair<int, int>> fDFS;

    for (int i = 1; i <= V; i++) {
        fDFS.push({i, -1});
    }

    while (!fDFS.empty()) {
        auto [u, state] = fDFS.top();
        fDFS.pop();
        if (state > -1) {
            orderStack.push_back(u);
            continue;
        }
        if (visited[u]) continue;

        visited[u] = true;
        fDFS.push({u, 0});
        for (int v : fGraph[u]) {
            if (!visited[v]) fDFS.push({v, -1});
        }
    }

    // 방문 정점에 대해 역방향 DFS
    visited.assign(V + 1, false);
    vector<vector<int>> sccList;
    stack<int> rDFS;

    for (int i = orderStack.size() - 1; i >= 0; i--) {
        int start = orderStack[i];
        if (visited[start]) continue;

        rDFS.push(start);
        vector<int> curSCC;
        while (!rDFS.empty()) {
            int v = rDFS.top();
            rDFS.pop();
            if (visited[v]) continue;

            visited[v] = true;
            curSCC.push_back(v);
            for (int u : rGraph[v]) {
                if (!visited[u]) rDFS.push(u);
            }
        }
        sort(curSCC.begin(), curSCC.end());
        sccList.push_back(curSCC);
    }

    // 첫줄에 SCC의 개수 K를 출력
    // 다음 K개의 줄에는 각 줄에 하나의 SCC에 속한 정점의 번호를 출력
    sort(sccList.begin(), sccList.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[0] < b[0];
    });

    cout << sccList.size() << '\n';
    for (const auto& scc : sccList) {
        for (int v : scc) {
            cout << v << ' ';
        }
        cout << "-1\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}

```

### 성능 요약

시간: 28 ms

메모리: 4560 KB

### 제출 일자

2024년 12월 25일 (수) 22:01

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

