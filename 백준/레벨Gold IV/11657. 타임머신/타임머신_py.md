# [Gold IV] [타임머신](https://www.acmicpc.net/problem/11657) - 11657 

NaN벨만–포드, 그래프 이론, 최단 경로

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def bellman_ford():
    N, M = map(int, input().split())

    # 간선리스트 초기화
    graph = [0] * M
    for i in range(M):
        u, v, w = map(int, input().split())
        graph[i] = u, v, w

    # 거리배열 초기화
    INF = 500 * 10000 + 1
    dist = [INF] * (N + 1)
    dist[1] = 0    

    # (노드-1)회 반복
    for _ in range(N - 1):
        for u, v, w in graph:
            if dist[u] == INF:
                continue
            nxt = dist[u] + w
            if dist[v] > nxt:
                dist[v] = nxt

    # 음의 사이클 검사
    is_cycle = False
    for u, v, w in graph:
        if dist[u] == INF:
            continue
        if dist[v] > dist[u] + w:
            is_cycle = True
            break

    # 출력 처리
    result = []
    if is_cycle:
        result.append("-1")
    else:
        result.extend(
            str(-1 if dist[i] == INF else dist[i])
            for i in range(2, N + 1)
        )
    print("\n".join(result))

bellman_ford()
```

### 성능 요약

시간: 156 ms

메모리: 111408 KB

### 제출 일자

2024년 12월 19일 (목) 22:00

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

