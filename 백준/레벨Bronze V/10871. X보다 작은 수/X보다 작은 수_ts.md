# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const lines: string[] = input.split('\n');

const [N, X]: number[] = lines[0].split(' ').map(Number);
const A: number[] = lines[1].split(' ').map(Number);

const result: number[] = A.filter((a) => a < X);
console.log(result.join(' '));
```

### 성능 요약

시간: 100 ms

메모리: 11052 KB

### 제출 일자

2024년 12월 05일 (목) 10:14

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

