# [Lv.0] [문자열 돌리기](https://school.programmers.co.kr/learn/courses/30/lessons/181945?language=javascript) - 181945 

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
    input = line
}).on('close',function(){
    console.log(input.split("").join("\n"))
});
```

### 성능 요약

1. 시간: 53.63 ms, 메모리: 32.3 MB

2. 시간: 46.36 ms, 메모리: 32.2 MB
3. 시간: 45.12 ms, 메모리: 32.3 MB

### 제출 일자

2024년 10월 15일 (화) 23:24

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges