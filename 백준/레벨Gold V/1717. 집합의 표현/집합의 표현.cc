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