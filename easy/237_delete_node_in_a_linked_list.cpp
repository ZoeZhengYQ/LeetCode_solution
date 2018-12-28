/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

// given access to the node, delete this node in linked list
// remember to free the memory of deleted node!
// note that node = node -> next makes no change to linked list
// with *node = *node -> next, you change what is in that memory
// thus make *node -> next the node need to be deleted

class Solution {
public:
    void deleteNode(ListNode* node) {
        struct ListNode* temp = node -> next;
        *node = *temp;
        free(temp);
    }
};