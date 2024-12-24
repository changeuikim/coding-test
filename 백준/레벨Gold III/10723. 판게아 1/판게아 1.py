from sys import stdin
from bisect import insort

input = stdin.readline

# 전역변수
N = None
parent = None

def find(x):
    if parent[x] < 0: return x
    parent[x] = find(parent[x])
    return parent[x]

def union(a, b):
    a, b = find(a), find(b)
    if a == b:
        return False

    if parent[a] > parent[b]:
        a, b = b, a

    parent[a] += parent[b]
    parent[b] = a
    return True

def kruskal(edges):
    global parent

    # 부모 + 랭크 노드
    parent = [-1] * (N + 1)

    # 최소 신장 트리
    mst_cost = 0
    edge_count = 0
    
    for w, u, v in edges:
        if edge_count >= N - 1: break
        if union(u, v):
            mst_cost += w
            edge_count += 1

    return mst_cost

def solution():
    global N

    # 1. 테스트 T회
    T = int(input().rstrip())
    for _ in range(T):
        N, M = map(int, input().split())

        # 2. 태초의 세계, 엣지 리스트
        edges = []
        for i in range(1, N):
            u, c = map(int, input().split())
            insort(edges, (c, i, u)) # w, u, v

        # 3. 조물주가 새로이 놓은 도로
        result = 0
        for j in range(1, M + 1):
            u, v, c = map(int, input().split())
            insort(edges, (c, u, v)) # w, u, v

            # 5. XOR 연산
            result ^= kruskal(edges) # 4. 크루스칼
            
        print(result)

solution()