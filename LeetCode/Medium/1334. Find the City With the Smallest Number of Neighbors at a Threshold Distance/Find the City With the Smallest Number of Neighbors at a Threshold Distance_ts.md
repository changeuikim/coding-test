# [Medium] [Find the City With the Smallest Number of Neighbors at a Threshold Distance](https://leetcode.com/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance) - 1334 

### 구분

알고리즘, 데이터구조

## TypeScript 문제풀이

```ts
function findTheCity(n: number, edges: number[][], distanceThreshold: number): number {
  const INF = 10001;
  const dist: number[][] = Array.from({ length: n }, () => Array(n).fill(INF));

  for (const [u, v, w] of edges) {
    if (w > distanceThreshold) continue;

    dist[u][v] = w;
    dist[v][u] = w;
  }

  // 플로이드-워셜 알고리즘
  for (let k = 0; k < n; k++) {
    for (let i = 0; i < n; i++) {
      for (let j = 0; j < n; j++) {
        if (dist[i][j] > dist[i][k] + dist[k][j]) {
          dist[i][j] = dist[i][k] + dist[k][j];
        }
      }
    }
  }

  // 최소 연결 도시 찾기
  let minCity = 0;
  let minCount = n;

  for (let i = 0; i < n; i++) {
    let curCount = 0;
    for (let j = 0; j < n; j++) {
      if (i !== j && dist[i][j] <= distanceThreshold) {
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
```

### 성능 요약

시간: 22 ms - 상위 NaN%

메모리: 53.3 MB - 상위 NaN%

### 제출 일자

2024년 12월 19일 (목) 23:39

> 출처: LeetCode, https://leetcode.com/problemset