from sys import stdin

input = stdin.readline

def tarjan():
    # 테스트 케이스 T회 (T <= 11)
    T = int(input().rstrip())
    for _ in range(T):
        # 정점 N 간선 M (1 ≤ N, M ≤ 100,000)
        N, M = map(int, input().split())

        # 1. 간선 리스트 초기화
        graph = [[] for _ in range(N)]
        for _ in range(M):
            u, v = map(int, input().split())
            graph[u].append(v)
        _ = input()

        # SCC 목록
        scc_map = dict()
        scc_id = [-1] * N
        scc_num = 0

        # SCC 후보
        scc_stk = []
        on_stk = [False] * N

        # 발견
        disc = [-1] * N
        disc_time = 0
        lowlink = [-1] * N

        # 2. 모든 정점에 대해 DFS
        dfs_stk = []
        for start in range(N):
            if disc[start] == -1:
                dfs_stk.append((start, 0))

                # Iterative Tarjan
                while dfs_stk:
                    u, i = dfs_stk[-1]

                    # u를 첫방문
                    if disc[u] == -1:
                        # lowlink 갱신 1
                        lowlink[u] = disc[u] = disc_time
                        disc_time += 1

                        # SCC 후보에 u 추가
                        scc_stk.append(u)
                        on_stk[u] = True

                    # 자식 v를 탐색 : for v in graph[u]
                    if i < len(graph[u]):
                        v = graph[u][i]
                        # 다음 v로 미리 이동
                        dfs_stk[-1] = (u, i + 1)

                        # v를 첫방문
                        if disc[v] == -1:
                            dfs_stk.append((v, 0))
                        # v가 SCC 후보
                        elif on_stk[v]:
                            # lowlink 갱신 2
                            lowlink[u] = min(lowlink[u], lowlink[v])
                    # 탐색할 v가 없으면
                    else:
                        # dfs(v)를 콜스택에서 팝
                        dfs_stk.pop()

                        # 부모 노드가 남아있다면
                        if dfs_stk:
                            parent = dfs_stk[-1][0]
                            # lowlink 갱신 3
                            lowlink[parent] = min(lowlink[parent], lowlink[u])

                        # u가 새로운 SCC의 루트라면
                        if lowlink[u] == disc[u]:
                            cur_scc = []

                            # 새로운 SCC 구성하기
                            while True:
                                top = scc_stk.pop()
                                on_stk[top] = False
                                cur_scc.append(top)
                                scc_id[top] = scc_num
                                if top == u: break

                            scc_map[scc_num] = cur_scc
                            scc_num += 1

        # 3. 진입차수 0인 SCC를 확인
        indegree = [0] * scc_num
        for u in range(N):
            for v in graph[u]:
                # 서로 다른 SCC를 연결하면 진입차수 증가
                if scc_id[v] != scc_id[u]:
                    indegree[scc_id[v]] += 1

        # 4. 출력 처리
        entry = [i for i in range(scc_num) if indegree[i] == 0]
        if len(entry) == 1:
            result = sorted(scc_map[entry[0]])
            print(*result, sep="\n")
        else:
            print("Confused")        
        print()

tarjan()