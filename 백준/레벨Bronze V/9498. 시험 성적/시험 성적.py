score = int(input())
result = ""

if 90 <= score <= 100:
    result = "A"
elif 80 <= score:
    result = "B"
elif 70 <= score:
    result = "C"
elif 60 <= score:
    result = "D"
else:
    result = "F"

print(result)