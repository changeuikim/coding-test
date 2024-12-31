from sys import stdin

input = stdin.readline

# 비용은 두 행성 간의 최소 축 차이: min(|xA - xB|, |yA - yB|, |zA - zB|)
# 모든 행성 간의 간선을 계산하면 nC2 = O(N^2), 이는 N = 1e5일 때 약 50억 개로 시간 초과 발생
# 최적화 방법:
#   - x, y, z 축별로 좌표를 기준으로 행성을 정렬한 뒤,
#   - 인접한 두 행성 사이의 간선만 고려 -> 축별로 N-1개의 간선
#   - 총 간선 개수: 3(N-1), 시간 복잡도: O(N log N), 이는 N = 1e5일때 약 170만으로 안전범위

def kruskal():
    # 행성의 개수 N (1 ≤ N ≤ 100,000)
    N = int(input().rstrip())

    # 행성정보 0-based
    planets = []
    for i in range(N):
        x, y, z = map(int, input().split())
        planets.append((i, x, y, z))

    # 간선 리스트 초기화
    graph = []

    for i in range(1, 4):
        # x, y, z축 기준 정렬 간선
        planets.sort(key=lambda x: x[i])
        
        for j in range(N - 1):
            u = planets[j][0]
            v = planets[j + 1][0]
            w = abs(planets[j + 1][i] - planets[j][i])
            graph.append((u, v, w))

    # 부모노드 0 ~ N-1 초기화
    parent = list(range(N))

    # 파인드
    def find(x):
        while parent[x] != x:
            parent[x] = parent[parent[x]]
            x = parent[x]
        return x
    
    # 유니온
    def union(a, b):
        a, b = find(a), find(b)
        if a == b: return False

        if a > b: parent[a] = b
        else: parent[b] = a
        return True

    # 크루스칼
    mst_cost = 0
    edge_cnt = 0

    graph.sort(key=lambda x: x[2]) # w 기준 정렬

    for u, v, w in graph:
        if edge_cnt >= N - 1: break
        if union(u, v):
            mst_cost += w
            edge_cnt += 1

    print(mst_cost)

kruskal()