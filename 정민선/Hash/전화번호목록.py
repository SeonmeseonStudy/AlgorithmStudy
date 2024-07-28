def solution(phone_book):
    answer = True
    last = phone_book[-1]
    
    while(answer == True and last != phone_book[0]):
        phone = phone_book.pop(0)
        n = len(phone)
        for j in phone_book:
            if phone == j[:n]:
                answer = False
                break
                
        phone_book.append(phone)
    return answer

## 효율성 3,4번 시간 초과가 난다..>!!

phone_book =["123","456","789"]
print(solution(phone_book))