def solution(phone_book):
    phone_dict = {}

    for phone in phone_book:
        phone_dict[phone] = 1
    
    for phone in phone_book:
        x = ""
        for char in phone:
            x += char
            if x in phone_dict and x != phone:
                return False
    
    return True