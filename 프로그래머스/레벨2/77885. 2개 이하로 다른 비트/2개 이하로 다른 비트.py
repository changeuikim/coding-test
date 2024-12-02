def solution(numbers):
    result = []
    
    for num in numbers:
        # 첫번째 0은 1로, 뒤는 모두 0
        bigger_num = num + 1
        
        # 첫번째 0 이전은 0, 뒤는 모두 1
        bit_diff = (num ^ (num + 1))
        
        # 우측 시프트 시에 첫번째 01을 10으로 바꾸는 효과
        min_num = bigger_num + (bit_diff >> 2)
        
        result.append(min_num)
        
    return result