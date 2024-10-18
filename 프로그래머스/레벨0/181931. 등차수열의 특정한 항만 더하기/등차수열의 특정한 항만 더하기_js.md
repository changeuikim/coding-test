# [Lv.0] [등차수열의 특정한 항만 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/181931?language=javascript) - 181931 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(a, d, included) {
    return included.reduce((acc, flag, i) =>{
        return flag ? acc + a + i*d : acc;
    }, 0);

}

```

### 성능 요약

1. 시간: 0.06 ms, 메모리: 33.6 MB

2. 시간: 0.06 ms, 메모리: 33.6 MB
3. 시간: 0.06 ms, 메모리: 33.5 MB
4. 시간: 0.05 ms, 메모리: 33.6 MB
5. 시간: 0.05 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 18일 (금) 09:13

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges