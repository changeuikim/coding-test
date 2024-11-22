# [Lv.1] [[1차] 다트 게임](https://school.programmers.co.kr/learn/courses/30/lessons/17682?language=cpp) - 17682 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <string>
#include <unordered_map>
#include <regex>
#include <vector>
#include <cmath>

using namespace std;

int solution(string dartResult) {
    unordered_map<string, int> bonusMap = {
        {"S", 1}, {"D", 2}, {"T", 3}
    };
    unordered_map<string, int> optionMap = {
        {"*", 2}, {"#", -1}, {"", 1}
    };
    
    // 점수 | 보너스 | [옵션]
    regex pattern(R"((\d+)([SDT])([*#]?))");
    sregex_iterator iter(dartResult.begin(), dartResult.end(), pattern);
    sregex_iterator end;
    
    vector<int> scores;
    
    for (; iter != end; ++iter) {
        smatch match = *iter;
        string scoreStr = match[1];
        string bonus = match[2];
        string opt = match[3];
        
        int score = pow(stoi(scoreStr), bonusMap[bonus]) * optionMap[opt];
        
        if (opt == "*" && !scores.empty()) {
            scores.back() *= 2;
        }
        
        scores.push_back(score);
    }
    
    int result = 0;
    for (int score : scores) {
        result += score;
    }

    return result;    
}
```

### 성능 요약

1. 시간: 0.33 ms, 메모리: 4.28 MB

2. 시간: 0.30 ms, 메모리: 4.2 MB
3. 시간: 0.21 ms, 메모리: 4.22 MB
4. 시간: 0.19 ms, 메모리: 4.2 MB
5. 시간: 0.19 ms, 메모리: 4.19 MB

### 제출 일자

2024년 11월 22일 (금) 23:37

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges