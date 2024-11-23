# [Lv.2] [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=javascript) - 92341 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## JavaScript 문제풀이

```js
const timeToMinutes = (timeStr) => {
    const [hours, minutes] = timeStr.split(":").map(Number);
    return 60 * hours + minutes;
}

const calcFee = (totalTime, fees) => {
    const [baseTime, baseFee, unitTime, unitFee] = fees;
    
    if (totalTime <= baseTime) {
        return baseFee;
    } else {
        const extraTime = totalTime - baseTime;
        const extraFee = Math.ceil(extraTime / unitTime) * unitFee;
        return baseFee + extraFee;
    }
}

function solution(fees, records) {
    const parkingRecords = {};
    const parkingTimes = {};
    
    // 입/출차 기록을 차량별 입/출차 기록으로 파싱
    records.forEach((record) => {
        const [time, car, status] = record.split(" ");
        if (!parkingRecords[car]) {
            parkingRecords[car] = [];
        }
        parkingRecords[car].push([time, status]);
    });
    
    // 차량별 누적 주차 시간을 계산
    for (const car of Object.keys(parkingRecords)) {
        let totalTime = 0;
        let inTime = null;
        
        for (const [time, status] of parkingRecords[car]) {
            if (status == "IN") {
                inTime = timeToMinutes(time);
            } else {
                totalTime += timeToMinutes(time) - inTime;
                inTime = null;
            }        
        }
        
        if (inTime != null) {
            totalTime += timeToMinutes("23:59") - inTime;
        }
    
        parkingTimes[car] = totalTime;
    }
    
    // 차량별 요금을 계산
    return Object.keys(parkingTimes).sort().map(car => calcFee(parkingTimes[car], fees)); 
}
```

### 성능 요약

1. 시간: 11.19 ms, 메모리: 35.2 MB

2. 시간: 6.15 ms, 메모리: 35.2 MB
3. 시간: 4.60 ms, 메모리: 34.5 MB
4. 시간: 4.22 ms, 메모리: 34.8 MB
5. 시간: 4.17 ms, 메모리: 34.6 MB

### 제출 일자

2024년 11월 23일 (토) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges