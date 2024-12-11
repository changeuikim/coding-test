# [Gold V] [숨바꼭질 3](https://www.acmicpc.net/problem/13549) - 13549 

NaN0-1 너비 우선 탐색, 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## TypeScript 문제풀이

```TypeScript
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
```

### 성능 요약

시간: 232 ms

메모리: 14860 KB

### 제출 일자

2024년 12월 11일 (수) 23:27

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

