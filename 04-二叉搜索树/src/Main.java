import printer.BinaryTrees;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] info = {47, 28, 51, 19, 42, 50, 52, 18};

        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        for (Integer integer : info) {
            bst.add(integer);
        }
      /*  for (int i = 0; i < 20; i++) {
            bst.add((int) (Math.random()*100));
        }*/
        BinarySearchTree<Person> bst2 = new BinarySearchTree<>((o1, o2) -> o1.getAge() - o2.getAge());

        for (int data : info) {
            bst2.add(new Person(data));
        }

        BinaryTrees.println(bst);
        //bst.inOrderTraversal(e -> System.out.print(e + " "));
        //bst.preOrderTraversal(e -> System.out.print(e + " "));
        //System.out.println("该搜索二叉树的高度为：" + bst.height());
        //System.out.println("该搜索二叉树" + (bst.isComplete() ? "是" : "不是") + "完全二叉树");

    }
}
