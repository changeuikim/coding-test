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