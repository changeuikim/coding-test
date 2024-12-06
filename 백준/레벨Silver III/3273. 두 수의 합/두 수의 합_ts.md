# [Silver III] [두 수의 합](https://www.acmicpc.net/problem/3273) - 3273 

NaN정렬, 두 포인터

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
const n = parseInt(lines[0]);
const arr = lines[1].split(' ').map(Number);
const x = parseInt(lines[2]);

arr.sort((a: number, b: number) => a - b);

let cnt = 0,
  i = 0,
  j = n - 1;
while (i < j) {
  const curr = arr[i] + arr[j];
  if (curr < x) i++;
  else if (curr > x) j--;
  else {
    cnt++;
    i++;
    j--;
  }
}

console.log(cnt);
```

### 성능 요약

시간: 192 ms

메모리: 18668 KB

### 제출 일자

2024년 12월 06일 (금) 23:40

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

