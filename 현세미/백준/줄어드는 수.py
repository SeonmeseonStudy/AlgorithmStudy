def get_numbers():
    nums = []

    def make_num(num, last):
        nums.append(num)
        for i in range(last):
            make_num(num * 10 + i, i)

    for i in range(10):
        make_num(i, i)

    return sorted(nums)

def find_nth(N):
    nums = get_numbers()

    if N <= len(nums): 
        return nums[N - 1]  
    else:
        return -1  

N = int(input()) 
print(find_nth(N)) 
