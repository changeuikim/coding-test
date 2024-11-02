# [Lv.1] [없는 숫자 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/86051?language=javascript) - 86051 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌3

## JavaScript 문제풀이

```js
function solution(numbers) {
    const totalSum = (0 + 9) * 10 / 2;
    const numberSum = numbers.reduce((acc, cur) => acc + cur, 0);
    return totalSum - numberSum;
}
```

### 성능 요약

1. 시간: 0.04 ms, 메모리: 33.4 MB

2. 시간: 0.04 ms, 메모리: 33.4 MB
3. 시간: 0.04 ms, 메모리: 33.4 MB
4. 시간: 0.04 ms, 메모리: 33.4 MB
5. 시간: 0.04 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 02일 (토) 20:01

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges