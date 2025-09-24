class UnionFind {
    constructor(size) {
        // parent 배열을 초기화하여 각 원소가 자기 자신을 부모로 가지도록 설정
        this.parent = Array.from({ length: size + 1 }, (_, i) => i);
    }

    // 원소 x가 속한 집합의 대표자를 찾는 함수 (경로 압축 사용)
    find(x) {
        if (this.parent[x] === x) {
            return x; // x가 자신의 대표자이면 그대로 반환
        }
        // 경로 압축: x의 부모를 재귀적으로 찾아, 루트에 바로 연결되도록 함
        return this.parent[x] = this.find(this.parent[x]);
    }

    // 두 집합을 하나로 합치는 함수
    union(x, y) {
        const rootX = this.find(x); // x의 대표자를 찾음
        const rootY = this.find(y); // y의 대표자를 찾음
        if (rootX !== rootY) {
            this.parent[rootX] = rootY; // 두 집합을 합침 (y를 x에 연결)
        }
    }
}

function solution(G, P, planes) {
    const uf = new UnionFind(G); // G개의 게이트를 가진 Union-Find 생성
    let count = 0; // 도킹된 비행기 수를 카운트

    for (let i = 0; i < P; i++) {
        const gate = planes[i]; // i번째 비행기의 가능한 게이트 번호
        const availableGate = uf.find(gate); // 도킹 가능한 가장 큰 번호의 게이트 찾기

        if (availableGate === 0) break; // 더 이상 도킹할 수 있는 게이트가 없으면 중지

        uf.union(availableGate, availableGate - 1); // 도킹하고 다음 작은 번호로 업데이트
        count++; // 도킹된 비행기 수 증가
    }

    return count; // 최대 도킹 가능한 비행기 수 반환
}

// 입력 처리
const input = require('fs').readFileSync('dev/stdin').toString().trim().split('\n');
const G = parseInt(input[0], 10); // 게이트의 수
const P = parseInt(input[1], 10); // 비행기의 수
const planes = input.slice(2).map(Number); // 각 비행기의 게이트 번호 목록

console.log(solution(G, P, planes)); // 결과 출력