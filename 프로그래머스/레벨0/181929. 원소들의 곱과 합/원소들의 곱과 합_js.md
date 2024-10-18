# [Lv.0] [원소들의 곱과 합](https://school.programmers.co.kr/learn/courses/30/lessons/181929?language=javascript) - 181929 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(num_list) {
    const product = num_list.reduce((acc, val) => acc * val, 1);
    const sumSquare = Math.pow(num_list.reduce((acc, val) => acc + val, 0), 2);
    
    return product < sumSquare ? 1 : 0;
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 33.6 MB

2. 시간: 0.05 ms, 메모리: 33.5 MB
3. 시간: 0.05 ms, 메모리: 33.5 MB
4. 시간: 0.05 ms, 메모리: 33.5 MB
5. 시간: 0.05 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 18일 (금) 10:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges