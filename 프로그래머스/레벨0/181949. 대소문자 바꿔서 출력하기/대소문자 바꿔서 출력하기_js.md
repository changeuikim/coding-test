# [Lv.0] [대소문자 바꿔서 출력하기](https://school.programmers.co.kr/learn/courses/30/lessons/181949?language=javascript) - 181949 

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

const swapcase = (str) => {
    return [...str]
        .map(char => {
        if (char == char.toUpperCase()) {
            return char.toLowerCase();
        } else {
            return char.toUpperCase();
        }
    })
    .join('');
}

rl.on('line', function (line) {
    input = [line];
}).on('close',function(){
    str = input[0];
    console.log(swapcase(str));
});
```

### 성능 요약

1. 시간: 58.04 ms, 메모리: 32.3 MB

2. 시간: 48.57 ms, 메모리: 32.3 MB
3. 시간: 47.99 ms, 메모리: 32.3 MB
4. 시간: 47.06 ms, 메모리: 32.2 MB

### 제출 일자

2024년 10월 13일 (일) 11:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges