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