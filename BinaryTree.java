# BinaryTree
BinaryTree Project

import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Iterable;
/**
This class defines the methods of a BinaryTree. 
A Binary Tree is a data structure in which each node points to two other nodes, referred 
to as its left child and its right child.
@author Yanni Angelides
@version 12/9/15
*/

public class BinaryTree<E> implements Iterable<E>
{
	protected E value; //value that each individual tree contains
	protected BinaryTree<E> left; //the tree contained in the left space of the individual BinaryTree
	protected BinaryTree<E> right; //the tree contained in the left space of the individual BinaryTree
	
	
	public BinaryTree(E v, BinaryTree<E> l, BinaryTree<E> r)
	{
		value = v;
		left = l;
		right = r;
	}
	
	public BinaryTree(E v)
	{
		value = v;
		left = null;
		right = null;
	}
	
	public BinaryTree()
	{
		value = null;
		left = null;
		right = null;
	}
	
	public BinaryTree<E> left()
	{
		return left;
	}
	
	public BinaryTree<E> right()
	{
		return right;
	}
	
	public E value()
	{
		return value;
	}
	
	public void setLeft(BinaryTree<E> node)
	{
		left = node;	
	}
	
	public void setRight(BinaryTree<E> node)
	{
		right = node;	
	}
	
	public void setValue(E val)
	{
		value = val;
	}
	
