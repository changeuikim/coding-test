#include <bits/stdc++.h>
using namespace std;
using pii = pair<int, int>;

const int INF = 1e9;
int N, M;
vector<vector<pii>> graph;

struct State {
    int dist;
    vector<int> trace;
    State(int d, vector<int> t) : dist(d), trace(t) {}
};

struct Edge {
    int cost, node;
    Edge(int c, int n) : cost(c), node(n) {}
    bool operator>(const Edge& o) const {
        return cost > o.cost;
    }
};

State dijkstra(pii skip, bool isTrace) {
    // 간선정보 추적
    vector<int> trace = isTrace ? vector<int>(N + 1) : vector<int>();

    // 거리 초기화
    vector<int> dist(N + 1, INF);
    dist[1] = 0;

    // 우선순위 큐 초기화
    priority_queue<Edge, vector<Edge>, greater<Edge>> pq;
    pq.push(Edge(0, 1));

    // 다익스트라
    while (!pq.empty()) {
        auto [cur, u] = pair(pq.top().cost, pq.top().node);
        pq.pop();

        if (cur > dist[u]) continue;

        for (auto [v, w] : graph[u]) {

            // 간선 끊기
            if (skip.first == u && skip.second == v) continue;

            int nxt = cur + w;
            if (nxt < dist[v]) {
                // 간선 저장
                if (isTrace) trace[v] = u;
                dist[v] = nxt;
                pq.push(Edge(nxt, v));
            }
        }
    }

    return State(dist[N], trace);
}

void solution() {
    cin >> N >> M;

    // 인접리스트 초기화
    graph.resize(N + 1);
    for (int i = 0; i < M; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].emplace_back(v, w);
        graph[v].emplace_back(u, w);
    }

    // 최단 시간과 간선 추적
    auto [minTime, trace] = dijkstra({0, 0}, true);

    // 최단 시간의 간선 복원
    vector<pii> edges;
    int node = N;
    while (trace[node]) {
        edges.emplace_back(trace[node], node);
        node = trace[node];
    }

    // 간선 하나씩 끊기
    int maxDiff = -1;
    for (auto [u, v] : edges) {
        auto [delayTime, _] = dijkstra({u, v}, false);

        if (delayTime == INF) {
            cout << -1;
            return;
        }

        maxDiff = max(maxDiff, delayTime - minTime);
    }

    cout << maxDiff;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
}