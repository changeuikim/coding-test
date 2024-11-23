# [Lv.2] [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=python3) - 92341 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
from math import ceil
from collections import defaultdict

def time_to_minutes(time_str):
    hours, minutes = map(int, time_str.split(":"))
    return 60 * hours + minutes

def calc_fee(total_time, fees):
    base_time, base_fee, unit_time, unit_fee = fees
    
    if total_time <= base_time:
        return base_fee
    else:
        extra_time = total_time - base_time
        extra_fee = ceil(extra_time / unit_time) * unit_fee
        return base_fee + extra_fee

def solution(fees, records):
    parking_records = defaultdict(list)
    parking_times = defaultdict(int)
    
    # 입/출차 기록을 차량별 입/출차 기록으로 파싱
    for record in records:
        time, car, status = record.split()
        parking_records[car].append((time, status))
        
    # 차량별 누적 주차 시간을 계산
    for car, events in parking_records.items():
        total_time = 0
        in_time = None
        
        for time, status in events:
            if status == "IN":
                in_time = time_to_minutes(time)
            else: 
                total_time += time_to_minutes(time) - in_time
                in_time = None
        
        if in_time is not None:
            total_time += time_to_minutes("23:59") - in_time
            
        parking_times[car] = total_time
    
    # 차량별 요금을 계산
    result = []
    for car in sorted(parking_times):
        total_time = parking_times[car]
        fee = calc_fee(total_time, fees)
        result.append(fee)
        
    return result
```

### 성능 요약

1. 시간: 2.82 ms, 메모리: 10.7 MB

2. 시간: 2.56 ms, 메모리: 10.6 MB
3. 시간: 1.89 ms, 메모리: 10.7 MB
4. 시간: 1.60 ms, 메모리: 10.7 MB
5. 시간: 1.09 ms, 메모리: 10.6 MB

### 제출 일자

2024년 11월 23일 (토) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges