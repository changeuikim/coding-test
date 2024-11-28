# [Lv.1] [대충 만든 자판](https://school.programmers.co.kr/learn/courses/30/lessons/160586?language=cpp) - 160586 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <unordered_map>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    // 키 사전 생성
    unordered_map<char, int> keyMap;

    for (auto& key : keymap) {
        for (int idx = 0; idx < key.size(); ++idx) {
            char ch = key[idx];
            if (keyMap.find(ch) == keyMap.end()) {
                keyMap[ch] = idx + 1;
            } else {
                keyMap[ch] = min(keyMap[ch], idx + 1);
            }
        }
    }

    // 결과 처리
    vector<int> result(targets.size());
    
    for (int i = 0; i < targets.size(); ++i) {
        string target = targets[i];
        int acc = 0;
        for (char ch : target) {
            if (keyMap.find(ch) == keyMap.end()) {
                acc = -1;
                break;
            }
            acc += keyMap[ch];
        }
        result[i] = acc;
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.15 ms, 메모리: 4.14 MB

2. 시간: 0.14 ms, 메모리: 4.14 MB
3. 시간: 0.13 ms, 메모리: 3.67 MB
4. 시간: 0.11 ms, 메모리: 4.21 MB
5. 시간: 0.11 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 28일 (목) 23:54

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges