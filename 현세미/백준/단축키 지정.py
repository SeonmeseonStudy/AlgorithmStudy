n = int(input().strip())
options = [input().strip() for _ in range(n)]
used_shortcuts = set()  #이미 단축키인 알파벳

for option in options:
    words = option.split()
    assigned = False

    #첫단어 단축키 지정
    for i in range(len(words)):
        key = words[i][0].lower()
        if key not in used_shortcuts:
            used_shortcuts.add(key)
            words[i] = f"[{words[i][0]}]{words[i][1:]}"
            assigned = True
            break
    # 첫단어 단축키 아닌 경우
    if not assigned:
        for i in range(len(words)):
            for j in range(len(words[i])):
                key = words[i][j].lower()
                if key not in used_shortcuts:
                    used_shortcuts.add(key)
                    words[i] = words[i][:j] + f"[{words[i][j]}]" + words[i][j+1:]
                    assigned = True
                    break
            if assigned:
                break

    print(" ".join(words))
