/*
Problem      : Copy List with Random Pointer
LeetCode     : https://leetcode.com/problems/copy-list-with-random-pointer/

Goal:
Create a deep copy of a linked list where each node contains:
1) `next` pointer to the next node
2) `random` pointer to any node (or null)

Approach   : In-Place Node Cloning (No Extra HashMap)
------------------------------------------------------------------
1. First Pass  (Interweave Copies):
   - For each original node `orig`
   - Create a copy node `copy = new Node(orig.val)`
   - Insert the copy between `orig` and `orig.next`
   - Resulting structure: orig -> copy -> orig.next -> copy.next -> ...

2. Second Pass (Assign Random Pointers):
   - For each original node `orig`
   - Set copy.random = orig.random.next (the copy of orig.random)

3. Third Pass (Detach Lists):
   - Restore original list
   - Extract and return the copied list

Time Complexity   : O(n)
Space Complexity  : O(1) extra (no HashMap used)

Alternate Approach:
Use a HashMap<Node, Node> to map each original node to its copy,
then assign next & random via map lookups.
This is simpler but uses O(n) extra memory.

Author  : Teja Nayani
Date    : 24 October, 2025
*/
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        //Approach 1 : In-Place Node Cloning
        if(head == null)
            return null;
        Node copyHead, orig = head;
        while(orig != null){
            Node nextNode = orig.next;
            Node copyNode = new Node(orig.val);
            orig.next = copyNode;
            copyNode.next = nextNode;  //orig.next = new Node(orig.val, orig.next); - directly
            orig = nextNode;
        }

        orig = head;
        while(orig != null){
            orig.next.random = (orig.random == null) ? null : orig.random.next;
            orig = orig.next.next;
        }

        orig = head;
        copyHead = head.next;
        while(orig != null){
            Node copy = orig.next;
            Node nextOrig = copy.next;

            copy.next = (nextOrig == null) ? null : nextOrig.next;
            orig.next = nextOrig;
            orig = nextOrig;
        }
        return copyHead;

        /* Approach 2 : Using HashMap<orig, copy> 
        if (head == null) 
            return null;

        HashMap<Node, Node> map = new HashMap<>();
        Node orig = head;

        // 1) Create all copied nodes (values only)
        while(orig != null){
            Node origCopy = new Node(orig.val);
            map.put(orig, origCopy);
            orig = orig.next;
        }

        // 2) Assign next and random pointers
        orig = head;
        while(orig != null){
            Node copy = map.get(orig);
            copy.next = map.get(orig.next);
            copy.random = map.get(orig.random);
            orig = orig.next;
        }
        return map.get(head);
        */
    }
}