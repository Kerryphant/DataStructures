package com.nam.kcnh;

/**
 * Created by Kerry on 04/06/2017.
 */
public class Node {

    int value = 0;
    Node parent = null;
    Node lChild = null;
    Node rChild = null;

    public Node(int v, Node p, Node lC, Node rC){

        value = v;
        parent = p;
        lChild = lC;
        rChild = rC;

    }

    public void setNull(){
        value = 0;
        parent = null;
        lChild = null;
        rChild = null;
    }

}
