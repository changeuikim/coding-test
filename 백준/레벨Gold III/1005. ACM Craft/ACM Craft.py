from sys import stdin

input = stdin.readline

N, K, W = 0, 0, 0
build_time = []
graph = []
in_degree = []

def topological_sort():
    stk = []
    dp = [0] * (N + 1)

    # 큐, DP 초기화
    for i in range(1, N + 1):
        if in_degree[i] == 0:
            stk.append(i)
            dp[i] = build_time[i]

    # 위상 정렬
    while stk:
        u = stk.pop()

        for v in graph[u]:
            in_degree[v] -= 1
            dp[v] = max(dp[v], dp[u] + build_time[v])
            
            if in_degree[v] == 0:
                stk.append(v)

    return dp

def test():    
    global N, K, build_time, graph, in_degree, W

    # 빌드타임 초기화
    N, K = map(int, input().split())
    build_time = [0] * (N + 1)

    for idx, time in enumerate(map(int, input().split()), start=1):
        build_time[idx] = time

    # 인접리스트, 진입차수 초기화
    graph = [[] for _ in range(N + 1)]
    in_degree = [0] * (N + 1)
    
    for _ in range(K):
        u, v = map(int, input().split())
        graph[u].append(v)
        in_degree[v] += 1

    # 승리조건
    W = int(input().rstrip())

    # 위상정렬
    dp = topological_sort()

    return dp[W]

def solution():    
    T = int(input().rstrip())
    
    for _ in range(T):
        print(test())

solution()