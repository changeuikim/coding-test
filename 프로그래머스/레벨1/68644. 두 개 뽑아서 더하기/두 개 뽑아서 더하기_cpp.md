# [Lv.1] [두 개 뽑아서 더하기](https://school.programmers.co.kr/learn/courses/30/lessons/68644?language=cpp) - 68644 

### 구분

코딩테스트 연습 > 월간 코드 챌린지 시즌1

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <set>

using namespace std;

vector<int> solution(vector<int> numbers) {
    set<int> nSet;
    
    for (int i = 0; i < numbers.size(); i++) {
        for (int j = i + 1; j < numbers.size(); j++) {
            nSet.insert(numbers[i] + numbers[j]);
        }
    }
    
    vector<int> result(nSet.begin(), nSet.end());
    
    return result;
}
```

### 성능 요약

1. 시간: 0.23 ms, 메모리: 4.14 MB

2. 시간: 0.11 ms, 메모리: 4.13 MB
3. 시간: 0.05 ms, 메모리: 4.17 MB
4. 시간: 0.02 ms, 메모리: 4.14 MB
5. 시간: 0.02 ms, 메모리: 4.14 MB

### 제출 일자

2024년 11월 06일 (수) 22:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges