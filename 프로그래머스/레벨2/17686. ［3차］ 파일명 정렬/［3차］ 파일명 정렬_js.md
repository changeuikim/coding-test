# [Lv.2] [[3차] 파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=javascript) - 17686 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(files) {
    const pattern = /^([a-zA-Z\-\. ]+)(\d{1,5})/;
    let parsedFiles = files.map(file => {
        const match = file.match(pattern);
        return {
            head: match[1],
            number: parseInt(match[2], 10),
            original: file
        };
    });

    parsedFiles.sort((a, b) => {
        const headComparison = a.head.toLowerCase().localeCompare(b.head.toLowerCase());
        if (headComparison !== 0) return headComparison;
        return a.number - b.number;
    });

    return parsedFiles.map(file => file.original);
}
```

### 성능 요약

1. 시간: 16.83 ms, 메모리: 36.9 MB

2. 시간: 16.55 ms, 메모리: 38.9 MB
3. 시간: 13.99 ms, 메모리: 38.8 MB
4. 시간: 13.36 ms, 메모리: 38.9 MB
5. 시간: 12.98 ms, 메모리: 36.6 MB

### 제출 일자

2024년 11월 26일 (화) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges