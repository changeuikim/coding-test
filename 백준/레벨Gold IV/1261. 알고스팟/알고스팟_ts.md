# [Gold IV] [알고스팟](https://www.acmicpc.net/problem/1261) - 1261 

NaN0-1 너비 우선 탐색, 데이크스트라, 그래프 이론, 그래프 탐색, 최단 경로

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

// 입력 처리
const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let idx = 0;
const input = (): string => lines[idx++];

// 미로 초기화
const [M, N] = input().split(' ').map(Number);
const board: string[] = [];

for (let i = 0; i < N; i++) {
  board.push(input());
}

// 방향 설정
const dy = [0, 0, 1, -1];
const dx = [1, -1, 0, 0];

// 거리배열 초기화
const dist: number[][] = Array(N)
  .fill(null)
  .map(() => Array(M).fill(-1));
dist[0][0] = 0;

// 유사 덱 초기화
let f_stk: [number, number][] = [];
let r_stk: [number, number][] = [];
f_stk.push([0, 0]);

// 0-1 BFS
while (f_stk.length > 0 || r_stk.length > 0) {
  const [y, x] = f_stk.pop()!;

  for (let i = 0; i < 4; i++) {
    const [ny, nx] = [y + dy[i], x + dx[i]];

    if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
      if (dist[ny][nx] == -1) {
        if (board[ny][nx] === '0') {
          f_stk.push([ny, nx]);
          dist[ny][nx] = dist[y][x];
        } else if (board[ny][nx] === '1') {
          r_stk.push([ny, nx]);
          dist[ny][nx] = dist[y][x] + 1;
        }
      }
    }
  }

  // 레벨 전환환
  if (f_stk.length <= 0) {
    f_stk = r_stk;
    r_stk = [];
  }
}

console.log(dist[N - 1][M - 1]);
```

### 성능 요약

시간: 172 ms

메모리: 12324 KB

### 제출 일자

2024년 12월 13일 (금) 15:27

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

