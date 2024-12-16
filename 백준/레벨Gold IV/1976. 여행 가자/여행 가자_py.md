# [Gold IV] [여행 가자](https://www.acmicpc.net/problem/1976) - 1976 

NaN자료 구조, 분리 집합, 그래프 이론, 그래프 탐색

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def disjoint_set():
    # 부모 노드 초기화
    N = int(input().rstrip())
    M = int(input().rstrip())
    parent = list(range(N+1))

    def find(x):
        nodes = []
        while parent[x] != x:
            nodes.append(x)            
            x = parent[x]
        # 한번에 경로 압축
        for node in nodes:
            parent[node] = x
        return x

    def union(a, b):
        root_a, root_b = find(a), find(b)
        if root_a == root_b:
            return

        if root_a > root_b:
            parent[root_a] = root_b
        else:
            parent[root_b] = root_a
    
    # 분리 집합
    for i in range(N):
        line = list(map(int, input().split()))

        for j in range(N):
            if line[j] == 1:
                union(i+1, j+1)

    # 경로 검증
    cities = list(map(int, input().split()))
    root = find(cities[0])
    isPossible = all(find(city) == root for city in cities)
    print("YES" if isPossible else "NO")

disjoint_set()
```

### 성능 요약

시간: 104 ms

메모리: 110736 KB

### 제출 일자

2024년 12월 17일 (화) 01:08

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

