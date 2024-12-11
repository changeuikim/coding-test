# [Gold V] [최소비용 구하기](https://www.acmicpc.net/problem/1916) - 1916 

NaN데이크스트라, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

// 인접리스트 초기화
const N = parseInt(lines[0]);
const M = parseInt(lines[1]);
const graph: [number, number][][] = Array.from({ length: N + 1 }, () => []);

for (let i = 2; i <= M + 1; i++) {
  const [u, v, w] = lines[i].split(' ').map(Number);
  graph[u].push([v, w]);
}

const [S, E] = lines[M + 2].split(' ').map(Number);

// 다익스트라
const costs: number[] = Array(N + 1).fill(Infinity);
costs[S] = 0;

const heap: [number, number][] = [];
heap.push([0, S]);

while (heap.length > 0) {
  heap.sort((a, b) => b[0] - a[0]);
  const [currCost, u] = heap.pop();

  if (currCost > costs[u]) continue;
  if (u === E) break;

  for (const [v, w] of graph[u]) {
    const nextCost = currCost + w;

    if (nextCost < costs[v]) {
      costs[v] = nextCost;
      heap.push([nextCost, v]);
    }
  }
}

console.log(costs[E]);
```

### 성능 요약

시간: 388 ms

메모리: 51604 KB

### 제출 일자

2024년 12월 11일 (수) 20:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

