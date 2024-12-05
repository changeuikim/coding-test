# [Bronze IV] [세수정렬](https://www.acmicpc.net/problem/2752) - 2752 

NaN구현, 정렬

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input: string = fs.readFileSync(0, 'utf-8').trim();
const numbers: number[] = input.split(' ').map(Number);

console.log(numbers.sort((a, b) => a - b).join(' '));
```

### 성능 요약

시간: 96 ms

메모리: 9588 KB

### 제출 일자

2024년 12월 05일 (목) 11:32

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

