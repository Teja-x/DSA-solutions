/*
Problem    : Car Fleet  
LeetCode   : https://leetcode.com/problems/car-fleet/

Approach   : Sort + Reverse Traverse + Time Comparison  
------------------------------------------------------
Goal       : Given positions and speeds of cars heading toward a target, determine how many car fleets arrive.

- Create an array of [position, speed] pairs.
- Sort cars by their position in ascending order (closer to start).
- Traverse from the car closest to the destination to the farthest (right to left):
    • For each car, calculate time it takes to reach the target.
    • If current time > last fleet time, it forms a new fleet.
    • Otherwise, it joins the last fleet (slower car ahead prevents overtaking).
- Increase fleet count only when a car is not part of an earlier fleet.

Alternate Approach:
- Use a `Deque<Double>` as stack to simulate each fleet's time to reach target.
- Only push when time is greater than peek (current fastest fleet time).

Time Complexity   : O(n log n)  
    - Sorting n cars  
    - One reverse pass through cars (O(n))

Space Complexity  : O(n)  
    - If using stack-based approach  
    - O(1) if only counting fleets with `lastFleetTime` tracking

Example:
Input  : target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]  
Output : 3  
Explanation:
- Cars at 10 and 8 form a fleet (same arrival time)
- Car at 5 and 3 also form a fleet
- Car at 0 is too slow to join others → Total 3 fleets

Author: Teja Nayani  
Date   : September 19, 2025
*/

import java.util.Arrays;

public class CarFleet {
    public int carFleet(int target, int[] position, int[] speed) {
        //Deque<Double> carFleet = new ArrayDeque<>();
        int n = position.length, count = 0;
        double time, lastFleetTime = 0;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> a[0]-b[0]); //sorting pairs based on position column in ascending order
        //Arrays.sort(cars, (a,b) -> Integer.compare(a[0],b[0])); //asc order - Integer.compare() avoids int overflow (cannot fit in int 32 bit case)
        for(int i = n-1; i >= 0; i--){
            time = ((target - cars[i][0])*1.0)/cars[i][1];
            if(time > lastFleetTime){
                lastFleetTime = time;
                count++;
            }
        }
        return count;
    }
}
/*
        Deque<Double> carFleet = new ArrayDeque<>();
        int n = position.length;
        double time;
        int[][] cars = new int[n][2];
        for(int i = 0; i < n; i++){
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a,b) -> a[0]-b[0]); //sorting pairs based on position column in ascending order
        for(int i = n-1; i >= 0; i--){
            time = ((target - cars[i][0])*1.0)/cars[i][1];
            if(carFleet.isEmpty() || time > carFleet.peek())
                carFleet.push(time);
        }
        return carFleet.size();
*/