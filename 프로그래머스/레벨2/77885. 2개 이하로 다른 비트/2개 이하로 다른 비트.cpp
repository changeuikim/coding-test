#include <vector>

using namespace std;

vector<long long> solution(vector<long long> numbers) {
    vector<long long> result;

    for (long long num : numbers) {
        // 첫번째 0은 1로, 뒤는 모두 0
        long long biggerNum = num + 1;
        
        // 첫번째 0 이전은 0, 뒤는 모두 1
        long long bitDiff = num ^ (num + 1);
        
        // 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        long long minNum = biggerNum + (bitDiff >> 2);

        result.push_back(minNum);
    }

    return result;
}