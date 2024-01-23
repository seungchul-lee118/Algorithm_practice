N = int(input())
numbers = [int(input()) for _ in range(N)]

plus_numbers = sorted(list(filter(lambda x:x > 1, numbers)))
minus_numbers = sorted(list(filter(lambda x:x < 1, numbers)), reverse=True)
ones_of_numbers = list(filter(lambda x: x == 1, numbers))
sum_numbers = 0

while plus_numbers:
    if len(plus_numbers) > 1:
        num1 = plus_numbers.pop()
        num2 = plus_numbers.pop()
        sum_numbers += max(num1 * num2, num1 + num2)
    else:
        sum_numbers += plus_numbers.pop()

while minus_numbers:
    if len(minus_numbers) > 1:
        num1 = minus_numbers.pop()
        num2 = minus_numbers.pop()
        sum_numbers += max(num1 * num2, num1 + num2)
    else:
        sum_numbers += minus_numbers.pop()
            
sum_numbers += len(ones_of_numbers)
print(sum_numbers)