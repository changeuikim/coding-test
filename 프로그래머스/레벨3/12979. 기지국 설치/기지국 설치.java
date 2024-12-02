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