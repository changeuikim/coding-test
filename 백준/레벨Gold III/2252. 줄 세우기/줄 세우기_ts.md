# [Gold III] [줄 세우기](https://www.acmicpc.net/problem/2252) - 2252 

NaN방향 비순환 그래프, 그래프 이론, 위상 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

// 인접리스트, 진입차수 초기화
const [N, M] = lines[0].split(' ').map(Number);
const graph = Array.from({ length: N + 1 }, () => []);
const ind: number[] = Array(N + 1).fill(0);

for (let i = 1; i <= M; i++) {
  const [u, v] = lines[i].split(' ').map(Number);
  graph[u].push(v);
  ind[v]++;
}

// 큐 초기화
const q: number[] = [];
const result: number[] = [];

for (let i = 1; i <= N; i++) {
  if (ind[i] === 0) q.push(i);
}

// 위상정렬
while (q.length > 0) {
  const u = q.shift();

  result.push(u);

  for (const v of graph[u]) {
    ind[v]--;
    if (ind[v] == 0) q.push(v);
  }
}

console.log(result.join(' '));
```

### 성능 요약

시간: 304 ms

메모리: 40752 KB

### 제출 일자

2024년 12월 12일 (목) 13:58

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

