// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const solution = () => {
  // 누적 합 초기화
  const [N, M] = lines[0];

  const pre = Array.from({ length: N + 1 }, () => Array(N + 1).fill(0));
  for (let i = 1; i <= N; i++) {
    for (let j = 1; j <= N; j++) {
      pre[i][j] = pre[i - 1][j] + pre[i][j - 1] - pre[i - 1][j - 1] + lines[i][j - 1];
    }
  }

  // 구간 합 처리
  const result: number[] = [];
  for (let i = 0; i < M; i++) {
    const [x1, y1, x2, y2] = lines[i + N + 1];

    const t = pre[x2][y2] - pre[x1 - 1][y2] - pre[x2][y1 - 1] + pre[x1 - 1][y1 - 1];
    result.push(t);
  }

  console.log(result.join('\n'));
};

solution();