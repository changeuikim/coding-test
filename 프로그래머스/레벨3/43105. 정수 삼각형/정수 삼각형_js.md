# [Lv.3] [정수 삼각형](https://school.programmers.co.kr/learn/courses/30/lessons/43105?language=javascript) - 43105 

### 구분

코딩테스트 연습 > 동적계획법（Dynamic Programming）

## JavaScript 문제풀이

```js
function solution(triangle) {
    // bottom-up  DP
    for (let row = triangle.length - 2; row >= 0; row--) {
        for (let col = 0; col < triangle[row].length; col++) {
            const left = triangle[row + 1][col];
            const right = triangle[row + 1][col + 1];
            triangle[row][col] += (left > right) ? left : right;
        }
    }
    return triangle[0][0];
}
```

### 성능 요약

1. 시간: 26.70 ms, 메모리: 41.6 MB

2. 시간: 4.13 ms, 메모리: 41.1 MB
3. 시간: 3.93 ms, 메모리: 41.9 MB
4. 시간: 3.92 ms, 메모리: 41.7 MB
5. 시간: 3.82 ms, 메모리: 41.4 MB

### 제출 일자

2024년 11월 07일 (목) 23:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges