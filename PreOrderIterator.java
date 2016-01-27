import java.util.NoSuchElementException;
/**
@author Yanni Angelides
@version 10/30/15 
*/

import java.util.Iterator;
import java.lang.Iterable;

public class PreOrderIterator<E> implements Iterator<E>
{
		private Vector<E> vector = new Vector<E>(); //The Vector that makeVector method transfers the BinaryTree into
		private int curr; //place holder so that the iterator knows where it is in the Vector
		
		public PreOrderIterator(BinaryTree<E> tree)
		{	
			curr = 0;
			makeVector(tree); //tree that is being iterated through
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
				System.out.println("There is no next element in the tree");
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
