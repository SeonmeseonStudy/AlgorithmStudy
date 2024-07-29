def solution(phone_book):
    phone_book.sort()
    answer = True
    
    while(answer == True and len(phone_book) > 0):
        phone = phone_book.pop(0)
        n = len(phone)
        for j in phone_book:
            if phone == j[:n]:
                answer = False
                break
                
    return answer

## 효율성 3,4번 시간 초과가 난다..>!!

phone_book =["456","789","123"]
print(solution(phone_book))