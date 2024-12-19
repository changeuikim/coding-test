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