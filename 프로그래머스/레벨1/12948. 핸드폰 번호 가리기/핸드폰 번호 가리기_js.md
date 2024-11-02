# [Lv.1] [핸드폰 번호 가리기](https://school.programmers.co.kr/learn/courses/30/lessons/12948?language=javascript) - 12948 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(phone_number) {    
    return phone_number.replace(/\d(?=\d{4})/g, "*");
}
```

### 성능 요약

1. 시간: 0.12 ms, 메모리: 33.4 MB

2. 시간: 0.11 ms, 메모리: 33.5 MB
3. 시간: 0.11 ms, 메모리: 33.4 MB
4. 시간: 0.10 ms, 메모리: 33.5 MB
5. 시간: 0.10 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 02일 (토) 21:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges