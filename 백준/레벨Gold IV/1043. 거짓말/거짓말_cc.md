# [Gold IV] [거짓말](https://www.acmicpc.net/problem/1043) - 1043 

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
    
    for (int node : nodes) {
        parent[node] = x;
    }
    return x;
}

void unionSet(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    
    if (rootA > rootB) parent[rootA] = rootB;
    else parent[rootB] = rootA;
}

void disjointSet() {
    // 부모노드 초기화
    int N, M;
    cin >> N >> M;

    parent.resize(N + 1);
    for (int i = 0; i <= N; i++) parent[i] = i;
    
    // 진실노드 초기화
    int truthSize;
    cin >> truthSize;

    if (truthSize == 0) {
        cout << M;
        return;
    }
    
    vector<int> truth(truthSize);
    for (int i = 0; i < truth.size(); i++) cin >> truth[i];
    
    // 파티노드 초기화
    vector<vector<int>> parties;
    for (int i = 0; i < M; i++) {
        int partySize;
        cin >> partySize;

        vector<int> party(partySize);
        for (int j = 0; j < party.size(); j++) cin >> party[j];
        parties.push_back(party);
        
        for (int j = 0; j < party.size() - 1; j++) {
            unionSet(party[j], party[j + 1]);
        }
    }
    
    // 진실노드로 병합
    int root = find(truth[0]);
    for (int i = 1; i < truth.size(); i++) {
        unionSet(truth[i], root);
    }
    
    // 파티 처리
    int count = M;
    for (const auto& party : parties) {
        if (find(party[0]) == find(root)) count--;
    }
    
    cout << count;
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

2024년 12월 17일 (화) 11:18

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

