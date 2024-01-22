def back_track(numbers, n, m, result=[], idx=0):
    len_of_list = len(result)
    if len_of_list == m:
        print(*result)
        return
    for i in range(idx, n - len_of_list):
        if i != 0 and numbers[i] == numbers[i-1]:
            continue
        result.append(numbers[i])
        num = numbers.pop(i)
        back_track(numbers, n, m, result, i)
        numbers.append(num)
        numbers.sort()
        result.pop()
        
n, m = map(int, input().split())
numbers = list(map(int, input().split()))
numbers.sort()
back_track(numbers, n, m)