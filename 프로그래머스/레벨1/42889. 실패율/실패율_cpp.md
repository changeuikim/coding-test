# [Lv.1] [실패율](https://school.programmers.co.kr/learn/courses/30/lessons/42889?language=cpp) - 42889 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    // 각 스테이지에 멈춘 플레이어 수 계산
    vector<int> stagePlayers(N + 2, 0);
    for (int stage : stages) {
        stagePlayers[stage]++;
    }
    
    // 각 스테이지의 실패율 계산
    vector<pair<int, double>> stageFailure;
    int players = stages.size();
    
    for (int stage = 1; stage < N + 1; stage++) {
        double failureRate = players > 0 ? (double) stagePlayers[stage] / players : 0;
        stageFailure.push_back({ stage, failureRate });
        players -= stagePlayers[stage];
    }
    
    // 실패율 내림차순, 스테이지 오름차순
    sort(stageFailure.begin(), stageFailure.end(), [](const pair<int, double>& a, const pair<int, double>& b) {
        if (a.second != b.second) {
            return a.second > b.second;
        }
        return a.first < b.first;
    });
    
    vector<int> result;
    for (const auto& [stage, _] : stageFailure) {
        result.push_back(stage);
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 0.82 ms, 메모리: 9.88 MB

2. 시간: 0.78 ms, 메모리: 9.71 MB
3. 시간: 0.76 ms, 메모리: 9.91 MB
4. 시간: 0.66 ms, 메모리: 8.3 MB
5. 시간: 0.61 ms, 메모리: 9.66 MB

### 제출 일자

2024년 11월 13일 (수) 23:48

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges