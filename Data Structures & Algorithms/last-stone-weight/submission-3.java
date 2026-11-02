class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i : stones) queue.offer(i);
        
        while(queue.size() > 1) {
            int y = queue.poll();
            
            int x = queue.poll();

            if(x < y) queue.offer(y-x);
        }

        return queue.size() >= 1 ? queue.poll() : 0;
    }
}
