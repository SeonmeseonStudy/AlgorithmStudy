function solution(name) {
    let nums = name.split("").map(i => i.charCodeAt() - 65);
    // 알파벳 변경 cost
    let numControl = nums.reduce((prev, next) => prev + Math.min(next, 26 - next), 0);
    
    // 이동 cost
    let move = name.length - 1;
 
    for(let i = 0; i<name.length; i++) {
        let index = i + 1; // 다음 값들을 확인할때 사용
        let length = name.length
            
        // 연속된 A 개수 확인 - 이 다음에 A가 없으면 index = i + 1
        while(index < length && name.charAt(index) === "A"){
            index++;
        }
        // length - index -> 연속된 A 이후 다른 알파벳의 개수
        // i * 2 + length - index -> i까지 변경 후 다시 0으로 돌아간 뒤, 뒷 부분 변경
        // (length - index) * 2 + i -> 뒷 부분 변경 후 0으로 돌아간 뒤, i까지 변경
        move = Math.min(move, i*2 + length - index, (length - index) * 2 + i);
    }
    
    return move + numControl
}