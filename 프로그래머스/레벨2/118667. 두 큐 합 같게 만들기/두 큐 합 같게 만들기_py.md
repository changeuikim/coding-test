# [Lv.2] [두 큐 합 같게 만들기](https://programmers.co.kr/) - 118667 

### 구분

코딩테스트 연습 > 2022 KAKAO TECH INTERNSHIP

## Python 문제풀이

```py
def solution(queue1, queue2):
    # 빠른 반환 : 합이 홀수
    q1_sum = sum(queue1)
    total_sum = q1_sum + sum(queue2)
    if total_sum & 1:
        return -1

    # 종료 조건 : 현재 합이 전체 합의 절반
    target_sum = total_sum >> 1
    current_sum = q1_sum

    # 원형 큐 : 두 큐를 결합    
    n = len(queue1)
    size = 2 * n
    q = queue1 + queue2

    # 투 포인터 : i나 j가 한바퀴를 돌면 종료
    cnt, i, j = 0, 0, n - 1
    while i < size and j < size:
        if current_sum == target_sum:
            return cnt

        if current_sum > target_sum:
            current_sum -= q[i % size]
            i += 1
        else:
            j += 1
            current_sum += q[j % size]

        cnt += 1

    return -1
```

### 성능 요약

1. 시간: 58.29 ms, 메모리: 37.6 MB

2. 시간: 50.08 ms, 메모리: 37.4 MB
3. 시간: 39.95 ms, 메모리: 19 MB
4. 시간: 38.95 ms, 메모리: 19 MB
5. 시간: 37.80 ms, 메모리: 37.5 MB

### 제출 일자

2024년 12월 06일 (금) 20:03

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges