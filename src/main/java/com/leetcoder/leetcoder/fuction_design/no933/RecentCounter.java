package com.leetcoder.leetcoder.fuction_design.no933;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @ Description :
 * @ wiki:
 * @ date: created in 11:26 上午 2022/5/6
 **/
class RecentCounter {
    private Deque<Integer> queue;

    public RecentCounter() {
        queue = new ArrayDeque<>();
    }

    public int ping(int t) {
        while (!queue.isEmpty() && queue.peekFirst() < t - 3000)
            queue.pollFirst();
        queue.addLast(t);
        return queue.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */
