//
// Created by oweiss on 6/18/2020.
//


/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

#include <iostream>
#include <algorithm>
#include <vector>
#include <sstream>

using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
void trimLeftTrailingSpaces(string &input) {
    input.erase(input.begin(), find_if(input.begin(), input.end(), [](int ch) {
        return !isspace(ch);
    }));
}

void trimRightTrailingSpaces(string &input) {
    input.erase(find_if(input.rbegin(), input.rend(), [](int ch) {
        return !isspace(ch);
    }).base(), input.end());
}

vector<int> stringToIntegerVector(string input) {
    vector<int> output;
    trimLeftTrailingSpaces(input);
    trimRightTrailingSpaces(input);
    input = input.substr(1, input.length() - 2);
    stringstream ss;
    ss.str(input);
    string item;
    char delim = ',';
    while (getline(ss, item, delim)) {
        output.push_back(stoi(item));
    }
    return output;
}

ListNode* stringToListNode(string input) {
    // Generate list from the input
    vector<int> list = stringToIntegerVector(input);

    // Now convert that list into linked list
    ListNode* dummyRoot = new ListNode(0);
    ListNode* ptr = dummyRoot;
    for(int item : list) {
        ptr->next = new ListNode(item);
        ptr = ptr->next;
    }
    ptr = dummyRoot->next;
    delete dummyRoot;
    return ptr;
}

string listNodeToString(ListNode* node) {
    if (node == nullptr) {
        return "[]";
    }

    string result;
    while (node) {
        result += to_string(node->val) + ", ";
        node = node->next;
    }
    return "[" + result.substr(0, result.length() - 2) + "]";
}
class Solution {


public:
    void remove(ListNode* good, ListNode* bad){
        good->next = bad->next;


    }


    ListNode* deleteDuplicates(ListNode* head) {
        ListNode * prev = NULL;
        ListNode * main = head;
        bool dFlag = false;
        while(main->next!=NULL){

            ListNode * next = main->next;
            if(main->val == next->val){
                dFlag = true;
                remove(main,next);
            }
            else{
                if(dFlag && prev !=NULL){

                    prev->next = next;
                    dFlag =  false;
                }
                else if(dFlag && prev == NULL){
                    head = main->next;
                    dFlag = false;
                }
                else{
                    if(prev == NULL){
                        prev = main;
                    }
                    else{
                        prev = prev->next;
                    }
                }
                main = main->next;
            }
            next = next->next;
        }
        if(dFlag){
            if(prev == NULL) return NULL;
            else prev->next = NULL;
        }

        return head;

    }


};
int main() {
    string line;
    while (getline(cin, line)) {
        ListNode* head = stringToListNode(line);

        ListNode* ret = Solution().deleteDuplicates(head);

        string out = listNodeToString(ret);
        cout << out << endl;
    }
    return 0;
}



