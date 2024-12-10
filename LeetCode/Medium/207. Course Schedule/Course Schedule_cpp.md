# [Medium] [Course Schedule](https://leetcode.com/problems/course-schedule) - 207 

### 구분

알고리즘, 데이터구조

## C++ 문제풀이

```cpp
class Solution {
public:
    bool canFinish(int numCourses, vector<vector<int>>& prerequisites) {
        int N = numCourses;
        vector<vector<int>> graph(N);
        vector<int> inDegree(N, 0);

        for (const auto& parts : prerequisites) {
          int v = parts[0];
          int u = parts[1];

          graph[u].push_back(v);
          inDegree[v]++;
        }

        queue<int> q;
        int count = 0;

        for (int i = 0; i < N; i++) {
          if (inDegree[i] == 0) q.push(i);
        }

        while (!q.empty()) {
          int u = q.front();
          q.pop();
          count++;

          for (auto v : graph[u]) {
            inDegree[v]--;
            if (inDegree[v] == 0) q.push(v);
          }
        }

        return count == N;
    }
};
```

### 성능 요약

시간: 0 ms - 상위 NaN%

메모리: 19.2 MB - 상위 NaN%

### 제출 일자

2024년 12월 10일 (화) 23:29

> 출처: LeetCode, https://leetcode.com/problemset