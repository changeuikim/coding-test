# [Gold III] [파티](https://www.acmicpc.net/problem/1238) - 1238 

NaN데이크스트라, 그래프 이론, 최단 경로

## PyPy3 문제풀이

```PyPy3
from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

# 정방향, 역방향 인접리스트 초기화
N, M, X = map(int, input().split())
f_graph = [[] for _ in range(N + 1)]
r_graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v, w = map(int, input().split())
    f_graph[u].append((v, w))
    r_graph[v].append((u, w))

# 다익스트라
def dijkstra(N, S, graph):
    MAX = 100001
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

# 집 -> X -> 집
home_to_party = dijkstra(N, X, f_graph)
party_to_home = dijkstra(N, X, r_graph)

# 최대시간 찾기
max_time = -1
for i in range(1, N + 1):
    curr_time = home_to_party[i] + party_to_home[i]
    if curr_time > max_time:
        max_time = curr_time

print(max_time)
```

### 성능 요약

시간: 148 ms

메모리: 112120 KB

### 제출 일자

2024년 12월 12일 (목) 11:51

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

