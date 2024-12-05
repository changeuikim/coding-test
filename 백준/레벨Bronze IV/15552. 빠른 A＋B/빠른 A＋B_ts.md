# [Bronze IV] [빠른 A+B](https://www.acmicpc.net/problem/15552) - 15552 

NaN구현, 사칙연산, 수학

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim().split('\n');
const T = parseInt(input[0]);

const result = new Array(T).fill(-1);
for (let i = 1; i <= T; i++) {
  const [a, b] = input[i].split(' ').map(Number);
  result[i - 1] = a + b;
}

console.log(result.join('\n'));
```

### 성능 요약

시간: 1032 ms

메모리: 159156 KB

### 제출 일자

2024년 12월 05일 (목) 16:53

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

