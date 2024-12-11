from collections import deque

N, K = map(int, input().split())

# 거리배열 초기화
MAX = 100001
dist = [-1] * MAX
dist[N] = 0

# 0-1 BFS
dq = deque([])
dq.append(N)
result = -1

while dq:
    u = dq.popleft()

    if u == K:
        result = dist[K]
        break
    
    for v, w in [(u * 2, 0), (u - 1, 1), (u + 1, 1)]:
        if 0 <= v < MAX and dist[v] == -1:
            dist[v] = dist[u] + w

            if w == 0:
                dq.appendleft(v)
            else:
                dq.append(v)

print(result)