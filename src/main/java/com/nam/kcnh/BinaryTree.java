package com.nam.kcnh;

/**
 * Created by Kerry on 04/06/2017.
 */
public class BinaryTree implements IBinaryTree{

    int treeSize = 0;
    Node root = null;

    //pass in null for the first parameter
    //p only needs a value during the recursion which is passed in by the code
    public void add(int i_, Node p) {
        Node parent;

        if(p == null){
            parent = getRoot();
        }
        else{
            parent = p;
        }

        if(treeSize == 0){

            //create the root node
            root = new Node(i_, null, null, null);
            treeSize++;

        }
        else if(exists(i_, null)){
            System.out.println("Value " + i_ + " is already in the tree.");
        }
        else{
            //add the node in the correct place in the tree
            if(i_ < parent.value){
                //add it in the correct place down the left side
                if(parent.lChild == null){
                    parent.lChild = new Node(i_, parent, null, null);
                    treeSize++;
                }
                else{
                    add(i_, parent.lChild);
                }

            }
            else{
                //add it in the correct place down the right side
                if(parent.rChild == null){
                    parent.rChild = new Node(i_, parent, null, null);
                    treeSize++;
                }
                else{
                    add(i_, parent.rChild);
                }
            }

        }


    }

    public void remove(int i_, Node p) {

        Node current;

        if(p == null){
            current = getRoot();
        }
        else{
            current = p;
        }


        if(exists(i_, null)){

            if (i_ == current.value) {

                //setting up right child link
                current.rChild.parent = current.parent;
                current.parent.lChild = current.rChild;

                //setting up left child link
                current.lChild.parent = deepestBranch(true, current.rChild);
                deepestBranch(true, current.rChild).lChild = current.lChild;


                //this is my current way of "deleting" the object from the tree.
                current.setNull();

                treeSize--;
            }
            else if(i_ < current.value && current.lChild != null){
                    remove(i_, current.lChild);
            }
            else if(i_ > current.value && current.rChild != null){
                    remove(i_, current.rChild);
            }

        }
        else{
            System.out.println("Value " + i_ + " was not removed as it is not within the tree");
        }

    }

    public boolean exists(int i_, Node p) {
        Node current;

        if(p == null){
            current = getRoot();
        }
        else{
            current = p;
        }

        if(current.value == i_){
            return true;
        }
        else if(i_ < current.value && current.lChild != null){
           return exists(i_, current.lChild);
        }
        else if(i_ > current.value && current.rChild != null){
            return exists(i_, current.rChild);
        }
        else{
            return false;
        }

    }


    public int size() {
        return treeSize;
    }

    public Node deepestBranch(boolean lef, Node p) {
        boolean left = lef;
        Node current;

        if(p == null){
            current = getRoot();
        }
        else{
            current = p;
        }

        if(left && current.lChild != null){
            return deepestBranch(lef, current.lChild);
        }
        else if (left && current.lChild == null){
            return current;
        }
        else if(!left && current.rChild != null){
            return deepestBranch(lef, current.rChild);
        }
        else if(!left && current.lChild == null){
            return current;
        }
        else{
            return null;
        }

    }

    public int[] sortAscending() {
        int[] array = new int[size()];


        return array;
    }

    public int[] sortDescending() {
        int[] array = new int[size()];

        return array;
    }

    public Node getRoot(){
        return root;
    }


}
