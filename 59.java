
// 利用栈的特性,定义一个奇数栈,存储从左往右的节点, 一个偶数栈,存储从右往左的节点

public class Solution {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        // 存储奇数层的栈
        Stack<TreeNode> odd = new Stack<>();

        int layer = 1;
        odd.push(pRoot);

        // 存储偶数层的栈
        Stack<TreeNode> even = new Stack<>();

        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        while(!odd.empty() || !even.empty()){
            // 奇数层
            if(layer % 2 != 0){
                ArrayList<Integer> temp = new ArrayList<>();
                while(!odd.empty()){
                    TreeNode tn = odd.pop();
                    if(tn != null){
                        temp.add(tn.val);
                        // 从左往右存储偶数层的节点,最后出栈便是从右往左
                        even.push(tn.left);
                        even.push(tn.right);
                    }
                }
                if(!temp.isEmpty()){
                    results.add(temp);
                    layer++;
                }
            }
            // 偶数层
            else{
                ArrayList<Integer> temp = new ArrayList<>();
                while(!even.empty()){
                    TreeNode tn = even.pop();
                    if(tn != null){
                        temp.add(tn.val);
                        // 从右往左存储奇数层的节点,最后出栈便是从左往右
                        odd.push(tn.right);
                        odd.push(tn.left);
                    }
                }
                if(!temp.isEmpty()){
                    results.add(temp);
                    layer++;
                }
            }
        }
        return results;
    }

}
