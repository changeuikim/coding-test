#include <bits/stdc++.h>

// 결과         메모리	시간
// 크루스칼     4456	36
// 프림         5992	40

using namespace std;
using pii = pair<int, int>;

vector<int> parent;

struct Edge {
    int u, v, w;

    bool operator<(const Edge& other) const {
        return w < other.w;
    }    
};

int find(int x) {
    if (parent[x] < 0) return x;
    return parent[x] = find(parent[x]);
}

void unionSet(int a, int b) {
    a = find(a);
    b = find(b);

    if (a == b) return;

    if (parent[a] > parent[b]) swap(a, b);
    parent[a] += parent[b];
    parent[b] = a;
}

void kruskal() {
    int V, E;
    cin >> V >> E;

    // 간선 리스트 초기화
    vector<Edge> graph;
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph.push_back({u, v, w});
    }

    // 가중치 기준 오름차순 정렬
    sort(graph.begin(), graph.end());

    // 분리 집합
    parent.resize(V + 1, -1);

    // 크루스칼 알고리즘
    int mstCost = 0, edgeCount = 0;

    for (const Edge& edge : graph) {
        int u = edge.u, v = edge.v, w = edge.w;

        if (find(u) != find(v)) {
            unionSet(u, v);
            mstCost += w;
            edgeCount++;
            if (edgeCount == V - 1) break;
        }
    }

    cout << mstCost;
}


void prim() {
    int V, E;
    cin >> V >> E;

    // 인접 리스트 초기화
    vector<vector<pii>> graph(V + 1);
    for (int i = 0; i < E; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].emplace_back(v, w);
        graph[v].emplace_back(u, w);
    }

    // 거리, 방문, 우선순위 큐 초기화
    const int MAX = 1e9;
    vector<int> dist(V + 1, MAX);
    vector<bool> visited(V + 1, false);
    priority_queue<pii, vector<pii>, greater<>> pq;
    int mst_cost = 0;

    dist[1] = 0;
    pq.emplace(0, 1);

    // 프림 알고리즘
    while (!pq.empty()) {
        auto [cur_dist, u] = pq.top();
        pq.pop();

        if (visited[u]) continue;

        visited[u] = true;
        mst_cost += cur_dist;

        for (auto [v, nxt_dist] : graph[u]) {
            if (!visited[v] && nxt_dist < dist[v]) {
                dist[v] = nxt_dist;
                pq.emplace(nxt_dist, v);
            }
        }
    }

    cout << mst_cost;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    kruskal();
    // prim();
}