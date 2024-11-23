# [Lv.2] [주차 요금 계산](https://school.programmers.co.kr/learn/courses/30/lessons/92341?language=cpp) - 92341 

### 구분

코딩테스트 연습 > 2022 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <unordered_map>
#include <map>
#include <cmath>
#include <sstream>
#include <iostream>

using namespace std;

int timeToMinutes(const string &timeStr) {
    int hours = stoi(timeStr.substr(0, 2));
    int minutes = stoi(timeStr.substr(3, 2));
    return 60 * hours + minutes;
}

int calcFee(int totalTime, const vector<int> &fees) {
    int baseTime = fees[0];
    int baseFee = fees[1];
    int unitTime = fees[2];
    int unitFee = fees[3];

    if (totalTime <= baseTime) {
        return baseFee;
    } else {
        int extraTime = totalTime - baseTime;
        int extraFee = ceil(static_cast<double>(extraTime) / unitTime) * unitFee;
        return baseFee + extraFee;
    }
}

vector<int> solution(vector<int> fees, vector<string> records) {
    unordered_map<string, vector<pair<string, string>>> parkingRecords;
    unordered_map<string, int> parkingTimes;

    // 입/출차 기록을 차량별 입/출차 기록으로 파싱
    for (const string &record : records) {
        stringstream ss(record);
        string time, car, status;
        ss >> time >> car >> status;

        parkingRecords[car].emplace_back(time, status);
    }

    // 차량별 누적 주차 시간을 계산
    for (const auto &entry : parkingRecords) {
        const string &car = entry.first;
        const vector<pair<string, string>> &events = entry.second;
        int totalTime = 0;
        int inTime = -1;

        for (const auto &event : events) {
            if (event.second == "IN") {
                inTime = timeToMinutes(event.first);
            } else {
                totalTime += timeToMinutes(event.first) - inTime;
                inTime = -1;
            }
        }

        if (inTime != -1) {
            totalTime += timeToMinutes("23:59") - inTime;
        }

        parkingTimes[car] = totalTime;
    }

    // 차량별 요금을 계산
    map<string, int> sortedParkingTimes(parkingTimes.begin(), parkingTimes.end());
    vector<int> result;

    for (const auto &entry : sortedParkingTimes) {
        result.push_back(calcFee(entry.second, fees));
    }

    return result;
}
```

### 성능 요약

1. 시간: 1.53 ms, 메모리: 4.2 MB

2. 시간: 1.35 ms, 메모리: 4.21 MB
3. 시간: 1.21 ms, 메모리: 4.11 MB
4. 시간: 1.06 ms, 메모리: 4.21 MB
5. 시간: 0.73 ms, 메모리: 3.92 MB

### 제출 일자

2024년 11월 23일 (토) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges