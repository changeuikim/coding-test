# [Lv.2] [[3차] 방금그곡](https://programmers.co.kr/) - 17683 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <bits/stdc++.h>

using namespace std;

string noteConverter(const string& melody) {
    string result;
    for (char note : melody) {
        if (note == '#') {
            result.back() = tolower(result.back());
        } else {
            result.push_back(note);
        }
    }
    return result;
}

int minuteConverter(const string& timeString) {
    size_t colonPos = timeString.find(':');
    int hour = stoi(timeString.substr(0, colonPos));
    int minute = stoi(timeString.substr(colonPos + 1));
    return 60 * hour + minute;
}

string melodyRepeater(const string& melody, int playTime) {
    string result;
    int repeatCount = ceil(static_cast<double>(playTime) / melody.size());
    for (int i = 0; i < repeatCount; ++i) {
        result += melody;
    }
    return result.substr(0, playTime);
}

string solution(string m, vector<string> musicinfos) {
    string convM = noteConverter(m);
    string resultTitle = "(None)";
    int resultTime = 0;

    for (const string& musicinfo : musicinfos) {
        stringstream ss(musicinfo);
        string start, end, title, melody;

        getline(ss, start, ',');
        getline(ss, end, ',');
        getline(ss, title, ',');
        getline(ss, melody, ',');

        int playTime = minuteConverter(end) - minuteConverter(start);
        string convMelody = noteConverter(melody);
        string repeatedMelody = melodyRepeater(convMelody, playTime);

        if (repeatedMelody.find(convM) != string::npos && playTime > resultTime) {
            resultTitle = title;
            resultTime = playTime;
        }
    }

    return resultTitle;
}
```

### 성능 요약

1. 시간: 0.34 ms, 메모리: 4.22 MB

2. 시간: 0.34 ms, 메모리: 4.02 MB
3. 시간: 0.08 ms, 메모리: 4.21 MB
4. 시간: 0.08 ms, 메모리: 3.59 MB
5. 시간: 0.07 ms, 메모리: 4.2 MB

### 제출 일자

2024년 12월 10일 (화) 17:42

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges