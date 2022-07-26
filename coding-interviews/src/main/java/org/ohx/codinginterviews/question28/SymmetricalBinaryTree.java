package org.ohx.codinginterviews.question28;

import java.util.Objects;

/**
 * @author mudkip
 * @date 2022/7/26
 */
public class SymmetricalBinaryTree {
    public boolean isSymmetrical(TreeNode pRoot) {
        return isSymmetrical(pRoot, pRoot);
    }

    public boolean isSymmetrical(TreeNode pRoot1, TreeNode pRoot2) {
        if (Objects.isNull(pRoot1) && Objects.isNull(pRoot2)) {
            return true;
        }
        if (Objects.isNull(pRoot1) || Objects.isNull(pRoot2)) {
            return false;
        }
        if (pRoot1.val != pRoot2.val) {
            return false;
        }

        return isSymmetrical(pRoot1.left, pRoot2.right) && isSymmetrical(pRoot1.right, pRoot2.left);
    }
}
