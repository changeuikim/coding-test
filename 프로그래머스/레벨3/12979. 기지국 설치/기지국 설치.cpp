#include <bits/stdc++.h>

using namespace std;

int solution(int n, vector<int> stations, int w) {
    int cover = 2 * w + 1;
    int result = 0;
    
    // 좌측 끝 처리
    int left = stations[0] - 1 - w;
    if (left > 0) result += ceil((double)left / cover);
    
    // 중간 구간 처리
    int start = stations[0];
    for (size_t i = 1; i < stations.size(); ++i) {
        int end = stations[i];
        int mid = end - start - cover;
        if (mid > 0) result += ceil((double)mid / cover);
        
        start = end;
    }
    
    // 우측 끝 처리
    int right = n - stations.back() - w;
    if (right > 0) result += ceil((double)right / cover);
    
    return result;
}