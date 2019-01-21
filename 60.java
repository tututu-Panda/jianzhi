
// 直接层次遍历即可

public class Solution {
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer> > results = new ArrayList<ArrayList<Integer> >();
        if(pRoot == null)
            return results;

        // 定义层次遍历队列
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        queue.add(pRoot);
        int start = 0, end = 1;

        while(!queue.isEmpty()){
            TreeNode node = queue.remove();
            list.add(node.val);
            start++;
            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }

            // 当遍历到该行的最后一个时,下标重新开始
            if(start == end){
                end = queue.size();
                start = 0;
                results.add(list);
                list = new ArrayList<>();
            }
        }
        return results;
    }
}
