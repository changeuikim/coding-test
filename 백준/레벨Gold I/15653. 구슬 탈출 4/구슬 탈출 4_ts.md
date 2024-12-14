# [Gold I] [구슬 탈출 4](https://www.acmicpc.net/problem/15653) - 15653 

NaN너비 우선 탐색, 그래프 이론, 그래프 탐색, 구현, 시뮬레이션

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

// 입력 처리
const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let idx = 0;
const input = (): string => lines[idx++];

type Pos = [number, number];

interface State {
  red: Pos;
  blue: Pos;
  moves: number;
}

const initBoard = (): { red: Pos; blue: Pos; board: string[][] } => {
  const [N, M] = input().split(' ').map(Number);
  const board: string[][] = [];
  let red: Pos;
  let blue: Pos;

  for (let i = 0; i < N; i++) {
    const line = input().split('');

    for (let j = 0; j < M; j++) {
      if (line[j] === 'R') {
        red = [i, j];
        line[j] = '.';
      } else if (line[j] === 'B') {
        blue = [i, j];
        line[j] = '.';
      }
    }

    board.push(line);
  }

  return { red, blue, board };
};

const move = (
  y: number,
  x: number,
  dy: number,
  dx: number,
  board: string[][]
): [number, number, number] => {
  let count = 0;
  while (board[y + dy][x + dx] !== '#' && board[y][x] !== 'O') {
    y += dy;
    x += dx;
    count++;
  }
  return [y, x, count];
};

const solution = (): number => {
  // 미로 초기화
  const { red, blue, board } = initBoard();

  // 방향 초기화 : 좌우상하
  const dirs = [
    [0, 1],
    [0, -1],
    [-1, 0],
    [1, 0],
  ];

  // 큐 초기화
  let f_stk: State[] = [];
  let r_stk: State[] = [];
  const visited: Set<string> = new Set();

  f_stk.push({ red, blue, moves: 1 });
  visited.add(JSON.stringify({ red, blue }));

  // BFS
  while (f_stk.length > 0 || r_stk.length > 0) {
    const {
      red: [ry, rx],
      blue: [by, bx],
      moves,
    } = f_stk.pop();

    for (const [dy, dx] of dirs) {
      let [nBy, nBx, bCnt] = move(by, bx, dy, dx, board);
      let [nRy, nRx, rCnt] = move(ry, rx, dy, dx, board);

      // 파란구슬 실패
      if (board[nBy][nBx] === 'O') continue;

      // 빨간구슬 성공
      if (board[nRy][nRx] === 'O') return moves;

      // 위치가 겹치면 더 많이 움직인걸 뒤로
      if (nRy === nBy && nRx === nBx) {
        if (rCnt > bCnt) {
          nRy -= dy;
          nRx -= dx;
        } else {
          nBy -= dy;
          nBx -= dx;
        }
      }

      // 큐에 추가
      const stateStr = JSON.stringify({ red: [nRy, nRx], blue: [nBy, nBx] });
      if (!visited.has(stateStr)) {
        r_stk.push({ red: [nRy, nRx], blue: [nBy, nBx], moves: moves + 1 });
        visited.add(stateStr);
      }
    }

    // 스택 교환
    if (f_stk.length === 0) {
      f_stk = r_stk;
      r_stk = [];
    }
  }

  return -1;
};

console.log(solution());
```

### 성능 요약

시간: 112 ms

메모리: 10112 KB

### 제출 일자

2024년 12월 15일 (일) 00:25

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

