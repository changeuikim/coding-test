# [Lv.2] [더 맵게](https://school.programmers.co.kr/learn/courses/30/lessons/42626?language=javascript) - 42626 

### 구분

코딩테스트 연습 > 힙（Heap）

## JavaScript 문제풀이

```js
class MinHeap {
    constructor(array = []) {
        this.heap = [];
        if (array.length > 0) {
            this.heapify(array);
        }
    }
    
    size() {
        return this.heap.length;
    }
    
    peek() {
        return this.heap[0];
    }
    
    heappush(value) {
        this.heap.push(value);
        this._bubbleUp(this.heap.length - 1);
    }
    
    heappop() {
        if (this.heap.length === 0) return null;
        if (this.heap.length === 1) return this.heap.pop();
        
        const minValue = this.heap[0];
        this.heap[0] = this.heap.pop();
        this._bubbleDown(0);
        return minValue;
    }
    
    heapify(array) {
        this.heap = array.slice();
        const lastParentIndex = Math.floor((this.heap.length - 2) / 2);

        for (let i = lastParentIndex; i >= 0; i--) {
            this._bubbleDown(i);
        }
    }

    _bubbleUp(index) {
        while (index > 0) {
            const parentIndex = Math.floor((index - 1) / 2);
            if (this.heap[parentIndex] <= this.heap[index]) break;
            
            [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
            index = parentIndex;
        }
    }
    
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

function solution(scoville, K) {
    const heap = new MinHeap(scoville);
    let count = 0;

    while (heap.peek() < K) {
        if (heap.size() < 2) {
            return -1;
        }

        const first = heap.heappop();
        const second = heap.heappop();
        heap.heappush(first + second * 2);
        count++;
    }

    return count;
}
```

### 성능 요약

1. 시간: 568.78 ms, 메모리: 79.5 MB

2. 시간: 555.46 ms, 메모리: 78.1 MB
3. 시간: 160.04 ms, 메모리: 53.9 MB
4. 시간: 90.28 ms, 메모리: 44.1 MB
5. 시간: 72.49 ms, 메모리: 43.5 MB

### 제출 일자

2024년 11월 19일 (화) 23:58

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges