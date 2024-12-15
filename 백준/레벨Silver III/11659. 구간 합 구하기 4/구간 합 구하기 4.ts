// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const rangeSum = () => {
  // 누적 합 초기화
  let [N, M] = lines[0];
  const prefixSum = Array(N + 1).fill(0);

  for (let i = 0; i < N; i++) {
    prefixSum[i + 1] = prefixSum[i] + lines[1][i];
  }

  // 구간 합 출력
  const result = [];
  for (let i = 0; i < M; i++) {
    const [s, e] = lines[i + 2];
    result.push(prefixSum[e] - prefixSum[s - 1]);
  }
  console.log(result.join('\n'));
};

rangeSum();