	/**
	Figures out if the specific tree is a leaf or not. A leaf is a tree with null in its left and right space
	@return boolean indicating if the tree is a leaf
	*/
	public boolean isLeaf()
	{
		if (left == null && right == null) //tree is a leaf if both the left and right spots are null
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	Return number of descendants of node, including current node
	@return int number of subtrees plus current tree
	*/
	public int size()
	{
		if(this.isLeaf()) //If something is a leaf it can't branch off to anything else so it is the base case
		{
			return 1;
		}
		if(left == null)
		{
			return 1 + this.right().size(); //if left is null you have to keep going down the right side of the binary tree
		}
		if (right == null)
		{
			return 1 + this.left.size(); //same as above
		}
		else
		{
			return (1 + this.left().size()) + (this.right().size()); //have to do 1 + because if you don't it will only count the left and right and not the actual BinaryTree on top
		}
	}
	
	/**
	The maximum path length to a descendant
	@return int Maximum amount of levels you have to go down to reach a descendant in the tree
	*/
	public int height()
	{
		if(this.isLeaf()) //if you get to a leaf your at level 0 because there are no descendants under you
		{
			return 0; 
		}
		if(left == null)
		{
			return 0;
		}
		if (right == null)
		{
			return 0;
		}
		else
		{
			if(this.left().height() > this.left().height()) //want to find the path of maximum length so you only want to take the bigger one 
			{
				return 1 + this.left().height(); //Every level you go up you have ot add one to the total count
			}
			else
			{
				return 1 + this.right().height();
			} 
		}	
	}
	
	/**
	Return true if adding a node to tree would increase its height
	@return boolean indicating is the tree will go up in height if another tree were to be added. Checks if all levels of the tree have the maximum amount of subtrees 
	*/
	public boolean isFull()
	{
		if(this.isLeaf())
		{
			return true; //if both left and right are null than if you add a sub tree it would increase the height
		}
		if(left == null)
		{
			return false; //still space open on the right side so adding a sub tree would not increase the height
		}
		if (right == null)
		{
			return false; //still space open on the left side
		}
		else
		{
			return (this.left().height() == this.right().height()) && (this.left().isFull() && this.right().isFull());
			//if trees the same height then they are one the same level and if that level is then full then that level of the tree is full
		}	
	}
	
	/**
	Returns true if the difference in height of any two nodes of the tree is less than or equal to one
	@return boolean indicating if the tree is balanced
	*/
	public boolean isBalanced()
	{
		if(this.isLeaf()) //both sides are null so the tree is balanced
		{
			return true;
		}
		if(left == null) 
		{
			return false;
		}
		if (right == null) 
		{
			return false;
		}
		else
		{
			return (Math.abs(this.left().height() - this.right.height()) <= 1) && (this.left().isBalanced() && this.right().isBalanced());
			//first statement makes sure the heights are no more than 1 apart and the second one recursively goes through the whole tree
		}
	}
	
	/**
	Return true if tree has minimal height and any holes in the tree appear in the last level to the right
	@return boolean indicating if the tree is complete 
	*/
	public boolean isComplete()
	{
		if(this.isLeaf()) //both sides are null so the tree is complete because it is minimal height and there are no holes in it
		{
			return true;
		}
		if(left == null)  //the hole is to the left so it is not complete
		{
			return false; 
		}
		if (right == null && left.isLeaf()) //hole is to the right and the left side is a tree so the height are only one apart so it is complete
		{
			return true;
		}
		if (Math.abs(this.left().height() - this.right.height()) <= 1)
		{
			return left.isComplete() && right.isFull();	
		}
		if (this.left().height() == this.right().height())
		{
			return left.isFull() && right.isComplete();	
		}
		else
		{
			return false;
		}
	//if heights differ by one then left complete right full
	//if heights equal left full and right complete
	//if leaf return true
	//if right null return false
	//if left leaf and right null return true 

	}
	
	/**
	Returns a String representation of the BinaryTree
	@return String of BinaryTree organized with parenthesis
	*/
	public String toString()
	{
		String str = "";
		for(int z: )
		{
			str+= z;
		}
	}
	
	public static void main(String [] args)
	{
		BinaryTree<Integer> a = new BinaryTree<Integer>(1);
		BinaryTree<Integer> b = new BinaryTree<Integer>(3);
		BinaryTree<Integer> c = new BinaryTree<Integer>(7);
		BinaryTree<Integer> d = new BinaryTree<Integer>(9);
		BinaryTree<Integer> e = new BinaryTree<Integer>(11);
		BinaryTree<Integer> f = new BinaryTree<Integer>(13);
		BinaryTree<Integer> g = new BinaryTree<Integer>(16);
		BinaryTree<Integer> h = new BinaryTree<Integer>(19);
		BinaryTree<Integer> i = new BinaryTree<Integer>(2,a,b);
		BinaryTree<Integer> j = new BinaryTree<Integer>(8,c,d);
		BinaryTree<Integer> k = new BinaryTree<Integer>(12,e,f);
		BinaryTree<Integer> l = new BinaryTree<Integer>(18,g,h);
		BinaryTree<Integer> m = new BinaryTree<Integer>(5,i,j);
		BinaryTree<Integer> n = new BinaryTree<Integer>(15,k,l);
		BinaryTree<Integer> o = new BinaryTree<Integer>(10,m,n);
		
		System.out.println(o.size());
		System.out.println(j.height());
		System.out.println(m.isFull());
		System.out.println(o.isBalanced());
		
		for(int z: o)
		{
			System.out.println(z);
		}
			
	}
	
	//Iterators
	/**
	Creates and returns an iterator for a BinaryTree 
	@return Iterator<E>
	*/
	
	public Iterator<E> iterator()
	{
		return new InOrderIterator(this);
	}
}

import java.util.NoSuchElementException;
/**
@author Yanni Angelides
@version 10/30/15 
*/

import java.util.Iterator;
import java.lang.Iterable;

public class InOrderIterator<E> implements Iterator<E>
{
		private Vector<E> vector = new Vector<E>();
		private int curr;
		
		public InOrderIterator(BinaryTree<E> tree)
		{	
			curr = 0;
			makeVector(tree);
		}
		
