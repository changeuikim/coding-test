# [Lv.1] [나누어 떨어지는 숫자 배열](https://school.programmers.co.kr/learn/courses/30/lessons/12910?language=javascript) - 12910 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(arr, divisor) {
    const result = arr.filter(e => e % divisor === 0).sort((a, b) => a - b);
    return result.length ? result : [-1];
}
```

### 성능 요약

1. 시간: 1.87 ms, 메모리: 37 MB

2. 시간: 0.26 ms, 메모리: 33.7 MB
3. 시간: 0.16 ms, 메모리: 33.6 MB
4. 시간: 0.16 ms, 메모리: 33.6 MB
5. 시간: 0.16 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 01일 (금) 22:27

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges