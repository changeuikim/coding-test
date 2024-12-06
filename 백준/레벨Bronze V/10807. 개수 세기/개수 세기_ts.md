# [Bronze V] [개수 세기](https://www.acmicpc.net/problem/10807) - 10807 

NaN구현

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const lines = fs.readFileSync(0, 'utf-8').trim().split('\n');
const n = parseInt(lines[0]);
const nums = lines[1].split(' ').map(Number);
const v = parseInt(lines[2]);

const count = nums.filter((num: number) => num === v).length;
console.log(count);
```

### 성능 요약

시간: 108 ms

메모리: 9352 KB

### 제출 일자

2024년 12월 06일 (금) 23:57

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

