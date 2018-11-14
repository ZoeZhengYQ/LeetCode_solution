/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        // list
        // O(n)
        // 注意head可能是NULL
        // next = head -> next; 换个位置就没毛病了
        ListNode* pre = NULL;
        while (head) {
            ListNode* next = head -> next;
            head -> next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
};

/*
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        if (head == NULL) {
            return head;
        }
        ListNode *temp, *curr, *prev;
        prev = NULL;
        curr = head;
        temp = curr->next;
        
        while (curr != NULL) {
            curr->next = prev;
            prev = curr;
            curr = temp;
            if (curr != NULL) {
                temp = curr->next;
            }
        }
        return prev;
    }
};
*/