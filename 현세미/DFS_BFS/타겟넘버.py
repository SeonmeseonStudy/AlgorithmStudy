def solution(numbers, target):
    def dfs(position, total):
  
        if position == len(numbers):
            return 1 if total == target else 0
        
        plus = dfs(position + 1, total + numbers[position])
        minus = dfs(position + 1, total - numbers[position])
        

        return plus + minus

    return dfs(0, 0)