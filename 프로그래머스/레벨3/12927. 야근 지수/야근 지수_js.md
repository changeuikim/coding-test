# [Lv.3] [야근 지수](https://school.programmers.co.kr/learn/courses/30/lessons/12927?language=javascript) - 12927 

### 구분

코딩테스트 연습 > 연습문제

## JavaScript 문제풀이

```js
class MaxHeap {
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
        
        const maxValue = this.heap[0];
        this.heap[0] = this.heap.pop();
        this._bubbleDown(0);
        return maxValue;
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
            if (this.heap[parentIndex] >= this.heap[index]) break;
            
            [this.heap[parentIndex], this.heap[index]] = [this.heap[index], this.heap[parentIndex]];
            index = parentIndex;
        }
    }
    
    _bubbleDown(index) {
        while (true) {
            let maxIndex = index;
            const leftChildIndex = 2 * index + 1;
            const rightChildIndex = 2 * index + 2;
            
            if (leftChildIndex < this.heap.length && this.heap[leftChildIndex] > this.heap[maxIndex]) {
                maxIndex = leftChildIndex;
            }
            
            if (rightChildIndex < this.heap.length && this.heap[rightChildIndex] > this.heap[maxIndex]) {
                maxIndex = rightChildIndex;
            }
            
            if (maxIndex === index) break;
            
            [this.heap[maxIndex], this.heap[index]] = [this.heap[index], this.heap[maxIndex]];
            index = maxIndex;
        }
    }
}

function solution(n, works) {
    const totalWorks = works.reduce((a, b) => a + b, 0);
    if (totalWorks <= n) {
        return 0;
    }
    
    // 최대힙
    const maxHeap = new MaxHeap(works);
    
    // heappushpop
    while (n--) {
        let maxWork = maxHeap.heappop();
        if (maxWork === 0) {
            break;
        }
        maxHeap.heappush(maxWork - 1);
    }
    
    // 최종 결과
    let result = 0;
    while (maxHeap.size() > 0) {
        let work = maxHeap.heappop();
        result += work * work;
    }
    
    return result;
}
```

### 성능 요약

1. 시간: 134.13 ms, 메모리: 39.1 MB

2. 시간: 97.32 ms, 메모리: 38.9 MB
3. 시간: 5.69 ms, 메모리: 37.3 MB
4. 시간: 3.92 ms, 메모리: 37.1 MB
5. 시간: 0.68 ms, 메모리: 33.5 MB

### 제출 일자

2024년 11월 21일 (목) 23:46

> 출처: 프로그래머스 코딩 테스트 연습, https://school.programmers.co.kr/learn/challenges