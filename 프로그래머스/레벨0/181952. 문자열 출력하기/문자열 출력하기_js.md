# [Lv.0] [문자열 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181952?language=javascript) - 181952 

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
    input = [line];
}).on('close',function(){
    str = input[0];
    console.log(str);
});
```

### 성능 요약

1. 시간: 54.16 ms, 메모리: 32.3 MB

2. 시간: 50.15 ms, 메모리: 32.3 MB
3. 시간: 47.20 ms, 메모리: 32.3 MB

### 제출 일자

2024년 10월 13일 (일) 09:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges