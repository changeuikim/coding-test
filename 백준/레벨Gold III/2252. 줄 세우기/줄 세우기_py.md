# [Gold III] [줄 세우기](https://www.acmicpc.net/problem/2252) - 2252 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## PyPy3 문제풀이

```PyPy3
from sys import stdin
from collections import deque

input = stdin.readline

# 인접리스트, 진입차수 초기화
N, M = map(int, input().split())
graph = [[] for _ in range(N + 1)]
ind = [0] * (N + 1)

for _ in range(M):
    u, v = map(int, input().split())
    graph[u].append(v)
    ind[v] += 1

# 큐 초기화
q = deque([])
result = []

for i in range(1, N + 1):
    if ind[i] == 0:
        q.append(i)

# 위상정렬
while q:
    u = q.popleft()

    result.append(u)

    for v in graph[u]:
        ind[v] -= 1
        if ind[v] == 0:
            q.append(v)

print(*result)
```

### 성능 요약

시간: 172 ms

메모리: 118888 KB

### 제출 일자

2024년 12월 12일 (목) 13:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

