# [Platinum V] [행성 터널](https://www.acmicpc.net/problem/2887) - 2887 

NaN그래프 이론, 최소 스패닝 트리, 정렬

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

/*
    비용은 두 행성 간의 최소 축 차이: min(|xA - xB|, |yA - yB|, |zA - zB|) 
    모든 행성 간의 간선을 계산하면 nC2 = O(N^2), 이는 N = 1e5일 때 약 50억 개로 시간 초과 발생 
    최적화 방법:
        - x, y, z 축별로 좌표를 기준으로 행성을 정렬한 뒤,
        - 인접한 두 행성 사이의 간선만 고려 -> 축별로 N-1개의 간선 
        - 총 간선 개수: 3(N-1), 시간 복잡도: O(N log N), 이는 N = 1e5일때 약 170만으로 안전범위
*/

struct Planet {
    int vertex;
    array<int, 3> pos; // x, y, z 좌표를 배열로 저장

    Planet(int vertex, int x, int y, int z) : vertex(vertex), pos({x, y, z}) {}
};

struct Edge {
    int u, v, w;

    Edge(int u, int v, int w) : u(u), v(v), w(w) {}

    bool operator<(const Edge &o) const {
        return w < o.w;
    }
};

vector<Planet> planets;
vector<Edge> graph;
vector<int> parent;

// 파인드드
int find(int x) {
    while (parent[x] != x) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

// 유니온
bool union_sets(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return false;

    if (a > b) parent[a] = b;
    else parent[b] = a;
    return true;
}

void kruskal() {
    // 행성의 개수 N (1 ≤ N ≤ 100,000)
    int N;
    cin >> N;

    // 행성정보 0-based
    planets.reserve(N);
    for (int i = 0; i < N; i++) {
        int x, y, z;
        cin >> x >> y >> z;
        planets.emplace_back(i, x, y, z);
    }

    // 간선 리스트 초기화
    int M = (N - 1) * 3;
    graph.reserve(M);

    for (int i = 0; i < 3; i++) {
        // x, y, z축 기준으로 정렬
        sort(planets.begin(), planets.end(),
            [i](const Planet &a, const Planet &b) {
                return a.pos[i] < b.pos[i];
            });

        for (int j = 0; j < N - 1; j++) {
            int u = planets[j].vertex;
            int v = planets[j + 1].vertex;
            int w = abs(planets[j + 1].pos[i] - planets[j].pos[i]);
            graph.emplace_back(u, v, w);
        }
    }

    // 부모노드 0 ~ N-1 초기화
    parent.resize(N);
    iota(parent.begin(), parent.end(), 0);

    // 크루스칼
    int mstCost = 0;
    int edgeCount = 0;

    sort(graph.begin(), graph.end()); // w 기준 정렬

    for (const Edge &edge : graph) {
        int u = edge.u, v = edge.v, w = edge.w;
        if (edgeCount >= N - 1) break;
        if (union_sets(u, v)) {
            mstCost += w;
            edgeCount++;
        }
    }

    cout << mstCost;
}

int main() {
    ios::sync_with_stdio(0);
    cin.tie(0);
    kruskal();
}
```

### 성능 요약

시간: 84 ms

메모리: 7688 KB

### 제출 일자

2024년 12월 31일 (화) 21:42

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

