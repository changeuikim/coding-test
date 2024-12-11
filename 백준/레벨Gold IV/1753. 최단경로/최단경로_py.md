# [Gold IV] [최단경로](https://www.acmicpc.net/problem/1753) - 1753 

NaN데이크스트라, 그래프 이론, 최단 경로

## PyPy3 문제풀이

```PyPy3
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
```

### 성능 요약

시간: 420 ms

메모리: 135892 KB

### 제출 일자

2024년 12월 11일 (수) 22:20

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

