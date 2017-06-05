package com.nam.kcnh;

/**
 * Created by Kerry on 04/06/2017.
 */
public interface IBinaryTree
{

    public void add(int i_, Node p);

    public void remove(int i_, Node p);

    public boolean exists(int i_, Node p);

    public int size();

    public Node deepestBranch(boolean lef, Node p);

    public int[] sortAscending();

    public int[] sortDescending();

    public Node getRoot();

}
