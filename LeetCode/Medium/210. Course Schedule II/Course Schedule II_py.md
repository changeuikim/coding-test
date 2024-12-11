# [Medium] [Course Schedule II](https://leetcode.com/problems/course-schedule-ii) - 210 

### 구분

알고리즘, 데이터구조

## Python3 문제풀이

```py
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
```

### 성능 요약

시간: 3 ms - 상위 NaN%

메모리: 18.6 MB - 상위 NaN%

### 제출 일자

2024년 12월 11일 (수) 11:04

> 출처: LeetCode, https://leetcode.com/problemset