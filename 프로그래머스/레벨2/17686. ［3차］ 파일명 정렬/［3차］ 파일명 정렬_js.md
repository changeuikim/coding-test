# [Lv.2] [[3차] 파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=javascript) - 17686 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
function solution(files) {
    const pattern = /^([a-zA-Z\-\. ]+)(\d{1,5})/;
    let parsedFiles = files.map((file, index) => {
        const match = file.match(pattern);
        const head = match[1];
        const number = match[2];
        return {
            head: head.toLowerCase(),
            number: parseInt(number),
            index: index
        };
    });

    parsedFiles.sort((a, b) => {
        const headComparision = a.head.localeCompare(b.head);
        if (headComparision !== 0) return headComparision;
        
        const numberComparison = a.number - b.number;
        if (numberComparison !== 0) return numberComparison;
        
        return a.index - b.index;
    });

    return parsedFiles.map(file => files[file.index]);
}
```

### 성능 요약

1. 시간: 38.35 ms, 메모리: 38.5 MB

2. 시간: 34.54 ms, 메모리: 35.9 MB
3. 시간: 28.50 ms, 메모리: 38.6 MB
4. 시간: 13.02 ms, 메모리: 38.6 MB
5. 시간: 12.48 ms, 메모리: 38.5 MB

### 제출 일자

2024년 11월 27일 (수) 00:44

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges