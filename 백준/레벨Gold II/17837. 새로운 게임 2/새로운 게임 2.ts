// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const solution = () => {
  const [N, K] = lines[0];

  // 방향 : →, ←, ↑, ↓
  const dy = [0, 0, 0, -1, 1];
  const dx = [0, 1, -1, 0, 0];

  // 뒤집기
  const rMap: { [key: number]: number } = { 1: 2, 2: 1, 3: 4, 4: 3 };
  // 체스판 : 둘레 패딩, 1-based
  const board = Array.from({ length: N + 2 }, () => Array(N + 2).fill(2));
  // 스택판 : 체스판과 동기화, 스택 크기 4 => 게임 종료
  const boardStk: number[][][] = Array.from({ length: N + 2 }, () =>
    Array.from({ length: N + 2 }, () => [])
  );
  // 엔트리 : 1번마 ~ K번마
  const horseList: [number, number, number][] = [];

  // 체스판 초기화
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      board[i][j] = lines[i][j - 1];
    }
  }

  // 스택판, 엔트리 초기화
  for (let i = 0; i < K; i++) {
    const [y, x, d] = lines[N + 1 + i];

    boardStk[y][x].push(i);
    horseList.push([y, x, d]);
  }

  // 게임 1000턴
  for (let turn = 1; turn <= 1000; turn++) {
    // 1번마 ~ K번마 순회
    for (let hIdx = 0; hIdx < K; hIdx++) {
      let [y, x, d] = horseList[hIdx];

      // 이동방향 설정
      let [ny, nx] = [y + dy[d], x + dx[d]];

      // 파랑칸 : 이동방향 뒤집기
      if (board[ny][nx] === 2) {
        // 뒤집기
        d = rMap[d];
        horseList[hIdx][2] = d;
        // 이동방향 설정
        [ny, nx] = [y + dy[d], x + dx[d]];
        // 또 파란벽이면 이동불가
        if (board[ny][nx] === 2) continue;
      }

      // 이동 전처리 : 스택 분할
      const cur = boardStk[y][x]; // 현재말 스택
      const slicePtr = cur.indexOf(hIdx); // 현재말 위치
      const nxt = cur.slice(slicePtr); // 현재말 위쪽
      boardStk[y][x] = cur.slice(0, slicePtr); // 현재말 아래쪽

      // 빨강칸 : 스택 뒤집기
      if (board[ny][nx] === 1) nxt.reverse();

      // 이동 처리
      boardStk[ny][nx].push(...nxt);
      for (const idx of nxt) {
        horseList[idx][0] = ny;
        horseList[idx][1] = nx;
      }

      // 스택 크기 검증
      if (boardStk[ny][nx].length >= 4) {
        console.log(turn);
        return;
      }
    }
  }

  console.log(-1);
};

solution();