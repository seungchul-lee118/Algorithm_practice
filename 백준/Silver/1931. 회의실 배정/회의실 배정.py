N = int(input())
times = [tuple(map(int, input().split())) for _ in range(N)]

end_time = 0
count = 0
times.sort(key=lambda x: (x[1], x[0]))

for time in times:
    if time[0] >= end_time:
        end_time = time[1]
        count += 1
            
print(count)