# [Lv.1] [행렬의 덧셈](https://school.programmers.co.kr/learn/courses/30/lessons/12950?language=javascript) - 12950 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(arr1, arr2) {    
    return arr1.map((row, i) => row.map((col, j) => col + arr2[i][j]));
}
```

### 성능 요약

1. 시간: 8.06 ms, 메모리: 67.5 MB

2. 시간: 0.85 ms, 메모리: 38.6 MB
3. 시간: 0.47 ms, 메모리: 37.8 MB
4. 시간: 0.40 ms, 메모리: 38.1 MB
5. 시간: 0.39 ms, 메모리: 38.1 MB

### 제출 일자

2024년 11월 03일 (일) 21:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges