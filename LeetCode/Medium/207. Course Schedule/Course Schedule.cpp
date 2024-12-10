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