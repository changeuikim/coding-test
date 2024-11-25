# [Lv.2] [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=cpp) - 42888 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

vector<string> solution(vector<string> record) {
    unordered_map<string, string> userNames;
    vector<pair<string, string>> actions;
    unordered_map<string, string> messages = {
        {"Enter", "님이 들어왔습니다."},
        {"Leave", "님이 나갔습니다."}
    };

    for (const string& event : record) {
        vector<string> parts;
        int pos = 0, found;
        while ((found = event.find(' ', pos)) != string::npos) {
            parts.push_back(event.substr(pos, found - pos));
            pos = found + 1;
        }
        parts.push_back(event.substr(pos));

        string action = parts[0];
        string userId = parts[1];

        if (action == "Enter" || action == "Change") {
            string nickname = parts[2];
            userNames[userId] = nickname;
        }

        if (action == "Enter" || action == "Leave") {
            actions.emplace_back(userId, messages[action]);
        }
    }

    vector<string> result(actions.size());
    for (int i = 0; i < actions.size(); ++i) {
        const auto& action = actions[i];
        result[i] = userNames[action.first] + action.second;
    }

    return result;
}
```

### 성능 요약

1. 시간: 187.93 ms, 메모리: 44.4 MB

2. 시간: 178.29 ms, 메모리: 44 MB
3. 시간: 142.41 ms, 메모리: 43.8 MB
4. 시간: 138.53 ms, 메모리: 39.2 MB
5. 시간: 133.92 ms, 메모리: 42.3 MB

### 제출 일자

2024년 11월 25일 (월) 23:57

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges