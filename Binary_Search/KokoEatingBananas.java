/*
Problem     : Koko Eating Bananas
LeetCode    : https://leetcode.com/problems/koko-eating-bananas/

Goal:
Find the minimum integer eating speed k (bananas/hour) such that Koko can finish all banana piles within h hours.

Idea:
This is a classic "binary search on answer" problem.

Explanation:
----------------------------------------------------
1) Search Space:
   - Minimum speed = 1 (slowest possible).
   - Maximum speed = max(piles) (finish largest pile in 1 hour).

2) Binary Search on k:
   - While low < high:
       mid = low + (high - low) / 2   (candidate speed k)
       If Koko can finish all piles at speed mid within h hours:
           high = mid       (try smaller speed)
       Else:
           low = mid + 1    (need to eat faster)

3) Feasibility Check: canEat(piles, speed, h)
   - For each pile p:
       hours += ceil(p / speed)
       (implemented as (p + speed - 1) / speed using integer math)
   - If total hours > h → speed too slow → not feasible.
   - Otherwise feasible.

Why It Works:
- As speed k increases, required hours monotonically decrease.
- This monotonic behavior makes binary search valid.

Time Complexity : O(n log M)
   - n = number of piles
   - M = max pile size (range of k)
Space Complexity: O(1)

Author: Teja Nayani
Date  : 6 November, 2025
*/

public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1; //koko an eat as low as k = 1 banana/hour speed
        int high = 0;
        for(int p : piles){
            high = Math.max(high, p); //koko can eat as high as max pile bananas/hour speed
        }
        while(low < high){
            int mid = low + (high - low)/2; //assigning(assuming) speed k to be mid
            if(canEat(piles, mid, h)){
                high = mid; //speed k could be mid or lower (as we have to find the minimum speed k)
            }else{
                low = mid + 1; //speed k = mid exceeds h hours so she needs to eat faster/increase speed
            }
        }
        return low;
    }

    private boolean canEat(int[] piles, int speed, int h){
        long hours = 0;
        for(int p : piles){
            hours += (p + speed - 1)/speed; //for each pile p : time taken = ceil(p/speed) : in integer terms = (p+speed-1)/speed
            if(hours > h) //exceeds h hours
                return false; 
        }
        return (hours <= h);
    }
}
