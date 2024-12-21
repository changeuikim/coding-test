# [Gold IV] [최소 스패닝 트리](https://www.acmicpc.net/problem/1197) - 1197 

NaN최소 스패닝 트리, 그래프 이론

## PyPy3 문제풀이

```PyPy3
# 결과	    메모리	시간
# 크루스칼  134016	264
# 프림      126780	244

from sys import stdin
# from collections import defaultdict
from heapq import heappush, heappop

input = stdin.readline

# def kruskal():
#     V, E = map(int, input().split())
    
#     # 간선리스트 초기화
#     graph = defaultdict(list)

#     for _ in range(E):
#         u, v, w = map(int, input().split())
#         graph[w].append((u, v))
   
#     # 가중치 기준 오름차순 정렬
#     weights = sorted(graph.keys())
    
#     # 분리 집합
#     parent = [-1] * (V + 1)

#     def find(x):
#         nodes = []
#         while parent[x] >= 0:
#             nodes.append(x)
#             x = parent[x]
#         for node in nodes:
#             parent[node] = x
#         return x
    
#     def union(a, b):
#         root_a = find(a)
#         root_b = find(b)

#         if root_a == root_b:
#             return
        
#         if root_a > root_b:
#             parent[root_a] = root_b
#         else:
#             parent[root_b] = root_a
    
#     # 크루스칼 알고리즘
#     mst_cost = 0
#     edge_count = 0

#     for w in weights:
#         for u, v in graph[w]:
#             if find(u) != find(v):
#                 union(u, v)
#                 mst_cost += w
#                 edge_count += 1

#                 if edge_count == V - 1:
#                     print(mst_cost)
#                     return

#     print(mst_cost)

def prim():
    V, E = map(int, input().split())

    # 인접리스트 초기화
    graph = [[] for _ in range(V + 1)]

    for _ in range(E):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
        graph[v].append((u, w))

    # 거리, 방문, 힙 초기화
    MAX = int(1e9)
    dist = [MAX] * (V + 1)
    visited = [False] * (V + 1)
    pq = []
    mst_cost = 0

    dist[1] = 0
    heappush(pq, (0, 1))

    # 프림 알고리즘
    while pq:
        cur_dist, u = heappop(pq)

        if cur_dist > dist[u]: continue

        visited[u] = True
        mst_cost += cur_dist

        for v, nxt_dist in graph[u]:
            if not visited[v] and nxt_dist < dist[v]:
                dist[v] = nxt_dist
                heappush(pq, (nxt_dist, v))

    print(mst_cost)

# kruskal()
prim()
```

### 성능 요약

시간: 264 ms

메모리: 126776 KB

### 제출 일자

2024년 12월 21일 (토) 12:44

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

