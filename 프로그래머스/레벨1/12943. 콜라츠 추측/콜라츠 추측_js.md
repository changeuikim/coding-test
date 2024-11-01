# [Lv.1] [콜라츠 추측](https://school.programmers.co.kr/learn/courses/30/lessons/12943?language=javascript) - 12943 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
function solution(num) {
    let cnt = 0;
    
    while (num !== 1) {
        if (cnt === 500) {
            return -1;
        }
        
        if ((num & 1) === 0) {
            num /= 2;
        } else {
            num = 3 * num + 1;
        }
        
        cnt++;
    }
    
    return cnt;
}
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 33.4 MB

2. 시간: 0.07 ms, 메모리: 33.4 MB
3. 시간: 0.07 ms, 메모리: 33.4 MB
4. 시간: 0.06 ms, 메모리: 33.4 MB
5. 시간: 0.05 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 01일 (금) 23:11

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges