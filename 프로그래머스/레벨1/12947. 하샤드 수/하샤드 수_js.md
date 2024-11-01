# [Lv.1] [하샤드 수](https://school.programmers.co.kr/learn/courses/30/lessons/12947?language=javascript) - 12947 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(x) {
    const sum = String(x).split('').reduce((acc, cur) => acc + parseInt(cur, 10), 0);
    return x % sum === 0;
}
```

### 성능 요약

1. 시간: 0.07 ms, 메모리: 33.6 MB

2. 시간: 0.07 ms, 메모리: 33.6 MB
3. 시간: 0.06 ms, 메모리: 33.6 MB
4. 시간: 0.05 ms, 메모리: 33.6 MB
5. 시간: 0.05 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 01일 (금) 22:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges