package net.yorksolutios.javamvn;

import static org.junit.jupiter.api.Assertions.*;

//Arrange
import net.yorksolutions.javamvn.BinaryTree;


import javax.naming.BinaryRefAddr;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class BinaryTreeTest {

//Arrange
    class TreeWrapper {
        public BinaryTree tree = new BinaryTree();
        ArrayList<Integer> myList = new ArrayList<Integer>();
        private int treeSize = 0;


        //Tree methods
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

        public void inOrder(Consumer<Integer> function) {
            tree.inOrder(function);
        }


        //Wrapper Methods
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
        //Arrange
        TreeWrapper tw = new TreeWrapper();
        ArrayList<Integer> orderedList = new ArrayList<>();
        for(int i = 1; i < 8; i++){
            orderedList.add(i);
        }

        //make scrambled list to add elements out of order
        Integer[] nonOrderedList = {7,3,4,2,1,6,5};
        //Add scrambled elements to tree
        for(Integer i : nonOrderedList){
            tw.add(i);
        }
        ArrayList<Integer> toCompare = new ArrayList<>();

        //Act
        tw.inOrder((value) -> {
            toCompare.add(value);
        });

        //Assert
        assertEquals(toCompare, orderedList);










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
