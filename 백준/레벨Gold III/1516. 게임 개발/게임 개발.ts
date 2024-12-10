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