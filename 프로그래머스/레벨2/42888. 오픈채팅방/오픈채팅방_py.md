# [Lv.2] [오픈채팅방](https://school.programmers.co.kr/learn/courses/30/lessons/42888?language=python3) - 42888 

### 구분

코딩테스트 연습 > 2019 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def solution(record):    
    user_names = {}
    actions = []
    messages = { "Enter" : "님이 들어왔습니다.", "Leave" : "님이 나갔습니다."}
    result = []
    
    for event in record:
        parts = event.split()
        
        action, user_id = parts[0], parts[1]
        
        if action == "Enter" or action == "Change":
            nickname = parts[2]
            user_names[user_id] = nickname
            
        if action == "Enter" or action == "Leave":
            actions.append((user_id, messages[action]))
    
    return [f"{user_names[user_id]}{message}" for user_id, message in actions]
```

### 성능 요약

1. 시간: 117.87 ms, 메모리: 51.8 MB

2. 시간: 117.70 ms, 메모리: 57 MB
3. 시간: 92.69 ms, 메모리: 57.2 MB
4. 시간: 90.99 ms, 메모리: 54.8 MB
5. 시간: 81.65 ms, 메모리: 46.9 MB

### 제출 일자

2024년 11월 25일 (월) 23:56

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges