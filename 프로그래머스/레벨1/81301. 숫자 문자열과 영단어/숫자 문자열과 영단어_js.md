# [Lv.1] [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=javascript) - 81301 

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

## JavaScript 문제풀이

```js
function solution(s) {
    const nums = ["zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"];
    
    for (let i = 0; i < nums.length; i++) {
        s = s.replace(new RegExp(nums[i], "g"), i);
    }
    
    return parseInt(s);
}
```

### 성능 요약

1. 시간: 0.12 ms, 메모리: 33.5 MB

2. 시간: 0.10 ms, 메모리: 33.4 MB
3. 시간: 0.09 ms, 메모리: 33.4 MB
4. 시간: 0.08 ms, 메모리: 33.4 MB
5. 시간: 0.07 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 06일 (수) 22:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges