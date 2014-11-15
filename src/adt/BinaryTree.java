package adt;

import java.util.Iterator;
import adt.ArrayList;

public class BinaryTree {
	
	private ArrayList list;
	
	public BinaryTree() 
	{
		list = new ArrayList();
	}
	
	public int size()
	{
		return list.size();
	}
	
	public boolean isEmpty()
	{
		return list.isEmpty();
	}
	
	//public Iterator iterator()
	
	//public Iterable positions()
	
	public Node root()
	{
		return list.get(1);
	}
	
	public Node parent(Node p)
	{
		Node parent = null;
		
		
		
		return null;
	}
	
	//Iterable children(p)
	
	public boolean isExternal(Node p)
	{
		if (!hasLeft(p) && !hasRight(p))
			return true;
		else
			return false;
	}
	
	public boolean isInternal(Node p)
	{
		if (hasLeft(p) || hasRight(p))
			return true;
		else
			return false;
	}
	
	public boolean isRoot(Node p)
	{
		Node root = list.get(1);
		
		
		
		return true;
	}
	
	public char replace(Node p, char c)
	{
		return 'c';
	}
	
	public Node left(Node p)
	{
		return null;
	}
	
	public Node right(Node p)
	{
		return null;
	}
	
	public boolean hasLeft(Node p)
	{
		return true;
	}
	
	public boolean hasRight(Node p)
	{
		return true;
	}

}
