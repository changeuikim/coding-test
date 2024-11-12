# [Lv.3] [이중우선순위큐](https://school.programmers.co.kr/learn/courses/30/lessons/42628?language=javascript) - 42628 

### 구분

코딩테스트 연습 > 힙（Heap）

## JavaScript 문제풀이

```js
/**
최소 힙
- 완전 이진 트리를 기반으로 구현
- 모든 부모 노드는 자식 노드보다 작은 값을 가진다
**/
class MinHeap {
    constructor() {
        this.heap = [];
    }
    
    size() {
        return this.heap.length;
    }
    
    peek() {
        return this.heap[0];
    }
    
    /**
    heappush 함수 : O(log n)
    1. 배열 마지막에 값을 추가한다
    2. 추가된 값을 부모 노드와 비교해가며 올바른 위치로 이동한다.
    **/
    heappush(value) {
        this.heap.push(value);
        this._bubbleUp(this.heap.length - 1);
    }
    
    /**
    heappop 함수 : O(log n)
    1. 루트 요소를 최소값으로 저장한다.
    2. 마지막 요소를 팝해서 루트 요소로 이동한다.
    3. 새로운 루트 요소를 자식 노드와 비교해가며 올바른 위치로 이동한다.
    4. 저장한 최소값을 반환한다.
    **/
    heappop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        
        const minValue = this.heap[0];
        this.heap[0] = this.heap.pop();
        this._bubbleDown(0);
        return minValue;
    }
    
    /**
    인덱스를 기준으로 현재 노드를 부모 노드와 비교해가며 올바른 위치로 이동한다.
    1. 완전 이진 트리의 부모 노드의 인덱스는 (idx - 1) / 2를 내림한 값이다.
    2. 부모 노드가 현재 노드보다 작거나 같으면 루프를 종료한다.
    3. 루프 안에서 부모 노드와 현재 노드의 값과 위치를 교체한다.
    **/
    _bubbleUp(index) {
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[parentIndex] <= this.heap[index]) break;
            
            [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
            index = parentIndex;
        }
    }
    
    /**
    인덱스를 기준으로 특정 노드를 자식 노드와 비교해가며 올바른 위치로 이동한다.
    1. 현재 노드의 위치를 minIndex에 할당한다.
    2. 완전 이진 트리의 왼쪽 자식 노드의 인덱스는 2 * idx + 1이다.
    3. 완전 이진 트리의 오른쪽 자식 노드의 인덱스는 2 * idx + 2이다.
    4. 현재 노드, 왼쪽 자식 노드, 오른쪽 자식 노드 중 가장 작은 값의 위치를 minIndex에 할당한다.
    5. 현재 노드가 가장 작은 노드라면 루프를 중단한다.
    6. 루프 안에서 가장 작은 자식 노드와 현재 노드의 값과 위치를 교체한다.
    **/
    _bubbleDown(index) {
        while (true) {
            let minIndex = index;
            const leftChildIndex = 2 * index + 1;
            const rightChildIndex = 2 * index + 2;
            
            if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] < this.heap[minIndex]) {
                minIndex = leftChildIndex;
            }
            
            if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] < this.heap[minIndex]) {
                minIndex = rightChildIndex;
            }
            
            if (minIndex === index) break;
            
            [this.heap[index], this.heap[minIndex]] = [this.heap[minIndex], this.heap[index]];
            index = minIndex;
        }
    }
}

/**
카운터에 없는 유효하지 않은 값을 힙에서 제거하는 함수
**/
const removeInvalid = (heap, counter, isMaxHeap = false) => {
    while (heap.size() && !counter.get(isMaxHeap ? - heap.peek() : heap.peek())) {
        heap.heappop();
    }
}

function solution(operations) {
    // 최소힙, 최대힙, 값 카운터
    const minHeap = new MinHeap();
    const maxHeap = new MinHeap();
    const counter = new Map();
    
    for (let element of operations) {
        const [op, value] = element.split(" ");
        const val = parseInt(value);
        
        // 큐에 주어진 숫자를 삽입합니다.
        if (op === "I") {
            minHeap.heappush(val);
            maxHeap.heappush(-val);
            counter.set(val, (counter.get(val) || 0) + 1);
        } else if (op === "D") {
            // 큐에서 최댓값을 삭제합니다.
            if (val === 1) {
                removeInvalid(maxHeap, counter, true);
                if (maxHeap.size()) {
                    const maxVal = -maxHeap.heappop();
                    counter.set(maxVal, counter.get(maxVal) - 1);
                }
            }
            // 큐에서 최솟값을 삭제합니다.
            else if (val === -1) {
                removeInvalid(minHeap, counter);
                if (minHeap.size()) {
                    const minVal = minHeap.heappop();
                    counter.set(minVal, counter.get(minVal) - 1);
                }
            }
        }        
    }
    
    // 잔여 카운터를 처리합니다.
    removeInvalid(maxHeap, counter, true);
    removeInvalid(minHeap, counter);
    
    // 결과 반환
    if (minHeap.size() && maxHeap.size()) {
        return [-maxHeap.peek(), minHeap.peek()];
    } else {
        return [0, 0];
    }
}
```

### 성능 요약

1. 시간: 100.10 ms, 메모리: 54.6 MB

2. 시간: 0.57 ms, 메모리: 33.4 MB
3. 시간: 0.55 ms, 메모리: 33.5 MB
4. 시간: 0.51 ms, 메모리: 33.4 MB
5. 시간: 0.36 ms, 메모리: 33.4 MB

### 제출 일자

2024년 11월 12일 (화) 23:25

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges