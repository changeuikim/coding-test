# [Gold III] [게임 개발](https://www.acmicpc.net/problem/1516) - 1516 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

// 인접리스트, 진입차수 초기화
const N = parseInt(lines[0]);
const graph: number[][] = Array.from({ length: N + 1 }, () => []);
const inDegree: number[] = Array(N + 1).fill(0);
const buildTime: number[] = Array(N + 1).fill(0);

for (let v = 1; v < N + 1; v++) {
  const buildInfo = lines[v].split(' ').map(Number);
  const [selfBuild, ...dependencies] = buildInfo;
  buildTime[v] = selfBuild;

  for (const u of dependencies) {
    if (u === -1) break;
    graph[u].push(v);
    inDegree[v]++;
  }
}

// 위상정렬
const q: number[] = [];
const result: number[] = Array(N + 1).fill(0);

for (let i = 1; i < N + 1; i++) {
  if (inDegree[i] === 0) {
    q.push(i);
    result[i] = buildTime[i];
  }
}

while (q.length > 0) {
  const u = q.pop();

  for (const v of graph[u]) {
    inDegree[v]--;
    result[v] = Math.max(result[v], result[u] + buildTime[v]);
    if (inDegree[v] === 0) q.push(v);
  }
}

console.log(result.slice(1).join('\n'));
```

### 성능 요약

시간: 176 ms

메모리: 12620 KB

### 제출 일자

2024년 12월 10일 (화) 22:17

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

