from itertools import permutations

# def solution(numbers):
#     numbers = list(map(str, numbers))
    
#     arr = permutations(numbers)
#     arr = [''.join(p) for p in arr]
    
#     arr.sort()
#     answer=arr[-1]
    
#     return answer

def solution(numbers):

    numbers = list(map(str, numbers))
    numbers.sort(key=lambda x: x*3, reverse=True)
    answer = ''.join(numbers)
    
    return str(int(answer))