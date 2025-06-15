import sys
input = sys.stdin.readline

num_keywords, num_articles = map(int, input().split())

notepad = set()
for _ in range(num_keywords):
    notepad.add(input().strip())

for _ in range(num_articles):
    used_keywords = input().strip().split(',')
    for keyword in used_keywords:
        notepad.discard(keyword)
    print(len(notepad))
