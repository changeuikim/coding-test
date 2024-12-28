from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

def dijkstra():
    N = int(input().rstrip())
    M = int(input().rstrip())

    # 인접리스트 초기화
    graph = [[] for _ in range(N + 1)]
    for _ in range(M):
        u, v, w = map(int, input().split())
        graph[u].append((v, w))
    
    # 출발점, 도착점
    S, E = map(int, input().split())

    # 거리 초기화
    INF = int(1e9)
    dist = [INF] * (N + 1)
    dist[S] = 0

    # 우선순위 큐 초기화
    pq = []
    heappush(pq, (0, S))

    # 추적 초기화
    trace = [-1] * (N + 1)

    # 다익스트라
    while pq:
        cur, u = heappop(pq)

        if cur > dist[u]: continue
        if u == E: break # 도착점

        for v, w in graph[u]:
            nxt = cur + w
            if dist[v] > nxt:
                dist[v] = nxt
                heappush(pq, (nxt, v))
                trace[v] = u

    # 최단거리 간선복원
    path = []
    node = E
    while node != -1:
        path.append(node)
        node = trace[node]
    
    path.reverse()

    print(dist[E])
    print(len(path))
    print(*path)

dijkstra()