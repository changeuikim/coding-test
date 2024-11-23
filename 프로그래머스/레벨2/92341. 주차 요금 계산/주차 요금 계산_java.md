# [Lv.2] [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=java) - 92341 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Solution {
    static class Event {
        String time;
        String status;
        
        public Event(String time, String status) {
            this.time = time;
            this.status = status;
        }
    }
    
    public static int timeToMinutes(String timeStr) {
        String[] parts = timeStr.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        return 60 * hours + minutes;
    }

    public static int calcFee(int totalTime, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            int extraTime = totalTime - baseTime;
            int extraFee = (int) Math.ceil((double) extraTime / unitTime) * unitFee;
            return baseFee + extraFee;
        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<String, List<Event>> parkingRecords = new HashMap<>();
        Map<String, Integer> parkingTimes = new HashMap<>();

        // 입/출차 기록을 차량별 입/출차 기록으로 파싱
        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            String status = parts[2];

            if (!parkingRecords.containsKey(car)) {
                parkingRecords.put(car, new ArrayList<>());
            }
            parkingRecords.get(car).add(new Event(time, status));
        }

        // 차량별 누적 주차 시간을 계산
        for (Map.Entry<String, List<Event>> entry : parkingRecords.entrySet()) {
            String car = entry.getKey();
            List<Event> events = entry.getValue();
            int totalTime = 0;
            Integer inTime = null;

            for (Event event : events) {
                if ("IN".equals(event.status)) {
                    inTime = timeToMinutes(event.time);
                } else {
                    totalTime += timeToMinutes(event.time) - inTime;
                    inTime = null;
                }
            }

            if (inTime != null) {
                totalTime += timeToMinutes("23:59") - inTime;
            }

            parkingTimes.put(car, totalTime);
        }

        // 차량별 요금을 계산
        return parkingTimes.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .mapToInt(entry -> calcFee(entry.getValue(), fees))
                .toArray();
    }
}
```

### 성능 요약

1. 시간: 17.07 ms, 메모리: 83.3 MB

2. 시간: 13.25 ms, 메모리: 83.8 MB
3. 시간: 12.12 ms, 메모리: 82.6 MB
4. 시간: 9.73 ms, 메모리: 79.7 MB
5. 시간: 8.16 ms, 메모리: 87 MB

### 제출 일자

2024년 11월 23일 (토) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges