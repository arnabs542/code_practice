package class3;
import ds.*;
import java.util.*;

public class MaxTree {

	
	/*
	 * http://www.lintcode.com/en/problem/max-tree/
	 */
	public TreeNode maxTree1(int[] A) {
		// write your code here
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode root = null;
		for (int i = 0; i <= A.length; i++) {
			TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE)
					: new TreeNode(A[i]);
			while (!stack.isEmpty()) {
				if (right.val > stack.peek().val) {
					TreeNode nodeNow = stack.pop();
					if (stack.isEmpty()) {
						right.left = nodeNow;
					} else {
						TreeNode left = stack.peek();
						if (left.val > right.val) {
							right.left = nodeNow;
						} else {
							left.right = nodeNow;
						}
					}
				} else
					break;
			}
			stack.push(right);
		}
		return stack.peek().left;
	}
	
	
	
	
	/*
	 * method2
	 */
	public TreeNode maxTree(int[] A) {
        // write your code here
        int len = A.length;
        TreeNode[] stk = new TreeNode[len];
        for (int i = 0; i < len; ++i)
            stk[i] = new TreeNode(0);
        int cnt = 0;
        for (int i = 0; i < len; ++i) {
            TreeNode tmp = new TreeNode(A[i]);
            while (cnt > 0 && A[i] > stk[cnt-1].val) {
                tmp.left = stk[cnt-1];
                cnt --;
            }
            if (cnt > 0)
                stk[cnt - 1].right = tmp;
            stk[cnt++] = tmp;
        }
        return stk[0];
    }
}
