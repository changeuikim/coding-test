# [Platinum IV] [2-SAT - 3](https://www.acmicpc.net/problem/11280) - 11280 

NaN2-sat, 그래프 이론, 강한 연결 요소

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

void iterativeTarjan() {
    int N, M;
    cin >> N >> M;

    // 1. 음수,양수 인접리스트 초기화
    vector<vector<int>> graph(N * 2 + 1, vector<int>());

    for (int i = 0; i < M; i++) {
        int u, v;
        cin >> u >> v;

        // u Or V는 ~u -> v 또는 ~v -> u이다
        int nu1 = u * -1, nv1 = v;
        if (nu1 < 0) nu1 = N - nu1;
        if (nv1 < 0) nv1 = N - nv1;
        graph[nu1].push_back(nv1);

        int nu2 = v * -1, nv2 = u;
        if (nu2 < 0) nu2 = N - nu2;
        if (nv2 < 0) nv2 = N - nv2;
        graph[nu2].push_back(nv2);
    }     

    // SCC 후보
    stack<int> sccStk;
    vector<bool> onStk(N * 2 + 1, false);
    // 발견 순서, 발견 시간
    vector<int> disc(N * 2 + 1, -1);
    int timestamp = 0;
    // SCC id, SCC 번호
    vector<int> sccID(N * 2 + 1, -1);
    int sccCnt = 0;
    // 정점의 도달 가능한 최소 방문 순서
    vector<int> low(N * 2 + 1, -1);
    
    // 2. 모든 정점에 대해 DFS
    for (int start = 1; start <= N * 2; start++) {
        if (disc[start] == -1) {
            stack<pii> dfsStack;
            dfsStack.emplace(start, 0);                

            while (!dfsStack.empty()) {
                auto [u, i] = dfsStack.top();

                // u 첫 방문
                if (disc[u] == -1) {
                    // lowlink 갱신 1
                    disc[u] = low[u] = timestamp++;
                    // SCC 후보에 u 추가
                    sccStk.push(u);
                    onStk[u] = true;
                }

                // 자식 v를 탐색: for v in graph[u]
                if (i < graph[u].size()) {
                    int v = graph[u][i];
                    dfsStack.pop();
                    dfsStack.push({u, i + 1});

                    // v 첫방문
                    if (disc[v] == -1) {
                        dfsStack.push({v, 0});
                    }
                    // v가 SCC 후보라면
                    else if (onStk[v]) {
                        // lowlink 갱신 2
                        low[u] = min(low[u], disc[v]);
                    }
                }
                // 탐색할 v가 없으면
                else {
                    // dfs(v)를 콜스택에서 제거
                    dfsStack.pop();
                    // 부모가 있다면
                    if (!dfsStack.empty()) {
                        int parent = dfsStack.top().first;
                        // lowlink 갱신 3 : u의 자식들의 최소값을 u의 부모에 전파
                        low[parent] = min(low[parent], low[u]);
                    }

                    // u가 이번 SCC의 루트 : 역방향 간선이 없고, 자식 중에서도 가장 빠르다
                    if (low[u] == disc[u]) {
                        // 새 SCC를 구성
                        while (true) {
                            int top = sccStk.top();
                            sccStk.pop();
                            onStk[top] = false;
                            // 정점의 SCC 번호 기록
                            sccID[top] = sccCnt;
                            if (top == u) break;
                        }
                        sccCnt++;
                    }
                }
            }                
        }
    }

    // 3. 정점 u와 정점 -u의 scc_cnt를 대조
    for (int u = 1; u <= N; u++) {
        if (sccID[u] == sccID[u + N]) {
            cout << 0;
            return;
        }
    }
    cout << 1;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    iterativeTarjan();
}
```

### 성능 요약

시간: 24 ms

메모리: 4528 KB

### 제출 일자

2024년 12월 27일 (금) 11:43

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

