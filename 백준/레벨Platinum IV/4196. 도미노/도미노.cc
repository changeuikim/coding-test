#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

void iterativeTarjan() {
    // 테스트 케이스 T회
    int T;
    cin >> T;
    while (T--) {
        // SSC그룹핑 -> DAG생성 -> 진입차수 확인
        int V, E;
        cin >> V >> E;

        // 1. 인접리스트 초기화
        vector<vector<int>> graph(V + 1, vector<int>());

        for (int i = 0; i < E; i++) {
            int u, v;
            cin >> u >> v;
            graph[u].push_back(v);
        }     

        // SCC 후보 스택, 정점의 스택 포함 여부
        stack<int> sccStack;
        vector<bool> inStack(V + 1, false);
        // DFS 방문순서, 카운터
        vector<int> visited(V + 1, -1);
        int visitedCount = 0;
        // SSC id, 현재
        vector<int> sccID(V + 1, -1);
        int curSCC = 0;
        // low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
        vector<int> low(V + 1, -1);
        
        // 2. 모든 정점에 대해 DFS
        for (int start = 1; start <= V; start++) {
            if (visited[start] == -1) {
                stack<pii> dfsStack;
                dfsStack.emplace(start, 0);                

                while (!dfsStack.empty()) {
                    auto [u, i] = dfsStack.top();

                    // 첫 방문
                    if (visited[u] == -1) {
                        // low 갱신 1
                        visited[u] = low[u] = visitedCount++;
                        // 스택에 u를 추가
                        sccStack.push(u);
                        inStack[u] = true;
                    }

                    // 인접 정점을 탐색
                    if (i < graph[u].size()) {
                        int v = graph[u][i];
                        dfsStack.pop();
                        dfsStack.push({u, i + 1});

                        // 첫 방문
                        if (visited[v] == -1) {
                            dfsStack.push({v, 0});
                        }
                        // SCC 후보
                        else if (inStack[v]) {
                            // low 갱신 2
                            low[u] = min(low[u], visited[v]);
                        }
                    }
                    // 탐색을 완료하면
                    else {
                        // dfs(v)
                        dfsStack.pop();
                        if (!dfsStack.empty()) {
                            int parent = dfsStack.top().first;
                            // low 갱신 3
                            low[parent] = min(low[parent], low[u]);
                        }

                        // u가 SCC 루트 정점
                        if (low[u] == visited[u]) {
                            // u의 SCC 구성하기
                            while (true) {
                                int top = sccStack.top();
                                sccStack.pop();
                                inStack[top] = false;
                                sccID[top] = curSCC;
                                if (top == u) break;
                            }
                            curSCC++;
                        }
                    }
                }                
            }
        }

        // 3. SCC 단위로 DAG 생성
        vector<int> indegree(curSCC, 0);
        for (int u = 1; u <= V; u++) {
            for (int v : graph[u]) {
                // 서로 다른 SCC를 연결하면 진입차수 증가
                if (sccID[u] != sccID[v]) {
                    indegree[sccID[v]]++;
                }
            }
        }  

        // 4. 진입차수 0인 SCC의 개수
        cout << count(indegree.begin(), indegree.end(), 0) << "\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    iterativeTarjan();
}