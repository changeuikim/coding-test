# [Lv.2] [[3차] 파일명 정렬](https://school.programmers.co.kr/learn/courses/30/lessons/17686?language=cpp) - 17686 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <cctype>
#include <algorithm>
#include <regex>

using namespace std;

class ParsedFile {
public:
    string head;
    int number;
    int index;

    ParsedFile(const string& h, const string& n, int i) : index(i) {
        head = h;
        transform(head.begin(), head.end(), head.begin(), [](unsigned char c) { return std::tolower(c); });
        number = stoi(n);
    }
};

vector<string> solution(vector<string> files) {    
    regex pattern("([a-zA-Z\\-\\. ]+)(\\d{1,5})");
    vector<ParsedFile> parsedFiles;

    for (int i = 0; i < files.size(); ++i) {
        smatch match;
        if (regex_search(files[i], match, pattern)) {
            string head = match[1].str();
            string number = match[2].str();
            parsedFiles.emplace_back(head, number, i);
        }
    }

    sort(parsedFiles.begin(), parsedFiles.end(), [](const ParsedFile& a, const ParsedFile& b) {
        if (a.head != b.head) return a.head < b.head;
        if (a.number != b.number) return a.number < b.number;
        return a.index < b.index;
    });

    vector<string> result;
    for (const auto& file : parsedFiles) {
        result.push_back(files[file.index]);
    }

    return result;
}
```

### 성능 요약

1. 시간: 1.94 ms, 메모리: 4.37 MB

2. 시간: 1.34 ms, 메모리: 4.16 MB
3. 시간: 1.15 ms, 메모리: 4.17 MB
4. 시간: 1.12 ms, 메모리: 4.2 MB
5. 시간: 1.08 ms, 메모리: 4.28 MB

### 제출 일자

2024년 11월 27일 (수) 00:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges