public class BST //Binary Search Tree of Contacts
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

  public boolean findkey(String key)
  {
    BSTNode p = root, q = root;

    if(isEmpty()) 
      return false;

    while (p != null)
    {
      q = p;
      if(p.compareTo(key) == 0) 
      { 
        current = p; 
        return true; 
      }
      else if(p.compareTo(key) == 1) 
        p = p.getLeft();
      else 
        p = p.getRight();
    }

    current = q;
    return false;
  }

  public boolean insert(Contact data, String key)
  {
	 BSTNode p, q = current;

    if(findkey(key)) 
    { 
      current = q; 
      return false; 
    }

    p = new BSTNode(data, key);

	 if(isEmpty()) 
    { 
      root = current = p; 
      return true; 
    }
	 else 
    {
		if(key.compareTo(current.getKey()) == -1)
        current.setLeft(p);
     else 
        current.setRight(p);
     current = p;
     return true; 
	 }
  }
    
 /** public boolean removeKey(String key)
  {
    Boolean removed = new Boolean(false);

    BSTNode p;

    p = removeAux(key, root, removed);

    current = root = p;
    return removed; //idk mate
  }

  public BSTNode removeAux(String key, BSTNode p, Boolean flag)
  {
    BSTNode q, child = null;
    if (p==null) return null;
    if (key.compareTo(p.getKey())==-1) p.setLeft(removeAux(key,p.getLeft(),flag));
    else if (key.compareTo(p.getKey())==1) p.setRight(removeAux(key,p.getRight(),flag));
    else 
    {
      flag.set(true);
      if (p.getLeft()!=null && p.getRight()!=null)
      {
        q = findMin(p.getRight());
        p.setKey(q.getKey());
        p.setData(q.getData());
        p.setRight(removeAux(q.getKey(), p.getRight(), flag));
      }
      else 
      {
      if (p.getRight()==null) child = p.getLeft();
      else if (p.getLeft()==null) child = p.getRight();
      return child;
      }
    }
    return p;

  }

  private BSTNode findMin(BSTNode p)
  {
    if(p==null) return null;
    while(p.getLeft()!=null)
    {
      p = p.getLeft();
    }
    return p;
  }*/
 
public boolean search(String attribute, String criteria) //searches for a contact in the list based on a specific criteria
{
   boolean flag = false; 
   BSTNode temp = root;
   Stack nodes = new Stack();

   switch(criteria) 
   {
      case "Name":
   
        while(temp != null)
        {
     	    if(temp.getData().getName().equalsIgnoreCase(attribute)) 
          { 
            System.out.println(temp.getData().toString());
            current = temp;
            return true;
          }
     	    else if(temp.getKey().compareTo(attribute) == -1)
           temp = temp.getRight();
          else if(temp.getKey().compareTo(attribute) == 1)
           temp = temp.getLeft();        
     	  }
     	  return false;
       
      case "Phone Number":
      
        while(temp != null)
        {
     	    if(temp.getData().getPhone().equalsIgnoreCase(attribute)) 
          { 
            System.out.println(temp.getData().toString());
            current = temp;
            return true;
          } 
          if(temp.getRight() != null)
            nodes.push(temp.getRight());
          else if(temp.getLeft() != null)
            temp = temp.getLeft();
          else
            temp = nodes.pop();  
        }
     	  return false;
       
      case "Email Address":
     	
  
        while(temp != null)
        {
     	    if(temp.getData().getEmail().equalsIgnoreCase(attribute)) 
          { 
            System.out.println(temp.getData().toString());
            flag = true;
          } 
          if(temp.getRight() != null)
            nodes.push(temp.getRight());
          else if(temp.getLeft() != null)
            temp = temp.getLeft();
          else
            temp = nodes.pop();  
       }
       return flag;
   
     case "Address":
 
       while(temp != null)
       {
         if(temp.getData().getAddress().equalsIgnoreCase(attribute)) 
         { 
           System.out.println(temp.getData().toString());
           flag = true;
         } 
         if(temp.getRight() != null)
           nodes.push(temp.getRight());
         else if(temp.getLeft() != null)
           temp = temp.getLeft();
         else
           temp = nodes.pop();  
      }
      return flag;
      
    case "Birthday":
 
      while(temp != null)
      {
        if(temp.getData().getBirthday().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(temp.getData().toString());
          flag = true;
        } 
        if(temp.getRight() != null)
          nodes.push(temp.getRight());
        else if(temp.getLeft() != null)
          temp = temp.getLeft();
        else
          temp = nodes.pop();  
     }
     return flag;
      
   default: 
     
     System.out.println("Please make sure criteria input is correct."); 
     return false; 
   }
}
}

   
