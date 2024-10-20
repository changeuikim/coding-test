# [Lv.0] [수열과 구간 쿼리 2](https://school.programmers.co.kr/learn/courses/30/lessons/181923?language=javascript) - 181923 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(arr, queries) {
    return queries.map(([s, e, k]) => {
        let minVal = Infinity;
        
        for (let i = s; i <= e; i++) {
            if (arr[i] > k) {
                minVal = Math.min(minVal, arr[i]);
            }
        }
        
        return minVal === Infinity ? -1 : minVal;
    });
}
```

### 성능 요약

1. 시간: 4.21 ms, 메모리: 36.4 MB

2. 시간: 3.40 ms, 메모리: 36.8 MB
3. 시간: 3.33 ms, 메모리: 36.7 MB
4. 시간: 3.23 ms, 메모리: 36.8 MB
5. 시간: 3.06 ms, 메모리: 36.6 MB

### 제출 일자

2024년 10월 20일 (일) 22:53

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges