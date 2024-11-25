def solution(s):
    def compress(s, unit):
        compressed = ''
        count = 1
        for i in range(0, len(s) - unit, unit):
            if s[i:i+unit] == s[i+unit:i+2*unit]:
                count += 1
            else:
                if count > 1:
                    compressed += str(count)
                compressed += s[i:i+unit]
                count = 1
        if count > 1:
            compressed += str(count)
        compressed += s[-unit:]
        return len(compressed)

    min_length = len(s)
    for unit in range(1, len(s) // 2 + 1):
        min_length = min(min_length, compress(s, unit))

    return min_length