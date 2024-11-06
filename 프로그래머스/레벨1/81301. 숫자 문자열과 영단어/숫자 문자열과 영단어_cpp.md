# [Lv.1] [숫자 문자열과 영단어](https://school.programmers.co.kr/learn/courses/30/lessons/81301?language=cpp) - 81301 

### 구분

코딩테스트 연습 > 2021 카카오 채용연계형 인턴십

## C++ 문제풀이

```cpp
#include <string>
#include <vector>

using namespace std;

int solution(string s) {
    vector<string> nums = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
    
    for (int i = 0; i < nums.size(); i++) {
        int pos;
        while ((pos = s.find(nums[i])) != string::npos) {
            s.replace(pos, nums[i].length(), to_string(i));
        }
    }
    
    return stoi(s);
}
```

### 성능 요약

1. 시간: 0.03 ms, 메모리: 4.29 MB

2. 시간: 0.03 ms, 메모리: 4.21 MB
3. 시간: 0.03 ms, 메모리: 4.21 MB
4. 시간: 0.03 ms, 메모리: 3.83 MB
5. 시간: 0.03 ms, 메모리: 3.63 MB

### 제출 일자

2024년 11월 06일 (수) 22:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges