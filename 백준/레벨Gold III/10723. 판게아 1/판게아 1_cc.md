# [Gold III] [판게아 1](https://www.acmicpc.net/problem/10723) - 10723 

NaN그래프 이론, 최소 스패닝 트리

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

struct Edge {
    int w, u, v;

    Edge(int w, int u, int v) : w(w), u(u), v(v) {}

    bool operator<(const Edge& o) const {
        return w < o.w;
    }
};

// 전역변수
int N;
vector<Edge> edges;
vector<int> parent;

int find(int x) {
    while (x != parent[x]) {
        parent[x] = parent[parent[x]];
        x = parent[x];
    }
    return x;
}

bool unionSets(int a, int b) {
    a = find(a);
    b = find(b);
    if (a == b) return false;

    if (a > b) parent[a] = b;
    else parent[b] = a;
    return true;    
}

long long kruskal(vector<Edge>& edges) {
    // 부모 + 랭크 노드
    iota(parent.begin(), parent.end(), 0);

    // 가중치 기준 정렬
    sort(edges.begin(), edges.end());

    // 최소 신장 트리
    long long mstCost = 0;
    int edgeCount = 0;

    for (Edge& edge : edges) {
        int w = edge.w, u = edge.u, v = edge.v;
        if (edgeCount >= N - 1) break;
        if (unionSets(u, v)) {
            mstCost += w;
            edgeCount++;
        }
    }

    return mstCost;
}

void solution() {
    // 1. 테스트 T회
    int T;
    cin >> T;
    while (T--) {
        int M;
        cin >> N >> M;
        parent.resize(N + 1);

        // 2. 태초의 세계, 엣지 리스트
        edges.clear();
        for (int i = 1; i < N; i++) {
            int u, c;
            cin >> u >> c;
            edges.emplace_back(c, i, u); // w, u, v
        }

        // 3. 조물주가 새로이 놓은 도로
        long long result = 0;
        for (int j = 1; j <= M; j++) {
            int u, v, c;
            cin >> u >> v >> c;
            edges.emplace_back(c, u, v); // w, u, v

            // 5. XOR 연산
            result ^= kruskal(edges); // 4. 크루스칼
        }

        cout << result << "\n";
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    solution();
} 
```

### 성능 요약

시간: 1900 ms

메모리: 2352 KB

### 제출 일자

2024년 12월 24일 (화) 19:43

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

