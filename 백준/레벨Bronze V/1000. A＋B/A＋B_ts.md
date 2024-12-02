# [Bronze V] [A+B](https://www.acmicpc.net/problem/1000) - 1000 

NaN구현, 사칙연산, 수학

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input: string = fs.readFileSync('/dev/stdin').toString().trim();
const [A, B]: number[] = input.split(' ').map(Number);

console.log(A + B);
```

### 성능 요약

시간: 96 ms

메모리: 9340 KB

### 제출 일자

2024년 12월 02일 (월) 22:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

