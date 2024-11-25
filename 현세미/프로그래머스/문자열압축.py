def solution(s):
    n = len(s)
    min_length = n
    
    for unit in range(1, n // 2 + 1):
        compressed = ""
        prev = s[:unit]
        count = 1
        
        for i in range(unit, n, unit):
            if s[i:i+unit] == prev:
                count += 1
            else:
                compressed += (str(count) + prev) if count > 1 else prev
                prev = s[i:i+unit]
                count = 1
        
        compressed += (str(count) + prev) if count > 1 else prev
        min_length = min(min_length, len(compressed))
    
    return min_length
