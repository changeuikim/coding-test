# [Lv.3] [숫자 게임](https://school.programmers.co.kr/learn/courses/30/lessons/12987?language=cpp) - 12987 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> A, vector<int> B) {
    sort(A.begin(), A.end());
    sort(B.begin(), B.end());
    
    int result = 0;
    int i = 0;
    
    for (size_t j = 0; j < B.size(); ++j) {
        if (B[j] > A[i]) {
            result++;
            i++;
        }
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 11.96 ms, 메모리: 10.5 MB

2. 시간: 11.91 ms, 메모리: 10.1 MB
3. 시간: 11.63 ms, 메모리: 10.2 MB
4. 시간: 0.88 ms, 메모리: 4.23 MB
5. 시간: 0.83 ms, 메모리: 4.23 MB

### 제출 일자

2024년 11월 29일 (금) 23:39

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges