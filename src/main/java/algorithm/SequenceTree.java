/* 版权所有(C)，OceanBai，2020，所有权利保留。
 *
 * 项目名：	algorithm
 * 文件名：	SequenceTree
 * 模块说明：
 * 修改历史：
 * 2020/1/2 - ocean - 创建。
 */

package algorithm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author ocean
 * @date 2020/1/2
 * 102 二叉树的层次遍历
 */
public class SequenceTree {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 采用队列的形式实现
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> valList = new ArrayList<>();
            list.add(valList);
            for (int i = 0, length = queue.size(); i < length; i++) {
                TreeNode node = queue.poll();
                valList.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        addEchoNode(root, list, 0);
        return list;
    }

    private void addEchoNode(TreeNode node, List<List<Integer>> list, int level) {
        // 重点1 ： 第一次用到这个高度的list的时候就加入新的list
        if (list.size() == level) {
            list.add(new ArrayList<>());
        }
        // 根据当前高度获取对应的
        List<Integer> valList = list.get(level);
        // 将这一层加入对应的list里面
        valList.add(node.val);
        // 开始遍历下一层
        if (node.left != null) {
            addEchoNode(node.left, list, level + 1);
        }
        if (node.right != null) {
            addEchoNode(node.right, list, level + 1);
        }
    }

    @Test
    public void test() {
        TreeNode t = new TreeNode(3);
        TreeNode t1 = new TreeNode(9);
        TreeNode t2 = new TreeNode(20);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(7);
        t.left = t1;
        t.right = t2;
        t2.left = t3;
        t2.right = t4;
        levelOrder2(t);
    }
}
