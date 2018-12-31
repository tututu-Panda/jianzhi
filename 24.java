
// 寻找路径可以通过深度遍历实现,也可以通过后序遍历实现
// 通过深度遍历:
// 1. 将经过的节点加入到一个list中,一直遍历到该二叉树为空
// 2. 深度遍历完后需要回退,不然会造成list存在着所有的节点
// 3. 在添加所对应的路径时,需要重新new一个,不能直接添加list,不然其会使用list的引用,当后面改变时,引用也会改变

public class Solution {
    // 存放所有的路径
    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    // 存放进过的路径
    ArrayList<Integer> list1 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null)
            return list;
        // 定义经过的路径长度
        int d = 0;
        FindPath1(root, target, d);
        return list;
    }
    public void FindPath1(TreeNode root,int target, int d){
        // 构成该路径经过的所有值
        d += root.val;
        // 将当前路径加入list
        list1.add(root.val);

        // 因为要求的是直到叶节点,所以必须加上判断叶节点
        if(d == target && root.left==null && root.right == null) {
            // 这里必须new一下,重新申请空间,不然其会使用list的引用
            list.add(new ArrayList<>(list1));
        }
        // 继续深度遍历
        if(root.left != null)
            FindPath1(root.left,target,d);
        if(root.right != null)
            FindPath1(root.right,target,d);
        // 当遍历完后,需要回退
        list1.remove(list1.size()-1);
    }
}
