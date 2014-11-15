package adt;

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
		Node aNode = null;
		Node parent = null;
		int index = list.indexOf(p);
		
		if (index != -1) {
			aNode = list.get(index);
			parent = aNode.getParent();
		}
		// else throw exception?
		
		return parent;
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
		
		if (root != null)
			return true;
		else
			return false;
	}
	
	public char replace(Node p, char c)
	{
		Node aNode = null;
		Node newNode = null;
		char oldValue = 0;
		int index = list.indexOf(p);
		
		if (index != -1) {
			aNode = list.get(index);
			oldValue = aNode.element();
			newNode = new Node(aNode.getKey(), aNode.getParent(), c);
			list.set(index, newNode);
			
			aNode = null;
			newNode = null;
		}
		// else throw exception?
		
		return oldValue;
	}
	
	public Node left(Node p)
	{
		return p.getLeft();
	}
	
	public Node right(Node p)
	{
		return p.getRight();
	}
	
	public boolean hasLeft(Node p)
	{
		if (p.getLeft() != null)
			return true;
		else
			return false;
	}
	
	public boolean hasRight(Node p)
	{
		if (p.getRight() != null)
			return true;
		else
			return false;
	}

}
