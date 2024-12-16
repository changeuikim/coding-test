# [Gold V] [집합의 표현](https://www.acmicpc.net/problem/1717) - 1717 

NaN자료 구조, 분리 집합

## C++17 (Clang) 문제풀이

```C++17 (Clang)
#include <bits/stdc++.h>
using namespace std;

void disjointSet() {
    // 부모 노드 초기화
    int N, M;
    cin >> N >> M;

    vector<int> parent(N + 1);
    iota(parent.begin(), parent.end(), 0);

    auto find = [&](int x) -> int {
        // 경로 압축
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    };

    auto unionSets = [&](int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA > rootB) {
            parent[rootA] = rootB;
        } else {
            parent[rootB] = rootA;
        }
    };

    // 서로소 집합 연산
    while (M--) {
        int op, a, b;
        cin >> op >> a >> b;

        if (op == 0) {
            unionSets(a, b);
        } else {
            cout << (find(a) == find(b) ? "YES" : "NO") << "\n";
        }
    }
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    disjointSet();
}
```

### 성능 요약

시간: 32 ms

메모리: 6120 KB

### 제출 일자

2024년 12월 16일 (월) 23:56

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

