class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        N = numCourses
        graph = [[] for _ in range(N)]
        in_degree = [0] * N

        for v, u in prerequisites:
            graph[u].append(v)
            in_degree[v] += 1

        q = deque([])
        count = 0

        for i in range(N):
            if in_degree[i] == 0:
                q.append(i)

        while q:
            u = q.popleft()
            count += 1

            for v in graph[u]:
                in_degree[v] -= 1
                if in_degree[v] == 0:
                    q.append(v)
        
        return count == N