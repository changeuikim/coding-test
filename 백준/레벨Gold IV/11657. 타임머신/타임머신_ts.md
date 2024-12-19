# [Gold IV] [타임머신](https://www.acmicpc.net/problem/11657) - 11657 

NaN벨만–포드, 그래프 이론, 최단 경로

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const bellmanFord = () => {
  const [N, M] = lines[0];

  // 간선리스트 : line[1] ~ line[M]

  // 거리배열 초기화
  const INF = 500 * 10000 + 1;
  const dist = Array(N + 1).fill(INF);
  dist[1] = 0;

  // (노드-1)회 반복
  for (let i = 0; i < N - 1; i++) {
    for (let j = 1; j <= M; j++) {
      const [u, v, w] = lines[j];

      if (dist[u] == INF) continue;

      const nxt = dist[u] + w;
      if (dist[v] > nxt) dist[v] = nxt;
    }
  }

  // 음의 사이클 검사
  let isCycle = false;
  for (let j = 1; j <= M; j++) {
    const [u, v, w] = lines[j];

    if (dist[u] == INF) continue;

    if (dist[v] > dist[u] + w) {
      isCycle = true;
      break;
    }
  }

  // 출력 처리
  const result: string[] = [];
  if (isCycle) {
    result.push('-1');
  } else {
    for (let i = 2; i <= N; i++) {
      result.push(dist[i] === INF ? '-1' : dist[i].toString());
    }
  }
  console.log(result.join('\n'));
};

bellmanFord();
```

### 성능 요약

시간: 188 ms

메모리: 12632 KB

### 제출 일자

2024년 12월 19일 (목) 22:01

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

