# [Gold III] [나머지 합](https://www.acmicpc.net/problem/10986) - 10986 

NaN수학, 누적 합

## TypeScript 문제풀이

```TypeScript
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
```

### 성능 요약

시간: 540 ms

메모리: 134716 KB

### 제출 일자

2024년 12월 16일 (월) 10:13

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

