# [Lv.1] [삼총사](https://school.programmers.co.kr/learn/courses/30/lessons/131705?language=javascript) - 131705 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(number) {
    let count = 0;
    const n = number.length;

    for (let i = 0; i < n; i++) {
        for (let j = i + 1; j < n; j++) {
            for (let k = j + 1; k < n; k++) {
                if (number[i] + number[j] + number[k] === 0) {
                    count++;
                }
            }
        }
    }

    return count;
}

```

### 성능 요약

1. 시간: 0.22 ms, 메모리: 33.5 MB

2. 시간: 0.21 ms, 메모리: 33.4 MB
3. 시간: 0.20 ms, 메모리: 33.6 MB
4. 시간: 0.19 ms, 메모리: 33.6 MB
5. 시간: 0.19 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 05일 (화) 23:51

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges