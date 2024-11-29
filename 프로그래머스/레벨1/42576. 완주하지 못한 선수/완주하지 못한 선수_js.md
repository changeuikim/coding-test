# [Lv.1] [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=javascript) - 42576 

### 구분

코딩테스트 연습 > 해시

## JavaScript 문제풀이

```js
function solution(participant, completion) {
    let hashMap = {};

    for (let p of participant) {
        if (hashMap[p]) {
            hashMap[p] += 1;
        } else {
            hashMap[p] = 1;
        }
    }

    for (let c of completion) {
        hashMap[c] -= 1;
    }

    for (let key in hashMap) {
        if (hashMap[key] === 1) {
            return key;
        }
    }
}
```

### 성능 요약

1. 시간: 82.08 ms, 메모리: 70.8 MB

2. 시간: 61.07 ms, 메모리: 71.1 MB
3. 시간: 54.36 ms, 메모리: 57 MB
4. 시간: 41.23 ms, 메모리: 65.6 MB
5. 시간: 37.86 ms, 메모리: 60.2 MB

### 제출 일자

2024년 11월 29일 (금) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges