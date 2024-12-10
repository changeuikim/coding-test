# [Medium] [Course Schedule](https://leetcode.com/problems/course-schedule) - 207 

### 구분

알고리즘, 데이터구조

## TypeScript 문제풀이

```ts
function canFinish(numCourses: number, prerequisites: number[][]): boolean {
  const N = numCourses;
  const graph: number[][] = Array.from({ length: N }, () => []);
  const inDegree: number[] = Array(N).fill(0);

  prerequisites.forEach(([v, u]) => {
    graph[u].push(v);
    inDegree[v]++;
  });

  const q: number[] = [];
  let count = 0;

  for (let i = 0; i < N; i++) {
    if (inDegree[i] == 0) q.push(i);
  }

  while (q.length > 0) {
    const u = q.pop();
    count++;

    for (const v of graph[u]) {
      inDegree[v]--;
      if (inDegree[v] == 0) q.push(v);
    }
  }

  return count == N;
}
```

### 성능 요약

시간: 11 ms - 상위 NaN%

메모리: 56.1 MB - 상위 NaN%

### 제출 일자

2024년 12월 10일 (화) 23:27

> 출처: LeetCode, https://leetcode.com/problemset