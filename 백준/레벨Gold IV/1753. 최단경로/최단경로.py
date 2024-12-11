from sys import stdin
from heapq import heappush, heappop

input = stdin.readline

# 인접리스트 초기화
V, E = map(int, input().split())
S = int(input().rstrip())
graph = [[] for _ in range(V + 1)]

for _ in range(E):
    u, v, w = map(int, input().split())
    graph[u].append((v, w))

# 거리배열 초기화
INF = float('inf')
distances = [INF] * (V + 1)
distances[S] = 0

# 다익스트라
heap = []
heappush(heap, (0, S))

while heap:
    curr_dist, u = heappop(heap)

    if (curr_dist > distances[u]):
        continue
    
    for v, w in graph[u]:
        next_dist = curr_dist + w

        if next_dist < distances[v]:
            distances[v] = next_dist
            heappush(heap, (next_dist, v))

# 출력 처리
for i in range(1, len(distances)):
    if distances[i] == INF:
        print("INF")
    else:
        print(distances[i])