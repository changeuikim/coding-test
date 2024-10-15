# [Lv.0] [홀짝 구분하기](https://school.programmers.co.kr/learn/courses/30/lessons/181944?language=javascript) - 181944 

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
    [n] = line.split(' ').map(Number);
}).on('close', function () {
    const result = n&1 ? "odd" : "even";
    console.log(`${n} is ${result}`);
});
```

### 성능 요약

1. 시간: 54.55 ms, 메모리: 32.4 MB

2. 시간: 43.30 ms, 메모리: 32.2 MB
3. 시간: 43.15 ms, 메모리: 32.3 MB
4. 시간: 42.96 ms, 메모리: 32.2 MB

### 제출 일자

2024년 10월 15일 (화) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges