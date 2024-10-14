# [Lv.0] [덧셈식 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181947?language=javascript) - 181947 

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
    const [a, b] = line.split(' ').map(Number);
    console.log(`${a} + ${b} = ${a + b}`);
    rl.close();
});
```

### 성능 요약

1. 시간: 85.52 ms, 메모리: 32.2 MB

2. 시간: 65.63 ms, 메모리: 32.2 MB
3. 시간: 47.79 ms, 메모리: 32.3 MB

### 제출 일자

2024년 10월 14일 (월) 22:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges