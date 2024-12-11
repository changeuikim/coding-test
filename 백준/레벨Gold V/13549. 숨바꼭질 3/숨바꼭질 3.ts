import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

const [N, K] = lines[0].split(' ').map(Number);

// 거리배열 초기화
const MAX = 100001;
const dist = Array(MAX).fill(-1);
dist[N] = 0;

// 0-1 BFS
const dq = [];
dq.push(N);
let result = -1;

while (dq.length > 0) {
  const u = dq.shift();

  if (u === K) {
    result = dist[u];
    break;
  }

  for (const [v, w] of [
    [u * 2, 0],
    [u - 1, 1],
    [u + 1, 1],
  ]) {
    if (v >= 0 && v < MAX && dist[v] === -1) {
      dist[v] = dist[u] + w;

      if (w === 0) dq.unshift(v);
      else dq.push(v);
    }
  }
}

console.log(result);