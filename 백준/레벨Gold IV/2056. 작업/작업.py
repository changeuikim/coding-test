from sys import stdin
from collections import deque

input = stdin.readline

def topological_sort():
    # # 작업시간, 인접리스트, 진입차수 초기화
    # N = int(input().rstrip())
    # work_time = [0] * (N+1)
    # graph = [[] for _ in range(N+1)]
    # in_degree = [0] * (N+1)

    # for v in range(1, N + 1):
    #     line = list(map(int, input().split()))
    #     work_time[v] = line[0]
        
    #     for i in range(2, len(line)):
    #         u = line[i]
    #         graph[u].append(v)
    #         in_degree[v] += 1

    # # 큐 초기화
    # q = deque()
    # dp = [0] * (N + 1)

    # for i in range(1, N + 1):
    #     if in_degree[i] == 0:
    #         q.append(i)
    #         dp[i] = work_time[i]

    # # 위상 정렬
    # while q:
    #     u = q.popleft()

    #     for v in graph[u]:
    #         in_degree[v] -= 1
    #         dp[v] = max(dp[v], dp[u] + work_time[v])
    #         if in_degree[v] == 0:
    #             q.append(v)

    # print(max(dp))

    # 선행은 모두 1 이상 (K-1) 이하 : 1부터 N까지 이미 위상 정렬 됨
    N = int(input().rstrip())
    dp = [0] * (N + 1)

    for v in range(1, N + 1):
        time, size, *pre = map(int, input().split())
        # 작업시간 설정
        dp[v] = time
        # 선행시간 반영
        for u in pre:
            dp[v] = max(dp[v], dp[u] + time)

    # 가장 늦게 끝나는 작업을 반환
    print(max(dp))

topological_sort()