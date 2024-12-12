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