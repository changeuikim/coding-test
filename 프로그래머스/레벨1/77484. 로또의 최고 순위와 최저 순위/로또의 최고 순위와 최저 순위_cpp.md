# [Lv.1] [로또의 최고 순위와 최저 순위](https://school.programmers.co.kr/learn/courses/30/lessons/77484?language=cpp) - 77484 

### 구분

코딩테스트 연습 > 2021 Dev－Matching： 웹 백엔드 개발자（상반기）

## C++ 문제풀이

```cpp
#include <vector>
#include <unordered_set>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> rank = {6, 6, 5, 4, 3, 2, 1};
    int zero_count = 0;
    unordered_set<int> lottosSet;

    for (int num : lottos) {
        if (num == 0) {
            zero_count++;
        } else {
            lottosSet.insert(num);
        }
    }

    int inter_count = 0;

    for (int win_num : win_nums) {
        if (lottosSet.find(win_num) != lottosSet.end()) {
            inter_count++;
        }
    }

    int max_count = inter_count + zero_count;
    int min_count = inter_count;

    return {rank[max_count], rank[min_count]};
}
```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 3.59 MB

2. 시간: 0.01 ms, 메모리: 4.21 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.2 MB

### 제출 일자

2024년 11월 23일 (토) 23:55

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges