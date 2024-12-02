# [Bronze V] [X보다 작은 수](https://www.acmicpc.net/problem/10871) - 10871 

NaN구현

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input: string = fs.readFileSync('/dev/stdin').toString().trim();

// 입력 처리
const lines: string[] = input.split('\n');
const [N, X]: number[] = lines[0].split(' ').map(Number);
const A: number[] = lines[1].split(' ').map(Number);

// 결과 처리
const result: number[] = A.filter(a => a < X);

// 출력 처리
console.log(result.join(' '));
```

### 성능 요약

시간: 100 ms

메모리: 11060 KB

### 제출 일자

2024년 12월 02일 (월) 22:06

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

