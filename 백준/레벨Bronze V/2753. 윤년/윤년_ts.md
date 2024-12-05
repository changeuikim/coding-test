# [Bronze V] [윤년](https://www.acmicpc.net/problem/2753) - 2753 

NaN구현, 사칙연산, 수학

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const year: number = parseInt(input);

const result = (year % 4 === 0 && year % 100 != 0) || year % 400 === 0;

console.log(result ? 1 : 0);
```

### 성능 요약

시간: 104 ms

메모리: 9348 KB

### 제출 일자

2024년 12월 05일 (목) 13:08

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

