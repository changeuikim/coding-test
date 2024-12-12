# [Gold V] [배](https://www.acmicpc.net/problem/1092) - 1092 

NaN그리디 알고리즘, 정렬

## TypeScript 문제풀이

```TypeScript
// @ts-ignore
import fs = require('fs');

const lines = fs.readFileSync('/dev/stdin').toString().split('\n');

// 입력 처리
const N: number = parseInt(lines[0].trim());
const cranes: number[] = lines[1].trim().split(' ').map(Number);
const M: number = parseInt(lines[2].trim());
const boxes: number[] = lines[3].trim().split(' ').map(Number);

// 내림차순 정렬
cranes.sort((a, b) => b - a);
boxes.sort((a, b) => b - a);

if (boxes[0] > cranes[0]) {
  console.log(-1);
} else {
  // 최소 시간 : 모든 박스 / 모든 크레인
  let maxTime: number = Math.ceil(M / N);
  let bIdx: number = 0;

  for (let cIdx = 1; cIdx < N; cIdx++) {
    // 현재 crane이 들 수 있는 가장 큰 box를 확인
    while (bIdx < M && cranes[cIdx] < boxes[bIdx]) {
      bIdx++;
    }

    // 현재 시간 : 박스 수 / 크레인 수
    const curTime: number = Math.ceil(bIdx / cIdx);
    maxTime = Math.max(maxTime, curTime);

    if (bIdx === M) break;
  }

  console.log(maxTime);
}
```

### 성능 요약

시간: 100 ms

메모리: 10080 KB

### 제출 일자

2024년 12월 12일 (목) 17:58

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

