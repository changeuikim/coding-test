# [Lv.1] [최소직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=javascript) - 86491 

### 구분

코딩테스트 연습 > 완전탐색

## JavaScript 문제풀이

```js
function solution(sizes) {
    let [wMax, hMax] = [0, 0];
    
    sizes.forEach(([width, height]) => {
        if (width > height) {
            [width, height] = [height, width];
        }
        
        wMax = Math.max(wMax, width);
        hMax = Math.max(hMax, height);
    });

    return wMax * hMax;
}
```

### 성능 요약

1. 시간: 22.25 ms, 메모리: 38.6 MB

2. 시간: 20.38 ms, 메모리: 37.2 MB
3. 시간: 18.67 ms, 메모리: 36.8 MB
4. 시간: 18.10 ms, 메모리: 37.9 MB
5. 시간: 3.60 ms, 메모리: 38.8 MB

### 제출 일자

2024년 11월 06일 (수) 19:02

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges