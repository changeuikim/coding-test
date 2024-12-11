class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        # 인접리스트, 진입차수 초기화
        N = numCourses
        graph = [[] for _ in range(N)]
        ind = [0] * N

        for v, u in prerequisites:
            graph[u].append(v)
            ind[v] += 1

        # 큐 초기화
        q = deque([])
        result = []

        for i in range(N):
            if ind[i] == 0:
                q.append(i)

        # 위상정렬
        while q:
            u = q.popleft()
            result.append(u)

            for v in graph[u]:
                ind[v] -= 1
                if ind[v] == 0:
                    q.append(v)

        if len(result) != N:
            result = []

        return result