equation = input().strip()
pluses, *minuses = equation.split('-')

sum_of_plus = 0
sum_of_minus = 0

for i in pluses.split('+'):
    sum_of_plus += int(i)
for minus in minuses:
    for j in minus.split('+'):
        sum_of_minus += int(j)

print(sum_of_plus - sum_of_minus)