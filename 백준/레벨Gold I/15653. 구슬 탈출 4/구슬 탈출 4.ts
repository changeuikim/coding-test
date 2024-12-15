// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
let index = 0;
const input = (): string => lines[index++];

type Pos = [number, number];
type State = [Pos, Pos, number];

class Queue<T> {
  private input: T[] = [];
  private output: T[] = [];

  push(item: T): void {
    this.input.push(item);
  }

  pop(): T | undefined {
    if (this.output.length === 0) {
      while (this.input.length > 0) {
        this.output.push(this.input.pop()!);
      }
    }
    return this.output.pop();
  }

  size(): number {
    return this.input.length + this.output.length;
  }

  isEmpty(): boolean {
    return this.size() === 0;
  }
}

const BFS = (): number => {
  // 보드, 빨강, 파랑 초기화
  const [N, M] = input().split(' ').map(Number);
  const board: string[][] = [];
  let red: Pos, blue: Pos;

  for (let i = 0; i < N; i++) {
    const row = input().split('');

    for (let j = 0; j < M; j++) {
      if (row[j] === 'R') {
        red = [i, j];
        row[j] = '.';
      } else if (row[j] === 'B') {
        blue = [i, j];
        row[j] = '.';
      }
    }

    board.push(row);
  }

  // 방향 : 좌우상하
  const dy = [0, 0, -1, 1];
  const dx = [-1, 1, 0, 0];

  // 큐, 방문 초기화
  const q = new Queue<State>();
  const visited = new Set<string>();

  q.push([red, blue, 1]);
  visited.add(JSON.stringify([red, blue]));

  // 굴리기
  const roll = (y: number, x: number, dy: number, dx: number): [number, number, number] => {
    let count = 0;
    // 벽에 부딪치기 전까지, 구멍에 빠질때까지
    while (board[y + dy][x + dx] !== '#' && board[y][x] !== 'O') {
      y += dy;
      x += dx;
      count += 1;
    }
    return [y, x, count];
  };

  // BFS
  while (!q.isEmpty()) {
    const [[ry, rx], [by, bx], move] = q.pop();

    // 좌우상하 굴리기
    for (let i = 0; i < 4; i++) {
      let [nry, nrx, rCount] = roll(ry, rx, dy[i], dx[i]);
      let [nby, nbx, bCount] = roll(by, bx, dy[i], dx[i]);

      // 빨간 구슬과 파란 구슬이 동시에 구멍에 빠져도 실패
      if (board[nby][nbx] == 'O') continue;

      // 빨간 구슬이 구멍에 빠지면 성공
      if (board[nry][nrx] == 'O') return move;

      // 빨간 구슬과 파란 구슬은 동시에 같은 칸에 있을 수 없다
      if (nry === nby && nrx === nbx) {
        // 빨간 구슬을 뒤로
        if (rCount > bCount) {
          nry -= dy[i];
          nrx -= dx[i];
        }
        // 파란 구슬을 뒤로
        else {
          nby -= dy[i];
          nbx -= dx[i];
        }
      }

      // 큐에 추가
      const nxtRed: Pos = [nry, nrx];
      const nxtBlue: Pos = [nby, nbx];
      const hashKey = JSON.stringify([nxtRed, nxtBlue]);

      if (visited.has(hashKey)) continue;

      q.push([nxtRed, nxtBlue, move + 1]);
      visited.add(hashKey);
    }
  }

  return -1;
};

console.log(BFS());