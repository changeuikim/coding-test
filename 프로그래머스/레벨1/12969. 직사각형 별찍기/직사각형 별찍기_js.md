# [Lv.1] [직사각형 별찍기](https://school.programmers.co.kr/learn/courses/30/lessons/12969?language=javascript) - 12969 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
process.stdin.setEncoding('utf8');
process.stdin.on('data', data => {
    const n = data.split(" ");
    const a = Number(n[0]), b = Number(n[1]);
    console.log(("*".repeat(a) + "\n").repeat(b));
});
```

### 성능 요약

1. 시간: 60.05 ms, 메모리: 32 MB

2. 시간: 59.64 ms, 메모리: 32 MB
3. 시간: 58.14 ms, 메모리: 32.2 MB
4. 시간: 57.61 ms, 메모리: 32.1 MB
5. 시간: 55.15 ms, 메모리: 32.2 MB

### 제출 일자

2024년 11월 04일 (월) 18:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges