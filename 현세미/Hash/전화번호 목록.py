def solution(phone_book):
    phone_list = {}

    for number in phone_book:
        phone_list[number] = True
    
    for number in phone_book:
        for i in range(1, len(number)):
            prefix = number[:i]
            if prefix in phone_list:
                return False
    
    return True
