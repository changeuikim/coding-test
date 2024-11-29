# [Lv.3] [숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987?language=javascript) - 12987 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## JavaScript 문제풀이

```js
function solution(A, B) {
    A.sort((a, b) => a - b);
    B.sort((a, b) => a - b);
    
    let result = 0;
    let i = 0;

    for (let j = 0; j < B.length; j++) {
        if (B[j] > A[i]) {
            result++;
            i++;
        }
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 84.42 ms, 메모리: 44.6 MB

2. 시간: 83.95 ms, 메모리: 45.2 MB
3. 시간: 79.59 ms, 메모리: 43.7 MB
4. 시간: 6.28 ms, 메모리: 36.4 MB
5. 시간: 5.54 ms, 메모리: 36.3 MB

### 제출 일자

2024년 11월 29일 (금) 23:38

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges