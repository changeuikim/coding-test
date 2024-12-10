# [Medium] [Course Schedule](https://leetcode.com/problems/course-schedule) - 207 

### 구분

알고리즘, 데이터구조

## Python3 문제풀이

```py
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
```

### 성능 요약

시간: 2 ms - 상위 NaN%

메모리: 18.6 MB - 상위 NaN%

### 제출 일자

2024년 12월 10일 (화) 23:26

> 출처: LeetCode, https://leetcode.com/problemset