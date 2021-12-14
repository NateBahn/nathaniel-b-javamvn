package net.yorksolutios.javamvn;

import static org.junit.jupiter.api.Assertions.*;

//Arrange
import net.yorksolutions.javamvn.BinaryTree;


import javax.naming.BinaryRefAddr;
import java.util.ArrayList;
import java.util.function.Consumer;

public class BinaryTreeTest {

//Arrange
    class TreeWrapper {
        public BinaryTree tree = new BinaryTree();
        ArrayList<Integer> myList = new ArrayList<Integer>();
        private int treeSize = 0;

        public void add(int value) {
            tree.add(value);
            myList.add(value);
            ++treeSize;
        }

//        public void delete(int value) {
//            tree.delete(value);
//            expected.remove(value);
//            --treeSize;
//            testContents();
//        }

//        public void inOrder(Ref root, Consumer<T> function) {
//            tree.inOrder(root, function);
//        }

        public int getTreeSize() {
            return treeSize;
        }

    }


    @org.junit.jupiter.api.Test
    void makeObjectTest() {
        //Act
        TreeWrapper tw = new TreeWrapper();
        //Assert
        assertEquals(0, tw.treeSize);
    }



        @org.junit.jupiter.api.Test
        void add() {
            TreeWrapper tw = new TreeWrapper();

            tw.add(5);
            assertEquals(1, tw.treeSize);
            assertTrue(tw.myList.contains(5));
            tw.add(2);
            assertEquals(2, tw.treeSize);
            assertTrue(tw.myList.contains(2));

            Integer isnull = null;

            assertThrows(RuntimeException.class, () -> {
                tw.add(isnull);
        });
        }




    @org.junit.jupiter.api.Test
    void inOrder() {

    }
}
//    @org.junit.jupiter.api.Test
//    void remove(){
//        BinaryTree tree = CreateTestTree();
//        tree.delete(5);
//
//        tree.inOrder((value) -> {
//           assertNotEquals(value, 5);
//        });
//
//    }
//}
