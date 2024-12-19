class Solution:
    def findTheCity(self, n: int, edges: List[List[int]], distanceThreshold: int) -> int:
        INF = 10001
        dist = [[INF] * n for _ in range(n)]

        for u, v, w in edges:
            if w > distanceThreshold:
                continue

            dist[u][v] = w
            dist[v][u] = w

        # 플로이드 워셜 알고리즘
        for k in range(n):
            for i in range(n):
                for j in range(n):
                    if dist[i][j] > dist[i][k] + dist[k][j]:
                        dist[i][j] = dist[i][k] + dist[k][j]
        
        # 최소 연결 도시 찾기
        min_city = 0
        min_cnt = n
        
        for i in range(n):
            cur_cnt = 0
            for j in range(n):
                if i != j and dist[i][j] <= distanceThreshold:
                    cur_cnt += 1
            
            if cur_cnt <= min_cnt:
                min_cnt = cur_cnt
                min_city = i
                
        return min_city    