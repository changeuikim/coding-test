# [Lv.1] [제일 작은 수 제거하기](https://school.programmers.co.kr/learn/courses/30/lessons/12935?language=javascript) - 12935 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(arr) {
    const minNum = Math.min(...arr);
    const result = arr.filter(num => num > minNum);
    return result.length ? result : [-1];
}
```

### 성능 요약

1. 시간: 2.65 ms, 메모리: 43.8 MB

2. 시간: 0.12 ms, 메모리: 33.6 MB
3. 시간: 0.11 ms, 메모리: 33.6 MB
4. 시간: 0.09 ms, 메모리: 33.6 MB
5. 시간: 0.08 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 02일 (토) 20:32

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges