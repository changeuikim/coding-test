# [Platinum V] [Strongly Connected Component](https://www.acmicpc.net/problem/2150) - 2150 

NaN그래프 이론, 강한 연결 요소

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));
let lineIndex = 0;

const kosaraju = () => {
  // 정방향, 역방향 인접리스트 초기화
  const [V, E] = lines[lineIndex++];
  const fGraph = Array.from({ length: V + 1 }, () => [] as number[]);
  const rGraph = Array.from({ length: V + 1 }, () => [] as number[]);

  for (let i = 0; i < E; i++) {
    const [u, v] = lines[lineIndex++];
    fGraph[u].push(v);
    rGraph[v].push(u);
  }

  // 모든 정점에 대해 정방향 DFS
  let visited = Array(V + 1).fill(false);
  const orderStack: number[] = [];

  const fDFS = (u: number) => {
    visited[u] = true;
    for (const v of fGraph[u]) {
      if (!visited[v]) fDFS(v);
    }
    // 정점방문 순서를 추가
    orderStack.push(u);
  };

  for (let u = 1; u <= V; u++) {
    if (!visited[u]) fDFS(u);
  }

  // 방문 정점에 대해 역방향 DFS
  visited = Array(V + 1).fill(false);
  const sccList: number[][] = [];

  const rDFS = (v: number, curSCC: number[]) => {
    visited[v] = true;
    // 현재 SCC를 구성
    curSCC.push(v);
    for (const u of rGraph[v]) {
      if (!visited[u]) rDFS(u, curSCC);
    }
  };

  while (orderStack.length > 0) {
    const v = orderStack.pop();
    if (!visited[v]) {
      let curSCC: number[] = [];
      rDFS(v, curSCC);
      sccList.push(curSCC);
    }
  }

  // 첫줄에 SCC의 개수 K를 출력
  // 다음 K개의 줄에는 각 줄에 하나의 SCC에 속한 정점의 번호를 출력
  const result = [
    sccList.length.toString(),
    ...sccList
      .map((scc) => scc.sort((x, y) => x - y))
      .sort((a, b) => a[0] - b[0])
      .map((scc) => [...scc, -1].join(' ')),
  ].join('\n');

  console.log(result);
};

kosaraju();

```

### 성능 요약

시간: 348 ms

메모리: 45780 KB

### 제출 일자

2024년 12월 25일 (수) 21:55

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

