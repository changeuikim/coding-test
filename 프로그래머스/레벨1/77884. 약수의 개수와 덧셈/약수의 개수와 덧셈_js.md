# [Lv.1] [약수의 개수와 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/77884?language=javascript) - 77884 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌2

## JavaScript 문제풀이

```js
function solution(left, right) {
    let result = 0;
    for (let num = left; num <= right; num++) {
        if (Number.isInteger(Math.sqrt(num))) {
            result -= num;
        } else {
            result += num;
        }
    }
    return result;
}
```

### 성능 요약

1. 시간: 0.17 ms, 메모리: 33.5 MB

2. 시간: 0.16 ms, 메모리: 33.4 MB
3. 시간: 0.15 ms, 메모리: 33.4 MB
4. 시간: 0.13 ms, 메모리: 33.4 MB
5. 시간: 0.11 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 02일 (토) 22:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges