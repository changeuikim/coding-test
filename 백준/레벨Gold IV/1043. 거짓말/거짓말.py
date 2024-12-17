from sys import stdin

input = stdin.readline

def disjoint_set():
    # 부모노드 초기화
    N, M = map(int, input().split())
    parent = list(range(N+1))

    def find(x):
        nodes = []
        while parent[x] != x:
            nodes.append(x)
            x = parent[x]

        for node in nodes:
            parent[node] = x
        return x
    
    def union(a, b):
        root_a = find(a)
        root_b = find(b)
        
        if root_a > root_b:
            parent[root_a] = root_b
        else:
            parent[root_b] = root_a

    # 진실노드 초기화
    truth = list(map(int, input().split())) 
    if truth[0] == 0:
        print(M)
        return

    # 파티노드 초기화
    parties = []
    for _ in range(M):
        party = list(map(int, input().split()))[1:]
        parties.append(party)
        
        for i in range(len(party) - 1):
            union(party[i], party[i + 1])
    
    # 진실노드로 병합
    root = find(truth[1])
    for i in range(2, len(truth)):
        union(truth[i], root)

    # 파티 처리
    count = M
    for party in parties:
        if find(party[0]) == find(root):
            count -= 1
    
    print(count)

disjoint_set()