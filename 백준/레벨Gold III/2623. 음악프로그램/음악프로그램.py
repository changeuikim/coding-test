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