# [Lv.0] [a와 b 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181951?language=javascript) - 181951 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];

rl.on('line', function (line) {
    input = line.split(' ');
}).on('close', function () {
    const [a, b] = input;
    console.log(`a = ${a}\nb = ${b}`);
});
```

### 성능 요약

1. 시간: 68.95 ms, 메모리: 32.3 MB

2. 시간: 57.31 ms, 메모리: 32.2 MB
3. 시간: 46.34 ms, 메모리: 32.2 MB
4. 시간: 44.29 ms, 메모리: 32.2 MB
5. 시간: 44.19 ms, 메모리: 32.2 MB

### 제출 일자

2024년 10월 13일 (일) 10:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges