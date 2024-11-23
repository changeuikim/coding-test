# [Lv.1] [로또의 최고 순위와 최저 순위](https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=javascript) - 77484 

### 구분

코딩테스트 연습 > 2021 Dev－Matching： 웹 백엔드 개발자（상반기）

## JavaScript 문제풀이

```js
function solution(lottos, win_nums) {
    const rank = [6, 6, 5, 4, 3, 2, 1];
    let zero_count = 0;
    const lottosSet = new Set();

    for (const num of lottos) {
        if (num === 0) {
            zero_count++;
        } else {
            lottosSet.add(num);
        }
    }

    let inter_count = 0;

    for (const num of win_nums) {
        if (lottosSet.has(num)) {
            inter_count++;
        }
    }

    const max_count = inter_count + zero_count;
    const min_count = inter_count;

    return [rank[max_count], rank[min_count]];
}
```

### 성능 요약

1. 시간: 0.08 ms, 메모리: 33.5 MB

2. 시간: 0.07 ms, 메모리: 33.6 MB
3. 시간: 0.07 ms, 메모리: 33.4 MB
4. 시간: 0.07 ms, 메모리: 33.4 MB
5. 시간: 0.06 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 23일 (토) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges