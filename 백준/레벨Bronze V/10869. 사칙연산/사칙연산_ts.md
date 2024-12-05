# [Bronze V] [사칙연산](https://www.acmicpc.net/problem/10869) - 10869 

NaN구현, 사칙연산, 수학

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const [a, b]: number[] = input.split(' ').map(Number);

console.log(a + b);
console.log(a - b);
console.log(a * b);
console.log(Math.floor(a / b));
console.log(a % b);
```

### 성능 요약

시간: 96 ms

메모리: 9604 KB

### 제출 일자

2024년 12월 05일 (목) 10:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

