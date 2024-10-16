# [Lv.0] [문자열 겹쳐쓰기](https://school.programmers.co.kr/learn/courses/30/lessons/181943?language=javascript) - 181943 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(my_string, overwrite_string, s) {    
    return my_string.slice(0, s) + overwrite_string + my_string.slice(s + overwrite_string.length);
}
```

### 성능 요약

1. 시간: 0.05 ms, 메모리: 33.6 MB

2. 시간: 0.05 ms, 메모리: 33.5 MB
3. 시간: 0.05 ms, 메모리: 33.5 MB
4. 시간: 0.04 ms, 메모리: 33.6 MB
5. 시간: 0.04 ms, 메모리: 33.6 MB

### 제출 일자

2024년 10월 16일 (수) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges