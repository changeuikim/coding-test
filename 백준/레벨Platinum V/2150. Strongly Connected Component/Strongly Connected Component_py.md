# [Platinum V] [Strongly Connected Component](https://www.acmicpc.net/problem/2150) - 2150 

NaN그래프 이론, 강한 연결 요소

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def kosaraju():
    # 정방향, 역방향 인접리스트 초기화
    V, E = map(int, input().split())
    f_graph = [[] for _ in range(V + 1)]
    r_graph = [[] for _ in range(V + 1)]

    for _ in range(E):
        u, v = map(int, input().split())
        f_graph[u].append(v)
        r_graph[v].append(u)

    # 모든 정점에 대해 정방향 DFS
    visited = [False] * (V + 1)
    f_dfs = [(i, False) for i in range(1, V + 1)]
    order_stack = []

    while f_dfs:
        u, state = f_dfs.pop()
        if state:
            order_stack.append(u)
            continue
        if visited[u]: continue
        
        visited[u] = True
        f_dfs.append((u, True))
        for v in f_graph[u]:
            if not visited[v]:
                f_dfs.append((v, False))

    # 방문 정점에 대해 역방향 DFS
    visited = [False] * (V + 1)
    scc_list = []
    r_dfs = []

    for i in range(V - 1, -1, -1):
        start = order_stack[i]
        if visited[start]: continue

        r_dfs = [start]
        cur_scc = []
        while r_dfs:
            v = r_dfs.pop()
            if visited[v]: continue

            visited[v] = True
            cur_scc.append(v)
            for u in r_graph[v]:
                if not visited[u]:
                    r_dfs.append(u)

        scc_list.append(sorted(cur_scc))
    
    # 첫줄에 SCC의 개수 K를 출력
    print(len(scc_list))
    # 다음 K개의 줄에는 각 줄에 하나의 SCC에 속한 정점의 번호를 출력
    scc_list.sort(key=lambda x: x[0])
    for scc in scc_list:
        print(*scc, -1)

kosaraju()
```

### 성능 요약

시간: 200 ms

메모리: 118332 KB

### 제출 일자

2024년 12월 25일 (수) 21:55

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

