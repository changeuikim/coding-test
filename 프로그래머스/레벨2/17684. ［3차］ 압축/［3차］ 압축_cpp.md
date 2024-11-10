# [Lv.2] [[3차] 압축](https://school.programmers.co.kr/learn/courses/30/lessons/17684?language=cpp) - 17684 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <unordered_map>
#include <vector>
#include <string>

using namespace std;

vector<int> solution(string msg) {
    vector<int> result;    
    
    // LZW 사전
    unordered_map<string, int> dic;
    for (int i = 0; i < 26; ++i) {
        dic[string(1, 'A' + i)] = i + 1;
    }
    int idx = 27;

    // 압축
    string w = "";
    for (char c : msg) {
        string wc = w + c;
        if (dic.find(wc) != dic.end()) {
            w = wc;
        } else {
            result.push_back(dic[w]);
            dic[wc] = idx++;
            w = string(1, c);
        }
    }

    // 잔여 처리
    if (!w.empty()) {
        result.push_back(dic[w]);
    }

    return result;
}
```

### 성능 요약

1. 시간: 0.35 ms, 메모리: 4.17 MB

2. 시간: 0.28 ms, 메모리: 3.84 MB
3. 시간: 0.24 ms, 메모리: 3.71 MB
4. 시간: 0.22 ms, 메모리: 4.21 MB
5. 시간: 0.13 ms, 메모리: 4.19 MB

### 제출 일자

2024년 11월 10일 (일) 23:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges