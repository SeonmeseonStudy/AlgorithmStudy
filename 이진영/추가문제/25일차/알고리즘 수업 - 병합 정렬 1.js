let input = require('fs').readFileSync('dev/stdin')
        .toString().trim().split("\n").map(i => i.trim());

let [n, k]= input[0].split(" ").map(Number);
let arr = input[1].split(" ").map(Number);

let answer = -1;

const mergeSort = (arr, p, r) => {
    if (p < r) {
        const q = Math.floor((p + r) / 2);
        mergeSort(arr, p, q);
        mergeSort(arr, q + 1, r);
        merge(arr, p, q, r);
    }
}

const merge = (arr, p, q, r) => {
    let i = p;
    let j = q + 1;
    let t = 0;
    let tmp = [];

    while (i <= q && j <= r) {
        if (arr[i] <= arr[j]) {
            tmp[t++] = arr[i++];
        } else {
            tmp[t++] = arr[j++];
        }
    }

    while (i <= q) {
        tmp[t++] = arr[i++];
    }

    while (j <= r) {
        tmp[t++] = arr[j++];
    }

    i = p;
    t = 0;

    while (i <= r) {
        if (--k === 0) {
            answer = tmp[t];
        }
        arr[i++] = tmp[t++];
    }
}

mergeSort(arr, 0, n - 1);
k > 0 ? console.log(-1) : console.log(answer);