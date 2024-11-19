import itertools

def calculate_expression(expression, priorities):
    operators = ['+', '-', '*']

    for operator in priorities:
        parts = expression.split(operator)
        while len(parts) > 1:
            left = int(parts.pop(0))
            right = int(parts.pop(0))
            if operator == '+':
                result = left + right
            elif operator == '-':
                result = left - right
            elif operator == '*':
                result = left * right
            parts.insert(0, str(result))
        expression = parts[0]
    
    return abs(int(expression))  

def solution(expression):
    operators = ['+', '-', '*']
    priorities = list(itertools.permutations(operators))
    
    max_result = 0
    for priority in priorities:
        max_result = max(max_result, calculate_expression(expression, priority))
    
    return max_result