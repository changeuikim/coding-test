# [Platinum IV] [도미노](https://www.acmicpc.net/problem/4196) - 4196 

NaN방향 비순환 그래프, 그래프 이론, 강한 연결 요소, 위상 정렬

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def iterative_tarjan():
    # 테스트케이스 T회
    T = int(input().rstrip())
    for _ in range(T):
        # SSC그룹핑 -> DAG생성 -> 진입차수 확인
        V, E = map(int, input().split())

        # 1. 인접리스트 초기화
        graph = [[] for _ in range(V + 1)]
        for _ in range(E):
            u, v = map(int, input().split())
            graph[u].append(v)

        # SSC 후보 스택, 정점의 스택 포함 여부
        scc_stack = []
        in_stack = [False] * (V + 1)
        # DFS 방문순서, 카운터
        visited = [-1] * (V + 1)
        visited_count = 0
        # SSC id, 현재
        scc_id = [-1] * (V + 1)
        cur_scc = 0
        # low : u에서 역방향으로 거슬러 갈 수 있는 가장 작은 방문순서
        low = [-1] * (V + 1)

        # 2. 모든 정점에 대해 DFS
        dfs_stack = []
        for start in range(1, V + 1):
            if visited[start] == -1:
                dfs_stack.append((start, 0))

                while dfs_stack:
                    u, i = dfs_stack[-1]

                    # 첫 방문
                    if visited[u] == -1:
                        # low 갱신 1
                        visited[u] = low[u] = visited_count
                        visited_count += 1
                        # 스택에 u 추가
                        scc_stack.append(u)
                        in_stack[u] = True

                    # 인접 정점을 탐색
                    if i < len(graph[u]):
                        v = graph[u][i]
                        dfs_stack[-1] = (u, i + 1)

                        # 첫 방문
                        if visited[v] == -1:
                            dfs_stack.append((v, 0))
                        # SCC 후보
                        elif in_stack[v]:
                            # low 갱신 2
                            low[u] = min(low[u], visited[v])
                    # 탐색을 완료하면
                    else:
                        # dfs(v)
                        dfs_stack.pop()
                        if dfs_stack:
                            parent = dfs_stack[-1][0]
                            # low 갱신 3
                            low[parent] = min(low[parent], low[u])

                        # u가 SCC 루트 정점
                        if low[u] == visited[u]:
                            # u의 SCC 구성하기
                            while True:
                                top = scc_stack.pop()
                                in_stack[top] = False
                                scc_id[top] = cur_scc # SCC 넘버링
                                if top == u: break                                
                            cur_scc += 1

        # 3. SCC 단위로 DAG 생성
        indegree = [0] * cur_scc
        for u in range(1, V + 1):
            for v in graph[u]:
                # 서로 다른 SCC를 연결하면 진입차수 증가
                if scc_id[u] != scc_id[v]:
                    indegree[scc_id[v]] += 1

        # 4. 진입차수 0인 SCC의 개수
        print(sum(1 for x in indegree if x == 0))

iterative_tarjan()
```

### 성능 요약

시간: 368 ms

메모리: 160140 KB

### 제출 일자

2024년 12월 26일 (목) 10:36

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

