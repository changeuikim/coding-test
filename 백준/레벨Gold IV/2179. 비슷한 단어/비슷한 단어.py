from sys import stdin

def solution():    
    read = stdin.read().splitlines()
    
    N = int(read[0].rstrip())
    
    # 사전 순 정렬
    words = [[read[i], i] for i in range(1, len(read))]
    words.sort(key=lambda x: x[0])

    # 인접 글자 간 LCP 처리
    max_len = 0
    result = set()
    for i in range(len(words) - 1):
        pre, pre_idx = words[i]
        nxt, nxt_idx = words[i + 1]
        size = min(len(pre), len(nxt))

        # LCP 길이 확인
        cur_len = 0
        for j in range(size):
            if pre[j] == nxt[j]:
                cur_len += 1
            else:
                break
        
        # LCP 갱신
        if max_len < cur_len:
            lcp = pre[:cur_len]
            max_len = cur_len
            result = {(pre_idx, lcp), (nxt_idx, lcp)}
        elif max_len == cur_len:
            lcp = pre[:cur_len]
            result.add((pre_idx, lcp))
            result.add((nxt_idx, lcp))

    # 여러 개일 때에는 입력되는 순서대로
    idx_list = sorted(result)
    idx1, common = idx_list[0]

    idx2 = -1
    for i in range(1, len(idx_list)):
        if idx_list[i][1] == common:
            idx2 = idx_list[i][0]
            break

    print(read[idx1])
    print(read[idx2])

solution()