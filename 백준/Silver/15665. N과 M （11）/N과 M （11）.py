import sys

def back_track(numbers, n, m, result=[]):
    len_of_list = len(result)
    if len_of_list == m:
        print(*result)
        return
    for i in range(len(numbers)):
        result.append(numbers[i])
        back_track(numbers, n, m, result)
        result.pop()


input = sys.stdin.readline

n, m = map(int, input().split(' '))
numbers = list(map(int, input().split(' ')))
sorted_numbers = sorted(list(set(numbers)))
back_track(sorted_numbers, n, m)