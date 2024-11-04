# [Lv.1] [예산](https://school.programmers.co.kr/learn/courses/30/lessons/12982?language=cpp) - 12982 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> d, int budget) {
    sort(d.begin(), d.end());
    int cnt = 0;
    
    for (int cost : d) {
        budget -= cost;
        if (budget < 0) {
            break;
        }
        cnt++;
    }
    
    return cnt;
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.15 MB

2. 시간: 0.01 ms, 메모리: 4.22 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 04일 (월) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges