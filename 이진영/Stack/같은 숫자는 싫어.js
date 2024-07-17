function solution(arr)
{
    let s = [];
    for (let num of arr) {
        if (s.length === 0 || s[s.length - 1] !== num)
            s.push(num)
    }
    return s;
}