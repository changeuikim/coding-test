# [Lv.1] [시저 암호](https://school.programmers.co.kr/learn/courses/30/lessons/12926?language=javascript) - 12926 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(s, n) {
    let result = [];
    
    s.split('').forEach((c) => {
        if (c === ' ') {
            result.push(c);
        }
        else if (c === c.toUpperCase()) {
            result.push(String.fromCharCode((c.charCodeAt(0) - 'A'.charCodeAt(0) + n) % 26 + 'A'.charCodeAt(0)));
        } else {
            result.push(String.fromCharCode((c.charCodeAt(0) - 'a'.charCodeAt(0) + n) % 26 + 'a'.charCodeAt(0)));
        }
    });
    
    return result.join('');
}
```

### 성능 요약

1. 시간: 2.37 ms, 메모리: 37.4 MB

2. 시간: 0.27 ms, 메모리: 33.5 MB
3. 시간: 0.19 ms, 메모리: 33.6 MB
4. 시간: 0.19 ms, 메모리: 33.4 MB
5. 시간: 0.17 ms, 메모리: 33.6 MB

### 제출 일자

2024년 11월 06일 (수) 19:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges