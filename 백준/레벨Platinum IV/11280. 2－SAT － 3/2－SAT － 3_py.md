# [Platinum IV] [2-SAT - 3](https://www.acmicpc.net/problem/11280) - 11280 

NaN2-sat, 그래프 이론, 강한 연결 요소

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def iterative_tarjan():
    N, M = map(int, input().split())

    # 1. 음수,양수 인접리스트 초기화
    graph = [[] for _ in range(N * 2 + 1)]

    for _ in range(M):
        u, v = map(int, input().split())

        # u Or V는 ~u -> v 또는 ~v -> u이다
        nu1, nv1 = u * -1, v
        if nu1 < 0: nu1 = N - nu1
        if nv1 < 0: nv1 = N - nv1
        graph[nu1].append(nv1)

        nu2, nv2 = v * -1, u
        if nu2 < 0: nu2 = N - nu2
        if nv2 < 0: nv2 = N - nv2
        graph[nu2].append(nv2)

    # SCC 후보
    scc_stk = []
    on_stk = [False] * (N * 2 + 1)
    # 발견 순서, 발견 시간
    disc = [-1] * (N * 2 + 1)
    timestamp = 0
    # SCC id, SCC 번호
    scc_id = [-1] * (N * 2 + 1)
    scc_cnt = 0
    # 정점의 도달 가능한 최소 방문 순서
    lowlink = [-1] * (N * 2 + 1)

    # 2. 모든 정점에 대해 DFS
    dfs_stk = []
    for start in range(1, N * 2 + 1):
        if disc[start] == -1:
            dfs_stk.append((start, 0))

            while dfs_stk:
                u, i = dfs_stk[-1]

                # u 첫 방문
                if disc[u] == -1:
                    # lowlink 갱신 1
                    disc[u] = lowlink[u] = timestamp
                    timestamp += 1
                    # SCC 후보에 u 추가
                    scc_stk.append(u)
                    on_stk[u] = True

                # 자식 v를 탐색: for v in graph[u]
                if i < len(graph[u]):
                    v = graph[u][i]
                    dfs_stk[-1] = (u, i + 1)

                    # v 첫방문
                    if disc[v] == -1:
                        dfs_stk.append((v, 0))
                    # v가 SCC 후보라면
                    elif on_stk[v]:
                        # lowlink 갱신 2
                        lowlink[u] = min(lowlink[u], disc[v])
                # 탐색할 v가 없으면
                else:
                    # dfs(v)를 콜스택에서 제거
                    dfs_stk.pop()
                    # 부모가 있다면
                    if dfs_stk:
                        parent = dfs_stk[-1][0]
                        # lowlink 갱신 3 : u의 자식들의 최소값을 u의 부모에 전파
                        lowlink[parent] = min(lowlink[parent], lowlink[u])

                    # u가 이번 SCC의 루트 : 역방향 간선이 없고, 자식 중에서도 가장 빠르다
                    if lowlink[u] == disc[u]:
                        # 새 SCC를 구성
                        while True:
                            top = scc_stk.pop()
                            on_stk[top] = False
                            # 정점의 SCC 번호 기록
                            scc_id[top] = scc_cnt
                            if top == u: break
                        scc_cnt += 1

    # 3. 정점 u와 정점 -u의 scc_cnt를 대조
    for u in range(1, N + 1):
        if scc_id[u] == scc_id[u + N]:
            print(0)
            return
    print(1)

iterative_tarjan()
```

### 성능 요약

시간: 236 ms

메모리: 117524 KB

### 제출 일자

2024년 12월 27일 (금) 11:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

