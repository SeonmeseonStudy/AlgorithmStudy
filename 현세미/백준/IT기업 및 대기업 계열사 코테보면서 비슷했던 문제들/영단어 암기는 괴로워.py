import sys
input = sys.stdin.readline

N, M = map(int, input().split())
words = [input().rstrip() for _ in range(N)]

words = [word for word in words if len(word) >= M]

freq = {}
for word in words:
    freq[word] = freq.get(word, 0) + 1

unique_words = list(freq.keys())

#리스트를 제자리에서 정렬해주는 함수
unique_words.sort(key=lambda x: (-freq[x], -len(x), x))

print('\n'.join(unique_words))
