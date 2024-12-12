# [Gold IV] [특정한 최단 경로](https://www.acmicpc.net/problem/1504) - 1504 

NaN데이크스트라, 그래프 이론, 최단 경로

## PyPy3 문제풀이

```PyPy3
from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

# 인접리스트 초기화
MAX = 10000001
N, E = map(int, input().split())
graph = [[] for _ in range(N + 1)]

for _ in range(E):
    u, v, w = map(int, input().split())

    graph[u].append((v, w))
    graph[v].append((u, w))

v1, v2 = map(int, input().split())

# 다익스트라
def dijkstra(S, N, graph):
    dist = [MAX] * (N + 1)
    dist[S] = 0

    heap = []
    heappush(heap, (0, S))

    while heap:
        cur_dist, u = heappop(heap)

        if cur_dist > dist[u]:
            continue
        
        for v, w in graph[u]:
            nxt_dist = cur_dist + w
            if nxt_dist < dist[v]:
                dist[v] = nxt_dist
                heappush(heap, (nxt_dist, v))
    
    return dist

# 1, V1, V2에서 출발하는 다익스트라
from_1 = dijkstra(1, N, graph)
from_v1 = dijkstra(v1, N, graph)
from_v2 = dijkstra(v2, N, graph)

# 경로1 : 1 -> v1 -> v2 -> N
# 경로2 : 1 -> v2 -> v1 -> N
path1 = from_1[v1] + from_v1[v2] + from_v2[N]
path2 = from_1[v2] + from_v2[v1] + from_v1[N]
result = min(path1, path2)

if result >= MAX:
    print(-1)
else:
    print(result)
```

### 성능 요약

시간: 272 ms

메모리: 126200 KB

### 제출 일자

2024년 12월 12일 (목) 13:21

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

