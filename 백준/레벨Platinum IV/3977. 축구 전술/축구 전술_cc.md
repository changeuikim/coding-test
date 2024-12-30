# [Platinum IV] [축구 전술](https://www.acmicpc.net/problem/3977) - 3977 

NaN그래프 이론, 강한 연결 요소

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

void tarjan() {
    // 테스트 케이스 T회 (T <= 11)
    int T;
    cin >> T;
    while (T--) {
        // 정점 N 간선 M (1 ≤ N, M ≤ 100,000)
        int N, M;
        cin >> N >> M;

        // 1. 간선 리스트 초기화
        vector<vector<int>> graph(N);
        for (int i = 0; i < M; i++) {
            int u, v;
            cin >> u >> v;
            graph[u].push_back(v);
        }

        // SCC 목록
        unordered_map<int, vector<int>> sccMap;
        vector<int> sccID(N, -1);
        int sccNum = 0;

        // SCC 후보
        stack<int> sccStk;
        vector<bool> onStk(N, false);

        // 발견
        vector<int> disc(N, -1);
        int discTime = 0;
        vector<int> lowlink(N, -1);

        // 2. 모든 정점에 대해 DFS
        for (int start = 0; start < N; start++) {
            if (disc[start] == -1) {
                stack<pii> dsfStk;
                dsfStk.push({start, 0});

                // Iterative Tarjan
                while (!dsfStk.empty()) {
                    auto [u, i] = dsfStk.top();

                    // u를 첫방문
                    if (disc[u] == -1) {
                        // lowlink 갱신 1
                        lowlink[u] = disc[u] = discTime++;

                        // SCC 후보에 u 추가
                        sccStk.push(u);
                        onStk[u] = true;
                    }

                    // 자식 v를 탐색 : for v in graph[u]
                    if (i < graph[u].size()) {
                        int v = graph[u][i];
                        // 다음 v로 미리 이동
                        dsfStk.pop();
                        dsfStk.push({u, i + 1});

                        // v를 첫방문
                        if (disc[v] == -1) {
                            dsfStk.push({v, 0});
                        }
                        // v가 SCC 후보
                        else if (onStk[v]) {
                            // lowlink 갱신 2
                            lowlink[u] = min(lowlink[u], lowlink[v]);
                        }
                    }
                    // 탐색할 v가 없으면
                    else {
                        // dfs(v)를 콜스택에서 팝
                        dsfStk.pop();

                        // 부모 노드가 남아있다면
                        if (!dsfStk.empty()) {
                            int parent = dsfStk.top().first;
                            // lowlink 갱신 3
                            lowlink[parent] = min(lowlink[parent], lowlink[u]);
                        }

                        // u가 새로운 SCC의 루트라면
                        if (lowlink[u] == disc[u]) {
                            vector<int> cur_scc;

                            // 새로운 SCC 구성하기
                            while (true) {
                                int top = sccStk.top();
                                sccStk.pop();
                                onStk[top] = false;
                                cur_scc.push_back(top);
                                sccID[top] = sccNum;
                                if (top == u) break;
                            }

                            sccMap[sccNum++] = cur_scc;
                        }
                    }
                }
            }
        }

        // 3. 진입차수 0인 SCC를 확인
        vector<int> indegree(sccNum, 0);
        for (int u = 0; u < N; u++) {
            for (int v : graph[u]) {
                // 서로 다른 SCC를 연결하면 진입차수 증가
                if (sccID[v] != sccID[u]) {
                    indegree[sccID[v]]++;
                }
            }
        }

        // 4. 출력 처리
        vector<int> entry;
        for (int i = 0; i < sccNum; i++) {
            if (indegree[i] == 0) {
                entry.push_back(i);
            }
        }

        if (entry.size() == 1) {
            auto &result = sccMap[entry[0]];
            sort(result.begin(), result.end());
            for (int v : result) {
                cout << v << '\n';
            }
        } else {
            cout << "Confused\n";
        }
        cout << '\n';
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    tarjan();
}
```

### 성능 요약

시간: 268 ms

메모리: 14800 KB

### 제출 일자

2024년 12월 30일 (월) 23:51

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

