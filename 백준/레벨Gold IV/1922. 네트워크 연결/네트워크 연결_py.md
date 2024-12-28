# [Gold IV] [네트워크 연결](https://www.acmicpc.net/problem/1922) - 1922 

NaN그래프 이론, 최소 스패닝 트리

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def kruskal():
    V = int(input().rstrip())
    E = int(input().rstrip())

    # 엣지리스트 초기화
    graph = []
    for _ in range(E):
        graph.append(list(map(int, input().split())))

    # 부모노드 1 ~ N 초기화
    parent = [i for i in range(V + 1)]

    # 파인드
    def find(x):
        while parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x

    # 유니온
    def union(a, b):
        a, b = find(a), find(b)
        if a == b: return False

        if a > b: parent[a] = b
        else: parent[b] = a
        return True

    # 크루스칼
    mst_cost = 0
    edge_cnt = 0
    
    graph.sort(key=lambda x: x[2]) # w 정렬

    for u, v, w in graph:
        if edge_cnt >= V - 1: break
        if union(u, v):
            mst_cost += w
            edge_cnt += 1

    print(mst_cost)

kruskal()
```

### 성능 요약

시간: 244 ms

메모리: 126936 KB

### 제출 일자

2024년 12월 28일 (토) 17:46

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

