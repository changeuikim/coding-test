# [Bronze IV] [알파벳 개수](https://www.acmicpc.net/problem/10808) - 10808 

NaN구현, 문자열

## TypeScript 문제풀이

```TypeScript
import fs = require('fs');

const input = fs.readFileSync(0, 'utf-8').trim();
const wordToAscii = input.split('').map((it: string) => it.charCodeAt(0));
const alphabet = Array(26).fill(0);

for (const ascii of wordToAscii) alphabet[ascii - 'a'.charCodeAt(0)]++;

console.log(alphabet.join(' '));
```

### 성능 요약

시간: 108 ms

메모리: 9344 KB

### 제출 일자

2024년 12월 05일 (목) 16:16

> 출처: 백준 온라인 저지, https://www.acmicpc.net/problemset 

