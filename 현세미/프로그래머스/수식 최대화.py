#프로그래머스 - 수식 최대화
#순열
from itertools import permutations
import re

def solution(expression):
    operands = list(map(int, re.split(r'[+\-*]', expression)))
    operators = re.findall(r'[+\-*]', expression)
    
    operator_priority = list(permutations(set(operators)))
    
    def calculate(operands, operators, priority):
        for op in priority:
            while op in operators:
                idx = operators.index(op)
                left = operands.pop(idx)
                right = operands.pop(idx)
                operators.pop(idx)
                if op == '+':
                    operands.insert(idx, left + right)
                elif op == '-':
                    operands.insert(idx, left - right)
                elif op == '*':
                    operands.insert(idx, left * right)
        return abs(operands[0])

    answer = 0
    for priority in operator_priority:
        result = calculate(operands[:], operators[:], priority)  
        answer = max(answer, result)
    
    return answer
