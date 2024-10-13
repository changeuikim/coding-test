# [Lv.0] [특수문자 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181948?language=javascript) - 181948 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.on('close', function () {
    console.log(String.raw`!@#$%^&*(\'"<>?:;`);
});
```

### 성능 요약

1. 시간: 45.46 ms, 메모리: 32.2 MB



### 제출 일자

2024년 10월 14일 (월) 00:19

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges