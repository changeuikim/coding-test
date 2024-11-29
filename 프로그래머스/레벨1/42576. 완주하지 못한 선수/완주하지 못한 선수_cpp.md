# [Lv.1] [완주하지 못한 선수](https://school.programmers.co.kr/learn/courses/30/lessons/42576?language=cpp) - 42576 

### 구분

코딩테스트 연습 > 해시

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    unordered_map<string, int> hashMap;

    for (const string& p : participant) {
        hashMap[p]++;
    }

    for (const string& c : completion) {
        hashMap[c]--;
    }

    for (const auto& entry : hashMap) {
        if (entry.second == 1) {
            return entry.first;
        }
    }

    return "";
}
```

### 성능 요약

1. 시간: 35.64 ms, 메모리: 32.4 MB

2. 시간: 35.45 ms, 메모리: 32.5 MB
3. 시간: 30.44 ms, 메모리: 30 MB
4. 시간: 25.02 ms, 메모리: 25.3 MB
5. 시간: 16.21 ms, 메모리: 17.8 MB

### 제출 일자

2024년 11월 29일 (금) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges