# [Lv.2] [[3차] n진수 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17687?language=javascript) - 17687 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(n, t, m, p) {
    let res = '';
    let num = 0;
    let seq = '';

    while (res.length < t) {
        if (seq.length >= m) {
            res += seq[p - 1];
            seq = seq.slice(m);
        } else {
            seq += num.toString(n).toUpperCase();
            num++;
        }
    }

    return res;
}

```

### 성능 요약

1. 시간: 7.71 ms, 메모리: 38.2 MB

2. 시간: 7.59 ms, 메모리: 38 MB
3. 시간: 7.12 ms, 메모리: 38 MB
4. 시간: 5.09 ms, 메모리: 37.5 MB
5. 시간: 1.94 ms, 메모리: 34.2 MB

### 제출 일자

2024년 11월 11일 (월) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges