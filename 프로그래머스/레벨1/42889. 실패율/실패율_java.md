# [Lv.1] [실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=java) - 42889 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## Java 문제풀이

```java
import java.util.List;
import java.util.ArrayList;

class Solution {
    /**
    정렬을 위한 클래스
    **/
    private static class Stage {
        int stage;
        double failureRate;
        
        Stage(int stage, double failureRate) {
            this.stage = stage;
            this.failureRate = failureRate;
        }
    }    
    
    public int[] solution(int N, int[] stages) {
        // 각 스테이지에 멈춘 플레이어 수 계산
        int[] stagePlayers = new int[N + 2];
        for (int stage : stages) {
            stagePlayers[stage]++;
        }
        
        // 각 스테이지의 실패율 계산
        List<Stage> stageFailure = new ArrayList<>();
        int players = stages.length;
        
        for (int stage = 1; stage < N + 1; stage++) {
            double failureRate = players > 0 ? (double) stagePlayers[stage] / players : 0;
            stageFailure.add(new Stage(stage, failureRate));
            players -= stagePlayers[stage];
        }
        
        // 실패율 내림차순, 스테이지 오름차순
        stageFailure.sort((a, b) -> {
            if (b.failureRate != a.failureRate) {
                return Double.compare(b.failureRate, a.failureRate);
            }
            return Integer.compare(a.stage, b.stage);
        });
        
        return stageFailure.stream().mapToInt(s -> s.stage).toArray();
    }
} 
```

### 성능 요약

1. 시간: 8.24 ms, 메모리: 102 MB

2. 시간: 7.21 ms, 메모리: 96 MB
3. 시간: 6.70 ms, 메모리: 87.1 MB
4. 시간: 6.32 ms, 메모리: 79.6 MB
5. 시간: 6.17 ms, 메모리: 83.3 MB

### 제출 일자

2024년 11월 13일 (수) 23:47

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges