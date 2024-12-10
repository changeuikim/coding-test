# [Lv.2] [[3차] 방금그곡](https://programmers.co.kr/) - 17683 

### 구분

코딩테스트 연습 > 2018 KAKAO BLIND RECRUITMENT

## Python 문제풀이

```py
def note_converter(melody):
    result = []
    for note in melody:
        if note != "#":
            result.append(note)
        else:
            result[-1] = result[-1].lower()
    return "".join(result)

def minute_converter(time_string):
    hour, minute = time_string.split(":")
    return 60 * int(hour) + int(minute)

def melody_repeater(melody, play_time):
    return (melody * (play_time // len(melody) + 1))[:play_time]

def solution(m, musicinfos):
    conv_m = note_converter(m)
    result_title = "(None)"
    result_time = 0
    
    for musicinfo in musicinfos:
        start, end, title, melody = musicinfo.split(",")
        play_time = minute_converter(end) - minute_converter(start)
        conv_melody = note_converter(melody)
        repeated_melody = melody_repeater(conv_melody, play_time)
        
        if conv_m in repeated_melody and play_time > result_time:
            result_title = title
            result_time = play_time
            
    return result_title
```

### 성능 요약

1. 시간: 3.53 ms, 메모리: 10.3 MB

2. 시간: 3.28 ms, 메모리: 10.4 MB
3. 시간: 0.24 ms, 메모리: 10.4 MB
4. 시간: 0.22 ms, 메모리: 10.4 MB
5. 시간: 0.12 ms, 메모리: 10.3 MB

### 제출 일자

2024년 12월 10일 (화) 17:41

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges