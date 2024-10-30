# [Lv.1] [자릿수 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/12931?language=javascript) - 12931 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(n) {
    return [...String(n)].reduce((acc, char) => acc + +char, 0);
}
```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 33.4 MB

2. 시간: 0.06 ms, 메모리: 33.4 MB
3. 시간: 0.06 ms, 메모리: 33.4 MB
4. 시간: 0.06 ms, 메모리: 33 MB
5. 시간: 0.05 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 30일 (수) 21:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges