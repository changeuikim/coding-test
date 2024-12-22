# [Gold V] [회의실 배정](https://www.acmicpc.net/problem/1931) - 1931 

NaN그리디 알고리즘, 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const read = fs.readFileSync(0, 'utf-8');
const lines = read.split('\n').map((line: string) => line.split(' ').map(Number));

const greedy = () => {
  const [N] = lines[0];
  const meetings = lines.slice(1, N + 1);

  // 종료가 빠른 순으로 정렬
  const sorted = meetings.sort(([aS, aE], [bS, bE]) => (aE == bE ? aS - bS : aE - bE));

  let [E, cnt] = [-1, 0];
  for (const [ns, ne] of sorted) {
    // 현재 종료 <= 다음 시작
    if (E <= ns) {
      E = ne;
      cnt++;
    }
  }

  console.log(cnt);
};

greedy();
```

### 성능 요약

시간: 340 ms

메모리: 42352 KB

### 제출 일자

2024년 12월 22일 (일) 17:59

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

