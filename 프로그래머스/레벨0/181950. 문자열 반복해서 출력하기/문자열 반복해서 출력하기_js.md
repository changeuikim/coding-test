# [Lv.0] [문자열 반복해서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181950?language=javascript) - 181950 

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
    str = input[0];
    n = Number(input[1]);
    console.log(str.repeat(n));
});
```

### 성능 요약

1. 시간: 177.45 ms, 메모리: 32.2 MB

2. 시간: 175.70 ms, 메모리: 32.4 MB
3. 시간: 43.33 ms, 메모리: 32.3 MB

### 제출 일자

2024년 10월 13일 (일) 11:01

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges