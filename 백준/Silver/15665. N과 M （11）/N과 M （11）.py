import sys

def back_track(numbers, n, m, result=[]):
    len_of_list = len(result)
    if len_of_list == m:
        print(*result)
        return
    for i in range(len(numbers)):
        if i != 0 and numbers[i] == numbers[i-1]:
            continue
        result.append(numbers[i])
        back_track(numbers, n, m, result)
        numbers.sort()
        result.pop()


input = sys.stdin.readline

n, m = map(int, input().split(' '))
numbers = list(map(int, input().split(' ')))
numbers.sort()
back_track(numbers, n, m)