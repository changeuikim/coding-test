# [Lv.1] [[PCCE 기출문제] 9번 / 지폐 접기](https://school.programmers.co.kr/learn/courses/30/lessons/340199?language=cpp) - 340199 

### 구분

코딩테스트 연습 > PCCE 기출문제

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>

using namespace std;

int solution(vector<int> wallet, vector<int> bill) {
    sort(wallet.begin(), wallet.end());
    sort(bill.begin(), bill.end());
    int count = 0;
    
    while (bill[0] > wallet[0] || bill[1] > wallet[1]) {
        bill[1] /= 2;
        sort(bill.begin(), bill.end());
        count++;
    }
    
    return count;
}
```

### 성능 요약

1. 시간: 0.01 ms, 메모리: 4.27 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 21일 (목) 23:45

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges