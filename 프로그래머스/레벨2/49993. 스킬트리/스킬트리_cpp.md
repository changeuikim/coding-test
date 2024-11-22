# [Lv.2] [스킬트리](https://school.programmers.co.kr/learn/courses/30/lessons/49993?language=cpp) - 49993 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <unordered_set>

using namespace std;

bool isValid(const string& skillOrder, const string& skillTree, const unordered_set<char>& skillSet) {
    int idx = 0;
    
    for (char c : skillTree) {
        if (skillSet.find(c) != skillSet.end()) {
            if (c == skillOrder[idx]) {
                idx++;
            } else {
                return false;
            }
        }
    }
    
    return true;
}

int solution(string skill, vector<string> skill_trees) {
    unordered_set<char> skillSet(skill.begin(), skill.end());
    int count = 0;
    
    for (const string& skillTree : skill_trees) {
        if (isValid(skill, skillTree, skillSet)) {
            count++;
        }
    }
    
    return count;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.21 MB

2. 시간: 0.02 ms, 메모리: 3.59 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 22일 (금) 23:52

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges