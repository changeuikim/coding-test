function solution(n, stations, w) {
    const cover = 2 * w + 1;
    let result = 0;
    
    // 좌측 끝 처리
    const left = stations[0] - w -1
    if (left > 0) result += Math.ceil(left / cover);
    
    // 중간 구간 처리
    let start = stations[0];
    for (let i = 1; i < stations.length; i++) {
        let end = stations[i];
        let mid = end - start - cover;
        if (mid > 0) result += Math.ceil(mid / cover);
        
        start = end;
    }
    
    // 우측 끝 처리
    const right = n - stations[stations.length - 1] - w;
    if (right > 0) result += Math.ceil(right / cover);
    
    return result;
}