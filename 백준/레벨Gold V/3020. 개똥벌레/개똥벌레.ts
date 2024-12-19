// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

/*
  N = 2 * 10^5, H = 5 * 10^5, 최대 10^11
  일반적인 2차원 배열로는 O(N^2)를 못쓴다
 */

const difference = () => {
  const [N, H] = lines[0];
  const height = new Array(H).fill(0);

  // 너비 압축
  for (let i = 0; i < N; i++) {
    const t = lines[i + 1][0];

    // 짝수 : 석순, 홀수 : 종유석
    if (i & 1) {
      // 석순 : H-t 이전은 0 이후는 1
      height[H - t]++;
    } else {
      // 종유석 : t 이전은 1 이후는 0
      height[0]++;
      height[t]--;
    }
  }

  // 누적 합
  for (let i = 1; i < H; i++) {
    height[i] += height[i - 1];
  }

  // 최소값 및 빈도
  const minVal = Math.min(...height);
  const minCnt = height.filter((h) => h === minVal).length;

  console.log(minVal, minCnt);
};

difference();