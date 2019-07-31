package bin_search_tree;

import bin_tree.BinTree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: snayi
 * @CreateTime: 2019-07-23 11:04
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        BinTree<Integer> binTree = new BinSearchTree<>();
        int[] num = new int[]{28,16,13,22,30,29,42};
        for (int i:num) {
            binTree.add(i);
        }
        //binTree.inOrder();
        List<Integer> list = new ArrayList<>();
        while (binTree.size() !=0 ) {
            list.add(binTree.removeMax());
        }
        System.out.println(list);
        binTree.size();

    }
}
