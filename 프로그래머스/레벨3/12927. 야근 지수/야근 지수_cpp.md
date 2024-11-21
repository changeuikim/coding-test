# [Lv.3] [야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=cpp) - 12927 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>
#include <numeric>
#include <set>

using namespace std;

long long solution(int n, vector<int> works) {
    long long totalWorks = accumulate(works.begin(), works.end(), 0LL);
    if (totalWorks <= n) {
        return 0;
    }
    
    // 레드 블랙 트리
    multiset<long long, greater<long long>> workSet(works.begin(), works.end());
    while (n--) {
        auto it = workSet.begin();
        long long maxWork = *it;
        workSet.erase(it);
        
        if (maxWork > 1) {
            workSet.insert(maxWork - 1);
        }        
    }
    
    // 최종 결과
    long long result = 0;
    for (const auto& work : workSet) {
        result += work * work;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 78.72 ms, 메모리: 3.77 MB

2. 시간: 73.28 ms, 메모리: 3.83 MB
3. 시간: 0.31 ms, 메모리: 4.13 MB
4. 시간: 0.22 ms, 메모리: 4.21 MB
5. 시간: 0.02 ms, 메모리: 4.23 MB

### 제출 일자

2024년 11월 21일 (목) 23:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges