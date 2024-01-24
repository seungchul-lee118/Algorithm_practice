N = int(input().strip())
array = list(map(int, input().strip().split()))
sorted_array = sorted(array.copy())

for idx in range(1, N):
    sorted_array[idx] += sorted_array[idx - 1]

print(sum(sorted_array))