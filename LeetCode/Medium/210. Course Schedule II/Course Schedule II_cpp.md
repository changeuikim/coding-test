# [Medium] [Course Schedule II](https://leetcode.com/problems/course-schedule-ii) - 210 

### 구분

알고리즘, 데이터구조

## C++ 문제풀이

```cpp
class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        // 인접리스트, 진입차수 초기화
        int N = numCourses;
        vector<vector<int>> graph(N);
        vector<int> inDegrees(N, 0);

        for (const auto& parts : prerequisites) {
          int v = parts[0];
          int u = parts[1];

          graph[u].push_back(v);
          inDegrees[v]++;
        }

        // 큐 초기화
        queue<int> q;
        vector<int> result;

        for (size_t i = 0; i < N; i++) {
          if (inDegrees[i] == 0) {
            q.push(i);
          }
        }

        // 위상정렬
        while (!q.empty()) {
          int u = q.front();
          q.pop();
          result.push_back(u);

          for (auto v : graph[u]) {
            inDegrees[v]--;
            if (inDegrees[v] == 0) {
              q.push(v);
            }
          }
        }

        // 사이클 확인
        if (result.size() != N) {
          return {};
        }

        return result;
    }
};
```

### 성능 요약

시간: 0 ms - 상위 NaN%

메모리: 17.9 MB - 상위 NaN%

### 제출 일자

2024년 12월 11일 (수) 11:06

> 출처: LeetCode, https://leetcode.com/problemset