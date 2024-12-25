# [Platinum V] [Strongly Connected Component](https://www.acmicpc.net/problem/2150) - 2150 

NaN그래프 이론, 강한 연결 요소

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> fGraph, rGraph;
vector<bool> visited;
stack<int> orderStack;

void fDFS(int u) {
    visited[u] = true;
    for (int v : fGraph[u]) {
        if (!visited[v]) {
            fDFS(v);
        }
    }
    orderStack.push(u);
}

void rDFS(int v, vector<int>& curSCC) {
    visited[v] = true;
    curSCC.push_back(v);
    for (int u : rGraph[v]) {
        if (!visited[u]) {
            rDFS(u, curSCC);
        }
    }
}

void solution() {
    // 정방향, 역방향 인접리스트 초기화
    int V, E;
    cin >> V >> E;

    fGraph.resize(V + 1);
    rGraph.resize(V + 1);

    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        fGraph[u].push_back(v);
        rGraph[v].push_back(u);
    }

    // 모든 정점에 대해 정방향 DFS
    visited.resize(V + 1, false);

    for (int u = 1; u <= V; u++) {
        if (!visited[u]) {
            fDFS(u);
        }
    }

    // 방문 정점에 대해 역방향 DFS
    visited.assign(V + 1, false);
    vector<vector<int>> sccList;

    while (!orderStack.empty()) {
        int v = orderStack.top();
        orderStack.pop();
        if (!visited[v]) {
            vector<int> curSCC;
            rDFS(v, curSCC);
            sort(curSCC.begin(), curSCC.end());
            sccList.push_back(curSCC);
        }
    }

    // 첫줄에 SCC의 개수 출력
    // 각 줄에 SCC의 정점 번호 출력
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

메모리: 4664 KB

### 제출 일자

2024년 12월 25일 (수) 22:00

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

