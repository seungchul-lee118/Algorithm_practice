N = int(input().strip())
flowers = [list(map(int, input().split())) for _ in range(N)]
mapped_list = list(map(lambda x: (x[0] * 100 + x[1], x[2] * 100 + x[3]), flowers))
new_list = sorted(mapped_list, key=lambda x: (-x[1]))

result = []

for flower in new_list:
    if len(result) == 0:
        result.append(flower)
        continue
    if result[-1][0] <= 301:
        break

    if result[-1][1] > 1130 and flower[1] > 1130:
        if flower[0] < result[-1][0]:
            result[-1] = flower
    elif flower[0] < result[-1][0]:
        if len(result) == 1:
            if flower[1] >= result[-1][0]:
                result.append(flower)
        elif flower[0] < result[-2][0] <= flower[1]:
            result[-1] = flower
        else:
            result.append(flower)

print(len(result) if result[0][1] > 1130 and result[-1][0] <= 301 else 0)