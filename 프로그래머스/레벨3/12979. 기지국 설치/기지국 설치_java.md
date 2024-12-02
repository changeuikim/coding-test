# [Lv.3] [기지국 설치](https://programmers.co.kr/) - 12979 

### 구분

코딩테스트 연습 > Summer／Winter Coding（～2018）

## Java 문제풀이

```java
class Solution {
    public int solution(int n, int[] stations, int w) {
        int cover = 2 * w + 1;
        int result = 0;
        
        // 좌측 끝 처리
        int left = stations[0] - 1 - w;
        if (left > 0) result += Math.ceil((double)left / cover);
        
        // 중간 구간 처리
        int start = stations[0];
        for (int i = 1; i < stations.length; i++) {
            int end = stations[i];
            int mid = end - start - cover;
            if (mid > 0) result += Math.ceil((double)mid / cover);
            
            start = end;
        }
        
        // 우측 끝 처리
        int right = n - stations[stations.length - 1] - w;
        if (right > 0) result += Math.ceil((double)right / cover);
        
        return result;
    }
}
```

### 성능 요약

1. 시간: 2.69 ms, 메모리: 55.1 MB

2. 시간: 1.34 ms, 메모리: 54.4 MB
3. 시간: 1.30 ms, 메모리: 55 MB
4. 시간: 1.22 ms, 메모리: 55 MB
5. 시간: 0.81 ms, 메모리: 72.7 MB

### 제출 일자

2024년 12월 02일 (월) 23:50

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges