#include <bits/stdc++.h>
using namespace std;

vector<int> parent;

int find(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

bool unionSets(int a, int b) {
    a = find(a), b = find(b);
    if (a == b) return false;

    if (a > b) parent[a] = b;
    else parent[b] = a;
    return true;
}

void kruskal() {
    int V, E;
    cin >> V >> E;

    // 엣지리스트 초기화
    vector<vector<int>> graph;
    while (E--) {
        int u, v, w;
        cin >> u >> v >> w;
        graph.push_back({u, v, w});
    }

    // 부모노드 1 ~ N 초기화화
    parent.resize(V + 1);
    iota(parent.begin(), parent.end(), 0);

    // 크루스칼
    int mstCost = 0;
    int edgeCnt = 0;

    // w정렬
    sort(graph.begin(), graph.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[2] < b[2];
    });

    for (const auto& edge : graph) {
        int u = edge[0], v = edge[1], w = edge[2];
        if (edgeCnt >= V - 1) break;
        if (unionSets(u, v)) {
            mstCost += w;
            edgeCnt++;
        }
    }

    cout << mstCost;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    kruskal();
}