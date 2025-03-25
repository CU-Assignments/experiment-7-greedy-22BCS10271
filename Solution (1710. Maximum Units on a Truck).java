import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        int totalStones = 0;
        
        for (int pile : piles) {
            maxHeap.add(pile);
            totalStones += pile;
        }
        
        while (k-- > 0) {
            int maxPile = maxHeap.poll();
            int removedStones = maxPile / 2;
            totalStones -= removedStones;
            maxHeap.add(maxPile - removedStones);
        }
        
        return totalStones;
    }
}