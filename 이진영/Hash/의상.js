function solution(clothes) {
    // hashmap에 의상 종류 - 의상 이름 배열 정리
    let map = new Map();
    for (let cloth of clothes) {
        if (!map.has(cloth[1])) map.set(cloth[1], []);
        map.get(cloth[1]).push(cloth[0]);
    }
    
    // 의상종류 + 1 의 곱 ( 1은 선택하지 않았을 경우 )
    let count = 1;
    for (let [_, value] of map) {
        count *= (value.length + 1);
    }
    
    return count - 1; // 모두 선택하지 않았을 때 제외
}