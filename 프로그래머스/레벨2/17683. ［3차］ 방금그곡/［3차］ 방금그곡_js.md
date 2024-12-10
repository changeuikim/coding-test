# [Lv.2] [[3차] 방금그곡](https://programmers.co.kr/) - 17683 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
const noteConverter = (melody) => {
    return melody.replace(/[A-Z]#/g, (note) => note[0].toLowerCase());
}

const minuteConverter = (timeString) => {
    const [hour, minute] = timeString.split(":").map(Number);
    return 60 * hour + minute;
}

const melodyRepeater = (melody, playTime) => {
    return melody.repeat(Math.ceil(playTime / melody.length)).substr(0, playTime);
}

function solution(m, musicinfos) {
    const convM = noteConverter(m);
    let resultTitle = "(None)";
    let resultTime = 0;
    
    musicinfos.forEach((musicInfo) => {
       const [start, end, title, melody] = musicInfo.split(",");
        const playTime = minuteConverter(end) - minuteConverter(start);
        const convMelody = noteConverter(melody);
        const repeatedMelody = melodyRepeater(convMelody, playTime);
        
        if (repeatedMelody.includes(convM) && playTime > resultTime) {
            resultTitle = title;
            resultTime = playTime;
        }
    });
    
    return resultTitle;
}
```

### 성능 요약

1. 시간: 3.72 ms, 메모리: 34.3 MB

2. 시간: 3.53 ms, 메모리: 34.2 MB
3. 시간: 0.71 ms, 메모리: 33.5 MB
4. 시간: 0.70 ms, 메모리: 33.4 MB
5. 시간: 0.69 ms, 메모리: 33.5 MB

### 제출 일자

2024년 12월 10일 (화) 17:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges