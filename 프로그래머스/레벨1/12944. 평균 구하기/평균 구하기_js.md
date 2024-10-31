# [Lv.1] [평균 구하기](https://school.programmers.co.kr/learn/courses/30/lessons/12944?language=javascript) - 12944 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(arr) {
    const sum = arr.reduce((acc, cur) => acc + cur, 0);
    return sum / arr.length;
}
```

### 성능 요약

1. 시간: 0.07 ms, 메모리: 33.6 MB

2. 시간: 0.07 ms, 메모리: 33.6 MB
3. 시간: 0.07 ms, 메모리: 33.5 MB
4. 시간: 0.07 ms, 메모리: 33.5 MB
5. 시간: 0.07 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 31일 (목) 20:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges