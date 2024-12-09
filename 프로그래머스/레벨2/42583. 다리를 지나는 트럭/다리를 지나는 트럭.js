function solution(bridge_length, weight, truck_weights) {
    const bridge = Array(bridge_length).fill(0);
    let totalWeight = 0;
    let time = 0;

    for (let truck of truck_weights) {
        while (true) {
            time++;
            totalWeight -= bridge.shift();

            if (totalWeight + truck <= weight) {
                bridge.push(truck);
                totalWeight += truck;
                break;
            } else {
                bridge.push(0);
            }
        }
    }

    return time + bridge_length;
}