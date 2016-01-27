/**
This is a limited version of a BINARY SEARCH TREE
@author Yanni Angelides
@version 01/12/16
*/

public class BST <E extends Comparable<E>> 
{
	private BinaryTree<E> root;
	
	//Constructor
	public BST(BinaryTree<E> t)
	{
		root = t;
	}
	
	//boolean add(E)
	public boolean add(E item)
	{
		return add(item, root);
	}
	
	public boolean add(E item, BinaryTree<E> curr)
	{
		if(item.compareTo(curr.value()) == 0)
		{
			return false;
		}
		if(item.compareTo(curr.value()) < 0 && curr.left() == null)
		{
			curr.setLeft(new BinaryTree<E>(item));
			return true;
		}
		if(item.compareTo(curr.value()) > 0 && curr.right() == null)
		{
			curr.setRight(new BinaryTree<E>(item));
			return true;
		}
		if(item.compareTo(curr.value()) < 0)
		{
			return add(item, curr.left());
		}
		else
		{
			return add(item, curr.left());
		}
	}
	
	//BinaryTree<E> find(E)
	public BinaryTree<E> find(E item, BinaryTree<E> curr)
	{
		if(item.compareTo(curr.value()) == 0) 
		{
			return curr;
		}
		if(item.compareTo(curr.value()) < 0 && curr.left() != null)
		{
			return find(item, curr.left());
		}
		else
		{
			return find(item, curr.right());
		}
	}
	
	//String toString()
	public String toString()
	{
		String str = root.toString();
		return str;
	}
}
