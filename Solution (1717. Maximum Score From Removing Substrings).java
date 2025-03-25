import java.util.*;

class Solution {
    public int maxTasks(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        
        int left = 0, right = Math.min(tasks.length, workers.length);
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (canComplete(mid, tasks, workers, pills, strength)) {
                left = mid;  
            } else {
                right = mid - 1;  s
            }
        }
        return left;
    }

    private boolean canComplete(int k, int[] tasks, int[] workers, int pills, int strength) {
        LinkedList<Integer> availableWorkers = new LinkedList<>();
        int taskIndex = k - 1, workerIndex = workers.length - 1, usedPills = 0;

        for (int i = workers.length - k; i < workers.length; i++) {
            availableWorkers.add(workers[i]);
        }

        while (taskIndex >= 0) {
            if (!availableWorkers.isEmpty() && availableWorkers.getLast() >= tasks[taskIndex]) {
                availableWorkers.removeLast();
            } else if (usedPills < pills && !availableWorkers.isEmpty() && availableWorkers.getFirst() + strength >= tasks[taskIndex]) {
                availableWorkers.removeFirst();
                usedPills++;
            } else {
                return false;
            }
            taskIndex--;
        }
        return true;
    }
}
