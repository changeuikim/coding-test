from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

# 인접리스트, 진입차수 초기화
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
in_degree = [0] * (N + 1)

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    in_degree[v] += 1

# 힙 초기화
heap = []
result = []

for i in range(1, N + 1):
    if in_degree[i] == 0:
        heappush(heap, i)

# 위상 정렬
while heap:
    u = heappop(heap)

    result.append(u)

    for v in graph[u]:
        in_degree[v] -= 1
        if in_degree[v] == 0:
            heappush(heap, v)

print(*result)