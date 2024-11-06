# [Lv.1] [최소직사각형](https://school.programmers.co.kr/learn/courses/30/lessons/86491?language=cpp) - 86491 

### 구분

코딩테스트 연습 > 완전탐색

## C++ 문제풀이

```cpp
#include <vector>
#include <algorithm>
#include <cmath>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int wMax = 0, hMax = 0;

    for (const auto& size : sizes) {
        int width = size[0];
        int height = size[1];

        if (width > height) {
            swap(width, height);
        }

        wMax = max(wMax, width);
        hMax = max(hMax, height);
    }

    return wMax * hMax;
}
```

### 성능 요약

1. 시간: 0.60 ms, 메모리: 5 MB

2. 시간: 0.59 ms, 메모리: 4.9 MB
3. 시간: 0.52 ms, 메모리: 4.75 MB
4. 시간: 0.45 ms, 메모리: 4.62 MB
5. 시간: 0.39 ms, 메모리: 4.21 MB

### 제출 일자

2024년 11월 06일 (수) 19:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges