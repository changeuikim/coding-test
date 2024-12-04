# [Lv.2] [가장 큰 수](https://programmers.co.kr/) - 42746 

### 구분

코딩테스트 연습 > 정렬

## C++ 문제풀이

```cpp
#include <vector>
#include <string>
#include <algorithm>

using namespace std;

bool compare(const string &x, const string &y) {
    return (x + y) > (y + x);
}

string solution(vector<int> numbers) {
    vector<string> numbers_vector;
    for (int num : numbers) {
        numbers_vector.push_back(to_string(num));
    }

    sort(numbers_vector.begin(), numbers_vector.end(), compare);

    string result = "";
    for (const string &num : numbers_vector) {
        result += num;
    }

    return result[0] == '0' ? "0" : result;
}
```

### 성능 요약

1. 시간: 59.39 ms, 메모리: 10.5 MB

2. 시간: 53.16 ms, 메모리: 9.93 MB
3. 시간: 41.88 ms, 메모리: 7.77 MB
4. 시간: 39.40 ms, 메모리: 7.13 MB
5. 시간: 24.53 ms, 메모리: 6.66 MB

### 제출 일자

2024년 12월 04일 (수) 23:59

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges