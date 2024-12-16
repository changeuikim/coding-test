# [Gold V] [집합의 표현](https://www.acmicpc.net/problem/1717) - 1717 

NaN자료 구조, 분리 집합

## PyPy3 문제풀이

```PyPy3
from sys import stdin

input = stdin.readline

def disjoint_set():
    # 부모 노드 초기화
    N, M = map(int, input().split())
    parent = list(range(N + 1))

    def find(x):
        # 경로 압축
        while parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x
    
    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        
        if root_a > root_b:
            parent[root_a] = root_b
        else:
            parent[root_b] = root_a

    # 서로소 집합 연산
    for _ in range(M):
        op, a, b = map(int, input().split())
        
        if op == 0:
            union(a, b)
        elif find(a) == find(b):
            print("YES")
        else:
            print("NO")

disjoint_set()
```

### 성능 요약

시간: 216 ms

메모리: 120232 KB

### 제출 일자

2024년 12월 16일 (월) 23:55

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

