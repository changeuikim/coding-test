# [Lv.0] [코드 처리하기](https://school.programmers.co.kr/learn/courses/30/lessons/181932?language=javascript) - 181932 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(code) {
    let mode = 0;
    let ret = "";
    
    for (let idx = 0; idx < code.length; idx++) {
        if (code[idx] === "1") {
            mode ^= 1
        } else {
            if ((idx&1) === mode) {
                ret += code[idx];
            }
        }        
    }
    return ret.length > 0 ? ret : "EMPTY"
}

```

### 성능 요약

1. 시간: 10.40 ms, 메모리: 39.1 MB

2. 시간: 8.96 ms, 메모리: 39.2 MB
3. 시간: 7.61 ms, 메모리: 39.3 MB
4. 시간: 7.58 ms, 메모리: 39.3 MB
5. 시간: 4.36 ms, 메모리: 37.3 MB

### 제출 일자

2024년 10월 18일 (금) 08:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges