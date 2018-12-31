
// 从上往下,从左往右打印,则想到了层次遍历
// 因为返回的是一个ArrayList<Integer>所以想到可以通过ArrayList<TreeNode> queue的顺序性实现队列
// 每次出队时通过访问queue的第一个对象,并将其出队,然后每次遍历的对象的左右不为空子树加入queue
//

public class Solution {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return list;
        ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
        queue.add(root);
        // 如果list中还存在元素,继续遍历
        while(!queue.isEmpty()){
            TreeNode t = queue.remove(0);
            list.add(t.val);
            if(t.left != null)
                queue.add(t.left);
            if(t.right != null)
                queue.add(t.right);
        }
        return list;
    }
}
