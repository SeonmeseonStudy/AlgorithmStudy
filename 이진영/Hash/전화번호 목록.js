function solution(phone_book) {
    let set = new Set(phone_book);
    
    for (let phone of phone_book) {
        for (let i = 0; i < phone.length; i++) {
            if (set.has(phone.slice(0, i))) return false;
        }
    }
    return true;
}