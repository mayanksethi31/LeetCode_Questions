class Solution {
    public int lastStoneWeight(int[] stones) {
    int k;
    PriorityQueue<Integer> stone_heap = new PriorityQueue<Integer>();
    for (int i: stones)
    {
        stone_heap.offer(i*(-1));
    }
    
    while (stone_heap.size()>1)
    {   
        int y = stone_heap.poll();
        int x = stone_heap.poll();
        if (x!=y)
        {
            stone_heap.offer(y-x);
        }
    }

    if (stone_heap.size()==1)
    {
        return (-1)*stone_heap.poll();
    }
    return 0;

    }
}