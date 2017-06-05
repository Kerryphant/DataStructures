package com.nam.kcnh;

import org.junit.Assert;

/**
 * Created by Kerry on 05/06/2017.
 */
public class BinaryTreeTest {

    BinaryTree bObj = new BinaryTree();

    @org.junit.Test

    public void addTest(){
        //root node
        bObj.add(6 , null);
        //checking prevention of duplicates
        bObj.add(6 , null);

        //first level children
        bObj.add(2 , null);
        bObj.add(9 , null);

        //children of 2
        bObj.add(4 , null);
        bObj.add(1 , null);

        //children of 9
        bObj.add(7 , null);
        bObj.add(10 , null);

        //child of 10
        bObj.add(11 , null);

        //child of 4
        bObj.add(3, null);


        Assert.assertEquals(6, bObj.root.value);

        Assert.assertEquals(2, bObj.root.lChild.value);
        Assert.assertEquals(9, bObj.root.rChild.value);

        Assert.assertEquals(4, bObj.root.lChild.rChild.value);
        Assert.assertEquals(1, bObj.root.lChild.lChild.value);

        Assert.assertEquals( 7, bObj.root.rChild.lChild.value);
        Assert.assertEquals( 10, bObj.root.rChild.rChild.value);



        bObj.remove(14, null);
        bObj.remove(2, null);

        Assert.assertEquals(false , bObj.exists(2, null));

        Assert.assertEquals(4, bObj.root.lChild.value);
        Assert.assertEquals(3, bObj.root.lChild.lChild.value);
        Assert.assertEquals(1, bObj.root.lChild.lChild.lChild.value);

    }

    @org.junit.Test

    //Tests within this function rely on the addTest function
    public void sizeTest(){
        Assert.assertEquals(8 ,bObj.size());
    }

    @org.junit.Test

    //Tests within this function rely on the addTest function
    public void existsTest(){

        Assert.assertEquals(true , bObj.exists(11, null));
        Assert.assertEquals(false , bObj.exists(17, null));

    }

    @org.junit.Test

    //Tests within this function rely on the addTest function
    public void deepestBranchTest(){

        Assert.assertEquals( 1, bObj.deepestBranch(true, null).value);
        Assert.assertEquals( 11, bObj.deepestBranch(false, null).value);

    }

    @org.junit.Test
    //Tests within this function rely on the addTest function
    public void removeTest(){

        bObj.remove(2, null);

        Assert.assertEquals(false , bObj.exists(2, null));

        Assert.assertEquals(4, bObj.root.lChild.value);
        Assert.assertEquals(3, bObj.root.lChild.lChild.value);
        Assert.assertEquals(1, bObj.root.lChild.lChild.lChild.value);

    }


}
