# [Bronze II] [숫자의 개수](https://www.acmicpc.net/problem/2577) - 2577 

NaN사칙연산, 구현, 수학

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');

const [A, B, C] = lines.map(Number);

const digits = Array(10).fill(0);
let number = A * B * C;

while (number) {
  digits[Math.floor(number % 10)]++;
  number = Math.floor(number / 10);
}

console.log(digits.join('\n'));
```

### 성능 요약

시간: 92 ms

메모리: 9332 KB

### 제출 일자

2024년 12월 05일 (목) 19:49

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

