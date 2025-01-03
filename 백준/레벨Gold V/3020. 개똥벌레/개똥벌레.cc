#include <bits/stdc++.h>
using namespace std;

/*
  N = 2 * 10^5, H = 5 * 10^5, 최대 10^11
  일반적인 2차원 배열로는 O(N^2)를 못쓴다
 */

void difference() {
    int N, H;
    cin >> N >> H;
    vector<int> height(H, 0);

    // 너비 압축
    for (int i = 0; i < N; i++) {
        int t;
        cin >> t;

        // 짝수 : 석순, 홀수 : 종유석
        if (i % 2 == 0) {
            // 석순 : H-t 이전은 0 이후는 1
            height[H - t]++;
        } else {
            // 종유석 : t 이전은 1 이후는 0
            height[0]++;
            height[t]--;
        }
    }

    // 누적 합
    for (int i = 1; i < H; i++) {
        height[i] += height[i - 1];
    }

    // 최소값 및 빈도
    int minVal = *min_element(height.begin(), height.end());
    int minCnt = count(height.begin(), height.end(), minVal);

    cout << minVal << " " << minCnt;
}

int main(void) {
    ios::sync_with_stdio(0);
    cin.tie(0);
    difference();
}