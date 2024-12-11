# [Medium] [Course Schedule II](https://leetcode.com/problems/course-schedule-ii) - 210 

### 구분

알고리즘, 데이터구조

## TypeScript 문제풀이

```ts
function findOrder(numCourses: number, prerequisites: number[][]): number[] {
  // 인접리스트, 진입차수 초기화
  const N = numCourses;
  const graph = Array.from({ length: N }, () => []);
  const inDegrees = Array(N).fill(0);

  for (const [v, u] of prerequisites) {
    graph[u].push(v);
    inDegrees[v]++;
  }

  // 큐 초기화
  const q: number[] = [];
  const result: number[] = [];

  for (let i = 0; i < N; i++) {
    if (inDegrees[i] == 0) q.push(i);
  }

  // 위상정렬
  while (q.length > 0) {
    const u = q.shift();
    result.push(u);

    for (const v of graph[u]) {
      inDegrees[v]--;
      if (inDegrees[v] == 0) q.push(v);
    }
  }

  // 사이클 확인
  if (result.length != N) return [];

  return result;
}
```

### 성능 요약

시간: 9 ms - 상위 NaN%

메모리: 56.8 MB - 상위 NaN%

### 제출 일자

2024년 12월 11일 (수) 11:05

> 출처: LeetCode, https://leetcode.com/problemset