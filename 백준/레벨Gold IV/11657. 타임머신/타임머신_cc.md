# [Gold IV] [타임머신](https://www.acmicpc.net/problem/11657) - 11657 

NaN벨만–포드, 그래프 이론, 최단 경로

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int u, v, w;
};

void bellmanFord() {
    int N, M;
    cin >> N >> M;

    // 간선 리스트 초기화
    vector<Edge> graph(M);
    for (int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[i] = {u, v, w};
    }

    // 거리 배열 초기화
    const long long INF = 500LL * 10000 + 1;
    vector<long long> dist(N + 1, INF);
    dist[1] = 0;

    // (노드-1)회 반복
    for (int i = 0; i < N - 1; i++) {
        for (const auto& edge : graph) {
            if (dist[edge.u] == INF) continue;

            long long nxt = dist[edge.u] + edge.w;
            if (dist[edge.v] > nxt) dist[edge.v] = nxt;
        }
    }

    // 음의 사이클 검사
    bool isCycle = false;
    for (const auto& edge : graph) {
        if (dist[edge.u] == INF) continue;

        if (dist[edge.v] > dist[edge.u] + edge.w) {
            isCycle = true;
            break;
        }
    }

    // 출력 처리
    if (isCycle) {
        cout << -1;
    } else {
        for (int i = 2; i <= N; i++) {
            if (dist[i] == INF) {
                cout << -1;
            } else {
                cout << dist[i];
            }
            cout << "\n";
        }
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    bellmanFord();
}
```

### 성능 요약

시간: 4 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 19일 (목) 22:01

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

