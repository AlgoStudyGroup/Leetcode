public class Solution {
    public int[] FindOrder(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) return new int[0];
        
        var indegree = new int[numCourses];
        for(int i=0; i<prerequisites.Length; i++){
            indegree[prerequisites[i][0]]++;
        }
        
        var order = new int[numCourses];
        var index = 0;
        Queue<int> queue = new Queue<int>();
        for(int i=0; i<numCourses; i++){
            if(indegree[i] == 0){
                order[index++] = i;
                queue.Enqueue(i);
            }
        }
        
        while(queue.Count > 0){
            var prerequi = queue.Dequeue();
            for(int i=0; i<prerequisites.Length; i++){
                if(prerequisites[i][1] == prerequi){
                    indegree[prerequisites[i][0]]--;
                    if(indegree[prerequisites[i][0]] == 0){
                        order[index++] = prerequisites[i][0];
                        queue.Enqueue(prerequisites[i][0]);
                    }    
                }
            }
        }
        
        return (index == numCourses) ? order : new int[0];
    }
}
