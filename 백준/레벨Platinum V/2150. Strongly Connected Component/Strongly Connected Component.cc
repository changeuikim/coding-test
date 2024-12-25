#include <bits/stdc++.h>
using namespace std;

vector<vector<int>> graph;
// SCC 후보 스택, 정점의 스택 포함 여부
stack<int> sccStack;
vector<bool> inStack;
// DFS 방문순서, 카운터
vector<int> visited;
int visitedCount;
// SCC 목록
vector<vector<int>> sccList;

int dfs(int u) {
    // low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
    visited[u] = visitedCount;
    int low = visitedCount++;

    // 스택에 u를 추가
    sccStack.push(u);
    inStack[u] = true;

    // 인접 정점을 탐색
    for (int v : graph[u]) {
        // v 방문 전이면 dfs(v)후 low 갱신
        if (visited[v] == -1) {
            low = min(low, dfs(v)); // 두번째 low : 자식 정점의 방문 순서
        }
        // 방문했지만 SCC 후보라면 low 갱신
        else if (inStack[v]) {
            low = min(low, visited[v]); // 세번째 low : 스택에 있는 방문 순서
        }
    }

    // low가 방문순서와 동일 : 먼저 방문된 노드로 돌아갈 수 없어서 여기가 SCC 루트
    if (low == visited[u]) {
        vector<int> curSCC;

        // SCC 구성하기
        while (true) {
            int top = sccStack.top();
            sccStack.pop();
            inStack[top] = false;
            curSCC.push_back(top);
            if (top == u) break;
        }
        sort(curSCC.begin(), curSCC.end());
        sccList.push_back(curSCC);
    }

    return low;
}

void solution() {
    // 정방향, 역방향 인접리스트 초기화
    int V, E;
    cin >> V >> E;
    graph.assign(V + 1, vector<int>());
    
    for (int i = 0; i < E; i++) {
        int u, v;
        cin >> u >> v;
        graph[u].push_back(v);
    }

    sccStack = stack<int>();
    inStack.assign(V + 1, false);
    visited.assign(V + 1, -1);
    visitedCount = 0;
    sccList.clear();

    // 모든 정점에 대해 DFS
    for (int u = 1; u <= V; u++) {
        if (visited[u] == -1) dfs(u);
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

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}
