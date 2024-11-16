# [Lv.2] [모음 사전](https://school.programmers.co.kr/learn/courses/30/lessons/84512?language=javascript) - 84512 

### 구분

코딩테스트 연습 > 완전탐색

## JavaScript 문제풀이

```js
function solution(word) {
    const dic = "AEIOU";
    let acc = word.length;

    for (let i = 0, b = 1; i < word.length; i++, b *= 5) {
        acc += dic.indexOf(word[i]) * Math.floor(781 / b);
    }

    return acc;
}

```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 33.2 MB

2. 시간: 0.06 ms, 메모리: 33.4 MB
3. 시간: 0.05 ms, 메모리: 33.4 MB
4. 시간: 0.05 ms, 메모리: 33.3 MB
5. 시간: 0.05 ms, 메모리: 33 MB

### 제출 일자

2024년 11월 16일 (토) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges