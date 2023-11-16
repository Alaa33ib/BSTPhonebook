public class BST //LinkedList of Contacts
{

  private BSTNode root;
  private BSTNode current;  

  public BST()
   {
    root = current = null;
  }

  public boolean isEmpty()
   {
    return (root == null);
  }

  /*public boolean last()
   {
    return (current.getNext() == null);
  }*/

  public void findRoot()
   {
    current = root;
  }

  public void findLeft()
   {
    current = current.getLeft();
  }

  public void findRight()
   {
    current = current.getRight();
  }


  public Contact retrieve()
   {
    return current.getData();
  }

  public boolean findkey(int key)
   {
    BSTNode p = root, q = root;

    if(isEmpty()) return false;

    while (p!=null){
      q=p;
      if(p.compareTo(key)==0) { current=p; return true; }
      else if(p.compareTo(key)==1) p=p.getLeft();
      else p=p.getRight();
    }

    current = q;
    return false;
  }

  public boolean insert(Contact data, int key)
   {
	 BSTNode p, q = current;

   if (findkey(key)) { current = q; return false; }

   p = new BSTNode(data,key);

	  if(isEmpty()) 
      { root = current = p; return true }
	  else 
     {
		 if(k.compareTo(current.getKey())==-1) current.setLeft(p);
     else current.setRight(p);
     current = p;
     return true; 
	  }
	}
    