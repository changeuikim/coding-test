# [Lv.0] [주사위 게임 2](https://school.programmers.co.kr/learn/courses/30/lessons/181930?language=javascript) - 181930 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function calc(a, b, c, n) {
    return Math.pow(a, n) + Math.pow(b, n) + Math.pow(c, n)
}

function solution(a, b, c) {
    const dice_set = new Set([a, b, c]);
    let result = 1;
    
    switch (dice_set.size) {
        case 1:
            result *= calc(a, b, c, 3)
        case 2:
            result *= calc(a, b, c, 2)
        case 3:
            result *= calc(a, b, c, 1)
    }
    
    return result;    
}

```

### 성능 요약

1. 시간: 0.09 ms, 메모리: 33.4 MB

2. 시간: 0.08 ms, 메모리: 33.4 MB
3. 시간: 0.06 ms, 메모리: 33.6 MB
4. 시간: 0.06 ms, 메모리: 33.6 MB
5. 시간: 0.06 ms, 메모리: 33.6 MB

### 제출 일자

2024년 10월 18일 (금) 10:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges