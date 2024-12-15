# [Gold III] [음악프로그램](https://www.acmicpc.net/problem/2623) - 2623 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## PyPy3 문제풀이

```PyPy3
from sys import stdin
from collections import deque

input = stdin.readline

def topological_sort():
    # 인접리스트, 진입차수 초기화
    N, M = map(int, input().split())
    graph = [[] for _ in range(N+1)]
    in_degree = [0] * (N+1)

    for _ in range(M):
        entry = list(map(int, input().split()))

        for i in range(1, len(entry) - 1):
            u, v = entry[i], entry[i+1]
            graph[u].append(v)
            in_degree[v] += 1

    # 큐 초기화
    q = deque()
    result = []
    
    for i in range(1, N+1):
        if in_degree[i] == 0:
            q.append(i)

    # 위상 정렬
    while q:
        u = q.popleft()

        result.append(str(u))

        for v in graph[u]:
            in_degree[v] -= 1
            if in_degree[v] == 0:
                q.append(v)

    # 사이클 확인
    if len(result) == N:
        print("\n".join(result))
    else:
        print(0)

topological_sort()
```

### 성능 요약

시간: 116 ms

메모리: 113500 KB

### 제출 일자

2024년 12월 15일 (일) 21:20

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

