# [Lv.3] [기지국 설치](https://programmers.co.kr/) - 12979 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## JavaScript 문제풀이

```js
function solution(n, stations, w) {
    const cover = 2 * w + 1;
    let result = 0;
    
    // 좌측 끝 처리
    const left = stations[0] - w -1
    if (left > 0) result += Math.ceil(left / cover);
    
    // 중간 구간 처리
    let start = stations[0];
    for (let i = 1; i < stations.length; i++) {
        let end = stations[i];
        let mid = end - start - cover;
        if (mid > 0) result += Math.ceil(mid / cover);
        
        start = end;
    }
    
    // 우측 끝 처리
    const right = n - stations[stations.length - 1] - w;
    if (right > 0) result += Math.ceil(right / cover);
    
    return result;
}
```

### 성능 요약

1. 시간: 2.18 ms, 메모리: 37 MB

2. 시간: 1.99 ms, 메모리: 37.1 MB
3. 시간: 1.90 ms, 메모리: 37.1 MB
4. 시간: 0.61 ms, 메모리: 33.9 MB
5. 시간: 0.16 ms, 메모리: 33.4 MB

### 제출 일자

2024년 12월 02일 (월) 23:49

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges