# [Lv.0] [문자열 붙여서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181946?language=javascript) - 181946 

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
    input = line.replace(' ', '');
}).on('close', function () {
    console.log(input)
});
```

### 성능 요약

1. 시간: 46.63 ms, 메모리: 32.2 MB

2. 시간: 45.20 ms, 메모리: 32.2 MB
3. 시간: 44.65 ms, 메모리: 32.2 MB
4. 시간: 44.17 ms, 메모리: 32.2 MB

### 제출 일자

2024년 10월 14일 (월) 23:07

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges