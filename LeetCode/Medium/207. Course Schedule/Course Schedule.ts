function canFinish(numCourses: number, prerequisites: number[][]): boolean {
  const N = numCourses;
  const graph: number[][] = Array.from({ length: N }, () => []);
  const inDegree: number[] = Array(N).fill(0);

  prerequisites.forEach(([v, u]) => {
    graph[u].push(v);
    inDegree[v]++;
  });

  const q: number[] = [];
  let count = 0;

  for (let i = 0; i < N; i++) {
    if (inDegree[i] == 0) q.push(i);
  }

  while (q.length > 0) {
    const u = q.pop();
    count++;

    for (const v of graph[u]) {
      inDegree[v]--;
      if (inDegree[v] == 0) q.push(v);
    }
  }

  return count == N;
}