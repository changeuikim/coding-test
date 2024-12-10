# 스택
from sys import stdin

lines = stdin.read().splitlines()

# 인접리스트, 진입차수 초기화
N = int(lines[0])
graph = [[] for _ in range(N + 1)]
in_degree = [0] * (N + 1)
build_time = [0] * (N + 1)

for v in range(1, N + 1):
    build_info = map(int, lines[v].split())
    build_time[v] = next(build_info)
    for u in build_info:
        if u == -1:
            break
        graph[u].append(v)
        in_degree[v] += 1
    
# 위상정렬
q = []
result = [0] * (N + 1)

for i in range(1, N + 1):
    if in_degree[i] == 0:
        q.append(i)
        result[i] = build_time[i]

while q:
    u = q.pop()
    
    for v in graph[u]:
        in_degree[v] -= 1
        result[v] = max(result[v], result[u] + build_time[v])
        if in_degree[v] == 0:
            q.append(v)

print(*result[1:], sep="\n")