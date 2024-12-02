import math

def solution(n, stations, w):    
    cover = 2 * w + 1
    result = 0
    
    # 좌측 끝 처리
    left = stations[0] - 1 - w
    if left > 0:
        result += math.ceil(left / cover)
    
    # 중간 구간 처리
    start = stations[0]
    for i in range(1, len(stations)):
        end = stations[i]
        mid = end - start - cover
        if mid > 0:
            result += math.ceil(mid / cover)
            
        start = end
            
    # 우측 끝 처리
    right = n - stations[-1] - w
    if right > 0:
        result += math.ceil(right / cover)
    
    return result