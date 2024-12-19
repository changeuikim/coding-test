# [Medium] [Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance) - 1334 

### 구분

알고리즘, 데이터구조

## Java 문제풀이

```java
class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        final int INF = 10001;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];

            if (w > distanceThreshold) continue;
            
            dist[u][v] = w;
            dist[v][u] = w;
        }

        // 플로이드-워셜 알고리즘
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // 최소 연결 도시 찾기
        int minCity = 0;
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
}
```

### 성능 요약

시간: 8 ms - 상위 NaN%

메모리: 45.1 MB - 상위 NaN%

### 제출 일자

2024년 12월 19일 (목) 23:40

> 출처: LeetCode, https://leetcode.com/problemset