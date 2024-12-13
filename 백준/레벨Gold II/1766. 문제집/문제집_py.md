# [Gold II] [문제집](https://www.acmicpc.net/problem/1766) - 1766 

NaN방향 비순환 그래프, 자료 구조, 그래프 이론, 우선순위 큐, 위상 정렬

## PyPy3 문제풀이

```PyPy3
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
```

### 성능 요약

시간: 204 ms

메모리: 118024 KB

### 제출 일자

2024년 12월 13일 (금) 15:30

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

