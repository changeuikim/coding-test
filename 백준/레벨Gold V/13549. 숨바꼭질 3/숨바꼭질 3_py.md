# [Gold V] [숨바꼭질 3](https://www.acmicpc.net/problem/13549) - 13549 

NaN0-1 너비 우선 탐색, 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## PyPy3 문제풀이

```PyPy3
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
```

### 성능 요약

시간: 144 ms

메모리: 112900 KB

### 제출 일자

2024년 12월 11일 (수) 23:15

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

