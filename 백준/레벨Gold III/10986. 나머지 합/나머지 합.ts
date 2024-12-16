// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const rangeSum = () => {
  // 누적 합 초기화
  const [N, M] = lines[0];
  const nums = lines[1];

  const pre = new Array(N + 1).fill(0);
  for (let i = 0; i < N; i++) {
    pre[i + 1] = (pre[i] + nums[i]) % M;
  }

  // 나머지 배열 초기화
  const r = new Array(M).fill(0);
  for (let i = 1; i <= N; i++) {
    r[pre[i]] += 1;
  }

  // 조합
  let count = r[0]; // 누적합도 구간합
  for (let i = 0; i < M; i++) {
    count += Math.floor((r[i] * (r[i] - 1)) / 2); // nC2 = n * (n-1) / 2
  }

  console.log(count);
};

rangeSum();