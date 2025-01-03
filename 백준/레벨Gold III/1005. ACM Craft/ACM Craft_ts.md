# [Gold III] [ACM Craft](https://www.acmicpc.net/problem/1005) - 1005 

NaN방향 비순환 그래프, 다이나믹 프로그래밍, 그래프 이론, 위상 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');
let lineIndex = 0;
const input = (): string => lines[lineIndex++];

let N = 0;
let K = 0;
let W = 0;
let buildTime: number[] = [];
let graph: number[][] = [];
let inDegree: number[] = [];

const topological_sort = (): number[] => {
  const stk: number[] = [];
  const dp = Array(N + 1).fill(0);

  // 큐, DP 초기화
  for (let i = 1; i <= N; i++) {
    if (inDegree[i] === 0) {
      stk.push(i);
      dp[i] = buildTime[i];
    }
  }

  // 위상 정렬
  while (stk.length > 0) {
    const u = stk.pop()!;

    for (const v of graph[u]) {
      inDegree[v]--;
      dp[v] = Math.max(dp[v], dp[u] + buildTime[v]);

      if (inDegree[v] === 0) {
        stk.push(v);
      }
    }
  }

  return dp;
};

const test = (): number => {
  // 빌드타임 초기화
  [N, K] = input().split(' ').map(Number);
  buildTime = [0, ...input().split(' ').map(Number)];

  // 인접리스트, 진입차수 초기화
  graph = Array.from({ length: N + 1 }, () => []);
  inDegree = Array(N + 1).fill(0);

  for (let i = 0; i < K; i++) {
    const [u, v] = input().split(' ').map(Number);
    graph[u].push(v);
    inDegree[v]++;
  }

  // 승리 조건
  W = Number(input().trim());

  // 위상 정렬
  const dp = topological_sort();

  return dp[W];
};

const solution = (): void => {
  const T = Number(input().trim());
  const result: number[] = [];

  for (let t = 0; t < T; t++) {
    result.push(test());
  }

  console.log(result.join('\n'));
};

solution();
```

### 성능 요약

시간: 1008 ms

메모리: 108768 KB

### 제출 일자

2024년 12월 12일 (목) 23:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

