# [Gold I] [최종 순위](https://www.acmicpc.net/problem/3665) - 3665 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## PyPy3 문제풀이

```PyPy3
# 25.02.02
from sys import stdin
from collections import deque

input = stdin.readline

def solution():
    # 테스트 케이스 T회 (T <= 100)
    T = int(input().rstrip())
    for _ in range(T):        
        N = int(input().rstrip()) # 2 <= N <= 500
        rank = list(map(int, input().split())) # 작년 순위 (1 <= t <= N)

        # 인접행렬 초기화
        graph = [[False] * (N + 1) for _ in range(N + 1)]
        indegree = [0] * (N + 1)

        for i in range(N):
            for j in range(i + 1, N):
                graph[rank[i]][rank[j]] = True
                indegree[rank[j]] += 1

        # 등수 변경 (0 <= M <= 25000)
        M = int(input().rstrip())
        for _ in range(M):
            a, b = map(int, input().split())
            if graph[a][b]:
                graph[a][b] = False
                graph[b][a] = True
                indegree[b] -= 1
                indegree[a] += 1
            else:
                graph[b][a] = False
                graph[a][b] = True
                indegree[a] -= 1
                indegree[b] += 1

        # 큐 초기화
        q = deque()
        for i in range(1, N + 1):
            if indegree[i] == 0:
                q.append(i)

        impossible = False
        ambiguous = False

        # 위상 정렬
        result = []
        for i in range(N):
            # N회 돌기전에 큐가 빈다 -> 사이클
            if not q:
                impossible = True
                break
            # 큐 크기가 2 이상 -> 순서 보장 X
            if len(q) > 1:
                ambiguous = True
            
            u = q.popleft()
            result.append(u)
            
            for v in range(1, N + 1):
                if graph[u][v]:
                    indegree[v] -= 1
                    if indegree[v] == 0:
                        q.append(v)

        if impossible:
            print("IMPOSSIBLE")
        elif ambiguous:
            print("?")
        else:
            print(*result)

solution()
```

### 성능 요약

시간: 204 ms

메모리: 126544 KB

### 제출 일자

2025년 02월 03일 (월) 22:56

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

