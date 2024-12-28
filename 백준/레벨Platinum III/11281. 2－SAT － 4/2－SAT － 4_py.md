# [Platinum III] [2-SAT - 4](https://www.acmicpc.net/problem/11281) - 11281 

NaN2-sat, 그래프 이론, 강한 연결 요소

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def iterative_tarjan():
    N, M = map(int, input().split())

    # 음수 인덱싱
    def idx(x):
        return x if x > 0 else (N * 2 + 1) + x

    # 1. 음수,양수 인접리스트 초기화
    graph = [[] for _ in range(N * 2 + 1)]

    for _ in range(M):
        u, v = map(int, input().split())

        # u Or v = ~u -> v AND ~v -> u
        graph[idx(-u)].append(idx(v))
        graph[idx(-v)].append(idx(u))

    # SCC 후보
    scc_stk = []
    on_stk = [False] * (N * 2 + 1)
    # 발견 순서, 발견 시간
    disc = [-1] * (N * 2 + 1)
    time = 1
    # SCC id, SCC 번호
    scc_id = [-1] * (N * 2 + 1)
    scc_num = 1
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
                    disc[u] = lowlink[u] = time
                    time += 1
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
                            scc_id[top] = scc_num
                            if top == u: break
                        scc_num += 1

    # 3. 정점 u와 정점 -u의 scc_cnt를 대조
    result = [0] * N
    for u in range(1, N + 1):
        if scc_id[u] == scc_id[idx(-u)]:
            print(0)
            return
        if scc_id[u] < scc_id[idx(-u)]:
            result[u - 1] = 1

    print(1)
    print(*result)

iterative_tarjan()
```

### 성능 요약

시간: 240 ms

메모리: 118388 KB

### 제출 일자

2024년 12월 28일 (토) 09:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

