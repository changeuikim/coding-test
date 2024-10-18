# [Lv.0] [이어 붙인 수](https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=javascript) - 181928 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## JavaScript 문제풀이

```js
function solution(num_list) {
    const oddNums = num_list.filter(num => (num&1) === 1).join('');
    const evenNums = num_list.filter(num => (num&1) === 0).join('');
    
    return parseInt(oddNums) + parseInt(evenNums);
}
```

### 성능 요약

1. 시간: 0.12 ms, 메모리: 33.4 MB

2. 시간: 0.07 ms, 메모리: 33.6 MB
3. 시간: 0.07 ms, 메모리: 33.5 MB
4. 시간: 0.07 ms, 메모리: 33.4 MB
5. 시간: 0.06 ms, 메모리: 33.5 MB

### 제출 일자

2024년 10월 18일 (금) 11:29

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges