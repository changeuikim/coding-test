year = int(input())

result = (year % 4 == 0 and year % 100 != 0) or year % 400 == 0

print(1 if result else 0)