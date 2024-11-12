# [Lv.3] [이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=cpp) - 42628 

### 구분

코딩테스트 연습 > 힙（Heap）

## C++ 문제풀이

```cpp
#include <string>
#include <vector>
#include <map>

using namespace std;

vector<int> solution(vector<string> operations) {
    // 레드-블랙 트리 기반의 map
    map<int, int> tree_map;
    
    for (const string& element : operations) {
        char op = element[0];
        int val = stoi(element.substr(2));
        
        // 큐에 주어진 숫자를 삽입합니다.
        if (op == 'I') {
            tree_map[val]++;
        } else if (op == 'D') {
            if (tree_map.empty()) {
                continue;
            }
            // 큐에서 최댓값을 삭제합니다.
            if (val == 1) {
                auto it = prev(tree_map.end()); // 마지막 요소를 가리키는 반복자 : 최대값
                if (it->second == 1) {
                    tree_map.erase(it);
                } else {
                    it->second--;
                }
            }
            // 큐에서 최솟값을 삭제합니다.
            else if (val == -1) {
                auto it = tree_map.begin(); // 첫번째 요소를 가리키는 반복자 : 최소값
                if (it->second == 1) {
                    tree_map.erase(it);
                } else {
                    it->second--;
                }
            }
        }       
    }
    
    // 결과 반환
    if (tree_map.empty()) {
        return {0, 0};
    } else {
        return {prev(tree_map.end())->first, tree_map.begin()->first};
    }
}
```

### 성능 요약

1. 시간: 12.19 ms, 메모리: 10.8 MB

2. 시간: 0.02 ms, 메모리: 4.23 MB
3. 시간: 0.02 ms, 메모리: 4.16 MB
4. 시간: 0.02 ms, 메모리: 4.14 MB
5. 시간: 0.02 ms, 메모리: 3.68 MB

### 제출 일자

2024년 11월 12일 (화) 23:26

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges