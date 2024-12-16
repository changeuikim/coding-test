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