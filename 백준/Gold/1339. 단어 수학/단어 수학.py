import sys

input = sys.stdin.readline

n = int(input())
num = [i for i in range(0, 10)]
words = [list(input().strip()) for _ in range(n)]
words_dict = {}
result = 0

for word in words:
    for i in range(len(word)):
        if word[i] in words_dict:
            words_dict[word[i]] += 10 ** (len(word) - i - 1)
        else:
            words_dict[word[i]] = 10 ** (len(word) - i - 1)
sorted_result = sorted(words_dict.values(), reverse=True)

for i in sorted_result:
    result += i * num.pop()
print(result)