from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

# 인접리스트 초기화
N = int(input().rstrip())
M = int(input().rstrip())
graph = [[] for _ in range(N + 1)]

for _ in range(M):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

S, E = map(int, input().split())

# 다익스트라
costs = [float('inf')] * (N + 1)
costs[S] = 0

heap = []
heappush(heap, (0, S))

while heap:
    curr_cost, u = heappop(heap)
    
    if curr_cost > costs[u]:
        continue
    if u == E:
        break

    for v, w in graph[u]:
        next_cost = curr_cost + w

        if next_cost < costs[v]:
            costs[v] = next_cost
            heappush(heap, (next_cost, v))

print(costs[E])