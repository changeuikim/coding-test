# [Silver III] [구간 합 구하기 4](https://www.acmicpc.net/problem/11659) - 11659 

NaN누적 합

## TypeScript 문제풀이

```TypeScript
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
```

### 성능 요약

시간: 348 ms

메모리: 53512 KB

### 제출 일자

2024년 12월 16일 (월) 08:39

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

