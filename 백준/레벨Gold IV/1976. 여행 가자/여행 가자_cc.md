# [Gold IV] [여행 가자](https://www.acmicpc.net/problem/1976) - 1976 

NaN자료 구조, 분리 집합, 그래프 이론, 그래프 탐색

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

vector<int> parent;

int find(int x) {
    vector<int> nodes;
    while (parent[x] != x) {
        nodes.push_back(x);
        x = parent[x];
    }
    // 한번에 경로 압축
    for (int node : nodes) {
        parent[node] = x;
    }
    return x;
}

void union_set(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA == rootB) return;

    if (rootA > rootB) parent[rootA] = rootB;
    else parent[rootB] = rootA;
}

void disjointSet() {
    // 부모 노드 초기화
    int N, M;
    cin >> N >> M;

    parent.resize(N + 1);
    iota(parent.begin(), parent.end(), 0);

    // 분리 집합
    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= N; j++) {
            int t;
            cin >> t;

            if (t == 1) {
                union_set(i, j);
            }
        }
    }

    // 경로 검증
    vector<int> cities(M);
    for (int i = 0; i < M; i++) {
        cin >> cities[i];
    }

    int root = find(cities[0]);
    bool isPossible = all_of(cities.begin(), cities.end(), [&](int city) {
        return find(city) == root;
    });

    cout << (isPossible ? "YES" : "NO");
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    disjointSet();
}
```

### 성능 요약

시간: 0 ms

메모리: 2212 KB

### 제출 일자

2024년 12월 17일 (화) 01:09

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

