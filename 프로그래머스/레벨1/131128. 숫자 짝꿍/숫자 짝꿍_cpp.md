# [Lv.1] [숫자 짝꿍](https://school.programmers.co.kr/learn/courses/30/lessons/131128?language=cpp) - 131128 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <unordered_map>
#include <algorithm>

using namespace std;

string solution(string X, string Y) {
    // X, Y의 MAP
    unordered_map<char, int> xMap;
    unordered_map<char, int> yMap;

    for (char ch : X) {
        xMap[ch]++;
    }

    for (char ch : Y) {
        yMap[ch]++;
    }

    // X, Y의 교집합 키
    vector<char> rKeys;
    for (char i = '9'; i >= '0'; --i) {
        if (xMap.count(i) && yMap.count(i)) {
            rKeys.push_back(i);
        }
    }

    // 조기 반환
    if (rKeys.empty()) {
        return "-1";
    } else if (rKeys[0] == '0') {
        return "0";
    }

    // 결과 반환
    string result;
    for (char key : rKeys) {
        int count = min(xMap[key], yMap[key]);
        result.append(count, key);
    }

    return result;
}
```

### 성능 요약

1. 시간: 58.08 ms, 메모리: 29 MB

2. 시간: 57.88 ms, 메모리: 29 MB
3. 시간: 57.25 ms, 메모리: 28.9 MB
4. 시간: 53.84 ms, 메모리: 29 MB
5. 시간: 53.23 ms, 메모리: 29 MB

### 제출 일자

2024년 12월 01일 (일) 23:09

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges