package MaxDepth;

import MaxDepth.TreeNode;

/* -----------------------------------
 *  WARNING:
 * -----------------------------------
 *  Your code may fail to compile
 *  because it contains public class
 *  declarations.
 *  To fix this, please remove the
 *  "public" keyword from your class
 *  declarations.
 */


class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        return recurse(root, 1);

    }
    public int recurse(TreeNode root,int depth) {
        if(root.left == null && root.right == null){
            return depth;
        }
        int left = -1;
        int right = -1;
        if(root.left != null){
            left = recurse(root.left, depth+1);
        }
        if(root.right != null){
            right = recurse(root.right, depth+1);
        }
        return Math.max(left,right);
    }
}

