# [Lv.0] [마지막 두 원소](https://school.programmers.co.kr/learn/courses/30/lessons/181927?language=cpp) - 181927 

### 구분

코딩테스트 연습 > 코딩 기초 트레이닝

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> num_list) {
    int size = num_list.size();
    int lastNum = num_list[size - 1];
    int preNum = num_list[size - 2];
    
    if (lastNum > preNum) {
        num_list.push_back(lastNum - preNum);
    } else {
        num_list.push_back(2 * lastNum);
    }          
    
    return num_list;
}

```

### 성능 요약

1. 시간: 0.02 ms, 메모리: 4.13 MB

2. 시간: 0.01 ms, 메모리: 4.27 MB
3. 시간: 0.01 ms, 메모리: 4.21 MB
4. 시간: 0.01 ms, 메모리: 4.21 MB
5. 시간: 0.01 ms, 메모리: 4.21 MB

### 제출 일자

2024년 10월 19일 (토) 20:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges