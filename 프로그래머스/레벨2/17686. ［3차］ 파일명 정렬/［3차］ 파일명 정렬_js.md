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
        if (a.head !== b.head) return a.head.localeCompare(b.head);
        if (a.number !== b.number) return a.number - b.number;
        return a.index - b.index;
    });

    return parsedFiles.map(file => files[file.index]);
}
```

### 성능 요약

1. 시간: 36.34 ms, 메모리: 38.7 MB

2. 시간: 36.31 ms, 메모리: 38.8 MB
3. 시간: 35.11 ms, 메모리: 36.1 MB
4. 시간: 15.80 ms, 메모리: 36.7 MB
5. 시간: 15.76 ms, 메모리: 36.6 MB

### 제출 일자

2024년 11월 27일 (수) 00:39

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges