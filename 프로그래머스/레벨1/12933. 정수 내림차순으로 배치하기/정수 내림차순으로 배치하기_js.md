# [Lv.1] [정수 내림차순으로 배치하기](https://school.programmers.co.kr/learn/courses/30/lessons/12933?language=javascript) - 12933 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(n) {
    return parseInt(n.toString()
                    .split('')
                    .sort((a, b) => b - a)
                    .join(''));
}
```

### 성능 요약

1. 시간: 0.10 ms, 메모리: 33.5 MB

2. 시간: 0.09 ms, 메모리: 33.4 MB
3. 시간: 0.09 ms, 메모리: 33.4 MB
4. 시간: 0.09 ms, 메모리: 33.4 MB
5. 시간: 0.09 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 01일 (금) 21:20

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges