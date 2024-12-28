# [Gold IV] [네트워크 연결](https://www.acmicpc.net/problem/1922) - 1922 

NaN그래프 이론, 최소 스패닝 트리

## C++17 (Clang) 문제풀이

```C++17 (Clang)
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
```

### 성능 요약

시간: 44 ms

메모리: 8816 KB

### 제출 일자

2024년 12월 28일 (토) 17:46

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

