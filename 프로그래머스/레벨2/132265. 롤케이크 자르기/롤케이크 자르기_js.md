# [Lv.2] [롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=javascript) - 132265 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(topping) {
    let result = 0;

    // 인덱스가 토핑 번호, 요소가 토핑의 수
    let left = new Array(10000 + 1).fill(0);
    let right = new Array(10000 + 1).fill(0);

    // 동생 초기화
    let rc = 0;    
    for (let i of topping) {
        if (right[i] === 0) {
            rc++;
        }
        right[i]++;
    }

    // 슬라이딩 윈도우
    let lc = 0;
    for (let i of topping) {
        // 동생 제거
        right[i]--;
        if (right[i] === 0) {
            rc--;
        }

        // 철수 추가
        if (left[i] === 0) {
            lc++;
        }
        left[i]++;

        // 비교
        if (lc === rc) {
            result++;
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 360.00 ms, 메모리: 71.4 MB

2. 시간: 51.95 ms, 메모리: 71.1 MB
3. 시간: 50.95 ms, 메모리: 71.4 MB
4. 시간: 49.36 ms, 메모리: 71.2 MB
5. 시간: 49.34 ms, 메모리: 71.4 MB

### 제출 일자

2024년 11월 10일 (일) 23:08

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges