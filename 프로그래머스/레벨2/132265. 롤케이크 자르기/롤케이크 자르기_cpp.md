# [Lv.2] [롤케이크 자르기](https://school.programmers.co.kr/learn/courses/30/lessons/132265?language=cpp) - 132265 

### 구분

코딩테스트 연습 > 연습문제

## C++ 문제풀이

```cpp
#include <vector>

using namespace std;

int solution(vector<int> topping) {
    int result = 0;

    // 인덱스가 토핑 번호, 요소가 토핑의 수
    int left[10000 + 1] = {0};
    int right[10000 + 1] = {0};

    // 동생 초기화
    int rc = 0;    
    for (int i : topping) {
        if (right[i] == 0) {
            rc++;
        }
        right[i]++;
    }

    // 슬라이딩 윈도우
    int lc = 0;
    for (int i : topping) {
        // 동생 제거
        right[i]--;
        if (right[i] == 0) {
            rc--;
        }

        // 철수 추가
        if (left[i] == 0) {
            lc++;
        }
        left[i]++;

        // 비교
        if (lc == rc) {
            result++;
        }
    }

    return result;
}
```

### 성능 요약

1. 시간: 7.12 ms, 메모리: 34.6 MB

2. 시간: 5.43 ms, 메모리: 36.7 MB
3. 시간: 5.41 ms, 메모리: 36.6 MB
4. 시간: 5.04 ms, 메모리: 36.6 MB
5. 시간: 4.99 ms, 메모리: 36.7 MB

### 제출 일자

2024년 11월 10일 (일) 23:10

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges