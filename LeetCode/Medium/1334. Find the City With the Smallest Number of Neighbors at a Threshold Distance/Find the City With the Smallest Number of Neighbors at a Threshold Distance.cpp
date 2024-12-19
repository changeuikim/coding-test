class Solution {
public:
    int findTheCity(int n, vector<vector<int>>& edges, int distanceThreshold) {
        const int INF = 10001;
        vector<vector<int>> dist(n, vector<int>(n, INF));

        for (const auto& edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            if (w > distanceThreshold) continue;

            dist[u][v] = w;
            dist[v][u] = w;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 연결 도시 찾기
        int minCity = -1;
        int minCount = n;

        for (int i = 0; i < n; i++) {
            int curCount = 0;
            for (int j = 0; j < n; j++) {
                if (i != j && dist[i][j] <= distanceThreshold) {
                    curCount++;
                }
            }

            if (curCount <= minCount) {
                minCount = curCount;
                minCity = i;
            }
        }

        return minCity;
    }
};