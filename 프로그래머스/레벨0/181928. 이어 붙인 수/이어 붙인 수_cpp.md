# [Lv.0] [이어 붙인 수](https://school.programmers.co.kr/learn/courses/30/lessons/181928?language=cpp) - 181928 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <sstream>

using namespace std;

int solution(vector<int> num_list) {
    ostringstream oddNums, evenNums;
    
    for (int num : num_list) {
        if (num&1 == 1) {
            oddNums << num;
        } else {
            evenNums << num;
        }
    }
    
    return stoi(oddNums.str()) + stoi(evenNums.str());
}
```

### 성능 요약

1. 시간: 0.04 ms, 메모리: 4.21 MB

2. 시간: 0.03 ms, 메모리: 4.21 MB
3. 시간: 0.03 ms, 메모리: 4.21 MB
4. 시간: 0.03 ms, 메모리: 4.16 MB
5. 시간: 0.03 ms, 메모리: 4.15 MB

### 제출 일자

2024년 10월 18일 (금) 11:30

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges