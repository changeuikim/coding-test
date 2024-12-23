# [Gold I] [도로검문](https://www.acmicpc.net/problem/2307) - 2307 

NaN데이크스트라, 그래프 이론, 최단 경로

## PyPy3 문제풀이

```PyPy3
import sys
from heapq import heappush, heappop

input = sys.stdin.readline
INF = int(1e9)

def solution():
    N, M = map(int, input().split())

    # 인접리스트 초기화
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
        graph[v].append((u, w))

    def dijkstra(skip, isTrace):
        # 간선정보 추적
        trace = [0] * (N + 1) if isTrace else None

        # 거리 초기화
        dist = [INF] * (N + 1)
        dist[1] = 0

        # 우선순위 큐 초기화
        pq = []
        heappush(pq, (0, 1))

        # 다익스트라
        while pq:
            cur, u = heappop(pq)

            if cur > dist[u]: continue

            for v, w in graph[u]:
                # 간선 끊기
                if skip == (u, v): continue

                nxt = cur + w
                if nxt < dist[v]:
                    # 간선 저장
                    if isTrace: trace[v] = u
                    dist[v] = nxt
                    heappush(pq, (nxt, v))

        return dist[N], trace

    # 최단 시간과 간선 추적
    min_time, trace = dijkstra((0, 0), True)

    # 최단 시간의 간선 복원
    edges = []
    node = N
    while trace[node]:
        edges.append((trace[node], node))
        node = trace[node]

    # 간선 하나씩 끊기
    max_diff = -1
    for u, v in edges:
        delay_time, _ = dijkstra((u, v), False)

        if delay_time == INF:
            print(-1)
            return
        
        max_diff = max(max_diff, delay_time - min_time)

    print(max_diff)    

solution()
```

### 성능 요약

시간: 572 ms

메모리: 115084 KB

### 제출 일자

2024년 12월 23일 (월) 10:16

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