		/**
		This is a helper method that turns the tree into a Vector. The Vector contains the values of the different trees in the order of the specified iterator.
		*/
		public void makeVector(BinaryTree<E> t) 
		{
			if(t.isLeaf())
			{
				vector.add(t.value()); //want to add the value of the tree to the vector because you have reached the bottom of a tree
				return;
			}
			else
			{
				if(t.left() != null)
				{
					makeVector(t.left()); //call your self iteratively to go down the left side
				}
				vector.add(t.value());
				if(t.right() != null)
				{
					makeVector(t.right());
				}
			}
		}
		/**
		Once the BinaryTree is turned into a Vector you can treat this as a Vector iterator. This is a method from the Iterator Interface that returns the next object in the Vector	
		@return E the next object of type E in the Vector
		*/
		public E next()
		{
			if (hasNext() == false)
			{
				throw new NoSuchElementException();
			}
			else
			{
				curr++;
				return (vector.get(curr-1));
			}
			
		}
		
		/**
		@return boolean determining whether or not there is another object in the Vector
		*/
		public boolean hasNext()
		{
			return (curr < vector.size());
		}
		
}

import java.util.NoSuchElementException;
/**
@author Yanni Angelides
@version 10/30/15 
*/

import java.util.Iterator;
import java.lang.Iterable;

public class PreOrderIterator<E> implements Iterator<E>
{
		private Vector<E> vector = new Vector<E>();
		private int curr;
		
		public PreOrderIterator(BinaryTree<E> tree)
		{	
			curr = 0;
			makeVector(tree);
		}
		
		/**
		This is a helper method that turns the tree into a Vector. The Vector contains the values of the different trees in the order of the specified iterator.
		*/
		public void makeVector(BinaryTree<E> t) 
		{
			if(t.isLeaf())
			{
				vector.add(t.value()); //want to add the value of the tree to the vector because you have reached the bottom of a tree
				return;
			}
			else
			{
				vector.add(t.value());
				if(t.left() != null)
				{
					makeVector(t.left()); //call your self iteratively to go down the left side
				}
				if(t.right() != null)
				{
					makeVector(t.right());
				}
			}
		}
		/**
		Once the BinaryTree is turned into a Vector you can treat this as a Vector iterator. This is a method from the Iterator Interface that returns the next object in the Vector	
		@return E the next object of type E in the Vector
		*/
		public E next()
		{
			if (hasNext() == false)
			{
				throw new NoSuchElementException();
			}
			else
			{
				curr++;
				return (vector.get(curr-1));
			}
			
		}
		
		/**
		@return boolean determining whether or not there is another object in the Vector
		*/
		public boolean hasNext()
		{
			return (curr < vector.size());
		}
		
}

import java.util.NoSuchElementException;
/**
@author Yanni Angelides
@version 10/30/15 
*/

import java.util.Iterator;
import java.lang.Iterable;

public class PostOrderIterator<E> implements Iterator<E>
{
		private Vector<E> vector = new Vector<E>();
		private int curr;
		
		public PostOrderIterator(BinaryTree<E> tree)
		{	
			curr = 0;
			makeVector(tree);
		}
		
		/**
		This is a helper method that turns the tree into a Vector. The Vector contains the values of the different trees in the order of the specified iterator.
		*/
		public void makeVector(BinaryTree<E> t) 
		{
			if(t.isLeaf())
			{
				vector.add(t.value()); //want to add the value of the tree to the vector because you have reached the bottom of a tree
				return;
			}
			else
			{
				if(t.left() != null)
				{
					makeVector(t.left()); //call your self iteratively to go down the left side
				}
				if(t.right() != null)
				{
					makeVector(t.right());
				}
				vector.add(t.value());
			}
		}
		/**
		Once the BinaryTree is turned into a Vector you can treat this as a Vector iterator. This is a method from the Iterator Interface that returns the next object in the Vector	
		@return E the next object of type E in the Vector
		*/
		public E next()
		{
			if (hasNext() == false)
			{
				throw new NoSuchElementException();
			}
			else
			{
				curr++;
				return (vector.get(curr-1));
			}
			
		}
		
		/**
		@return boolean determining whether or not there is another object in the Vector
		*/
		public boolean hasNext()
		{
			return (curr < vector.size());
		}
		
}
