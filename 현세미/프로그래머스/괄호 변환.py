#올바른 문자열인지 체크
def is_correct(s):
    stack = []
    for char in s:
        if char == '(':
            stack.append(char)
        elif char == ')':
            if not stack:
                return False
            stack.pop()
    return len(stack) == 0

def solution(p):
    # 빈문자열 반환
    if not p:
        return ""
    
    def split_uv(s):
        balance = 0
        for i in range(len(s)):
            if s[i] == '(':
                balance += 1
            else:
                balance -= 1
            if balance == 0:
                return s[:i+1], s[i+1:]
    
    u, v = split_uv(p)
    
    if is_correct(u):
        return u + solution(v)
    else:
        # 새로운 문자열 생성
        return '(' + solution(v) + ')' + ''.join('(' if x == ')' else ')' for x in u[1:-1])
