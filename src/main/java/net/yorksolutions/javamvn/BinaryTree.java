package net.yorksolutions.javamvn;

import java.util.function.Consumer;

//Utility
class Ref{
    public Node node = null;
    //     Ref -> / \
}

//Implementation
class Node{

    // Node ->    val
    //            /\

    public int value;
    public Ref left = new Ref();
    public Ref right = new Ref();

    Node(int value){
        this.value = value;
    }

    static void add(Ref root, int value){
        while(root.node != null){
            if(value < root.node.value){
                root = root.node.left;
            }
            else{
                root = root.node.right;
            }
        }
        root.node = new Node(value);
    }
    //Call the given function for each element in the tree from least to most
    static void inOrder(Ref root, Consumer<Integer> function){
        if (root.node == null) {
            return;
        }

        inOrder(root.node.left, function);

        function.accept(root.node.value);

        inOrder(root.node.right, function);
    }
/*
[ 5, 3, 2, 4]
root: -> Ref(RootNode)

RootNode : 5

                                   |
                                   5
                                 /   \
                                3
                              /   \
                            2       4
                           / \      /\

 */


    static void delete(Ref root, int valToDelete){
        if(root.node == null){
            return;
        }

        if(valToDelete < root.node.value){
            delete(root.node.left, valToDelete);
        }

        else if(valToDelete > root.node.value){
            delete(root.node.right, valToDelete);
        }

        else{
            if(root.node.left.node == null && root.node.right.node == null){
                root.node = null;
                return;
            }
            else if(root.node.right.node == null && root.node.left.node != null){
                root.node = root.node.left.node;
                return;

            }
            else if(root.node.left.node == null && root.node.right.node != null){
                root.node = root.node.right.node;
                return;
            }

            int temp = minValue(root.node.right);
            root.node.value = temp;
            delete(root.node.right, temp);

        }
    }

    static int minValue(Ref ref){
        int minv = ref.node.value;
        while (ref.node.left.node != null)
        {
            minv = ref.node.left.node.value;
            ref = ref.node.left;
        }
        return minv;
    }
 }

//Data Structure that will keep a list in order
//Public API
public class BinaryTree {
    private final Ref root = new Ref();

     public void add(int value){
         Node.add(root, value);
     }
     public void inOrder(Consumer<Integer> function){
         Node.inOrder(root, function);
     }
    public void delete(int valToDelete){
        Node.delete(root, valToDelete);
    }

}
/*

[ 5, 3, 2, 4]
root: -> Ref(RootNode)

RootNode : 5

                                   |
                                   5
                                 /
                                3
                              /   \
                            2       4
                            /\      /\

 */






















