# [Bronze V] [시험 성적](https://www.acmicpc.net/problem/9498) - 9498 

NaN구현

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const score = parseInt(input);

let result: string;
if (score >= 90 && score <= 100) result = 'A';
else if (score >= 80) result = 'B';
else if (score >= 70) result = 'C';
else if (score >= 60) result = 'D';
else result = 'F';

console.log(result);
```

### 성능 요약

시간: 96 ms

메모리: 9336 KB

### 제출 일자

2024년 12월 05일 (목) 11:09

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

