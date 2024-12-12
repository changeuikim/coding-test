# [Gold IV] [특정한 최단 경로](https://www.acmicpc.net/problem/1504) - 1504 

NaN데이크스트라, 그래프 이론, 최단 경로

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>

using namespace std;
using pii = pair<int, int>;

const int MAX = 10000001;
vector<vector<pii>> graph;

vector<int> dijkstra(int start, int N) {
    vector<int> dist(N + 1, MAX);
    dist[start] = 0;

    priority_queue<pii, vector<pii>, greater<>> pq;
    pq.push({0, start});

    while (!pq.empty()) {
        auto [cur_dist, u] = pq.top();
        pq.pop();

        if (cur_dist > dist[u]) continue;

        for (auto [v, w] : graph[u]) {
            int nxt_dist = cur_dist + w;
            if (nxt_dist < dist[v]) {
                dist[v] = nxt_dist;
                pq.emplace(nxt_dist, v);
            }
        }
    }

    return dist;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);

    int N, E;
    cin >> N >> E;

    // 인접리스트 초기화
    graph.resize(N + 1);
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].emplace_back(v, w);
        graph[v].emplace_back(u, w);
    }

    int v1, v2;
    cin >> v1 >> v2;

    // 1, V1, V2에서 출발하는 거리배열
    vector<int> from_1 = dijkstra(1, N);
    vector<int> from_v1 = dijkstra(v1, N);
    vector<int> from_v2 = dijkstra(v2, N);

    // 경로1 : 1 -> v1 -> v2 -> N
    // 경로2 : 1 -> v2 -> v1 -> N
    long long path1 = (long long) from_1[v1] + from_v1[v2] + from_v2[N];
    long long path2 = (long long) from_1[v2] + from_v2[v1] + from_v1[N];
    long long result = min(path1, path2);

    if (result >= MAX) {
        cout << -1;
    } else {
        cout << result;
    }
}
```

### 성능 요약

시간: 36 ms

메모리: 5916 KB

### 제출 일자

2024년 12월 12일 (목) 13:22

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

