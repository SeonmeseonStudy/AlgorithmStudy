function solution(numbers, target) {
    // 재귀
    return getCount(numbers, target);
}

const getCount = (numbers, target) => {
    // numbers가 하나 남았을 때 확인
    if (numbers.length === 1) {
        // target이 1, -1이면 1로 만들 수 있음
        if (numbers[0] === Math.abs(target)) return 1;
        return 0;
    }
    
    let newNumbers = numbers.slice(1); // 맨 앞 number 제외
    let num = numbers[0];
    return getCount(newNumbers, target - num) + getCount(newNumbers, target + num);
}