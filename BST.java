public class BST //Binary Search Tree of Contacts
{

  private BSTNode root, current;  

  public BST()
  {
    root = current = null;
  }

  public boolean isEmpty()
  {
    return (root == null);
  }
/*
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
  }*/

  public Contact retrieve()
  {
    return current.getData();
  }

  /**public boolean findKey(String key)
  {
    BSTNode p = root, q = root;

    if(isEmpty()) 
      return false;

    while (p != null)
    {
      q = p;    
      if(p.getKey().compareTo(key) == 0) 
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
  }*/

  /**public boolean insert(Contact data, String key)
  {
	 BSTNode p, q = current;

    if(findKey(key)) 
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
  }*/
  
  
  public void insertContact(Contact data)
  {
	 BSTNode temp, p = root, q = root;

    temp = new BSTNode(data, data.getName());

	 if(isEmpty()) 
    { 
      root = current = temp; 
      return; 
    }
    while (p != null)
    {   
      q = p;
      if(p.compareTo(data.getName()) >= 0) 
         p = p.getLeft(); 
      else 
         p = p.getRight();
    }   
    if(q.compareTo(data.getName()) >= 0)
        q.setLeft(temp);
    else 
        q.setRight(temp);
     current = temp;
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
          return true;
        }
     	  else if(temp.compareTo(attribute) >= 0)
          temp = temp.getLeft();
        else
          temp = temp.getRight();        
     	}
     	return false;
      
       
      case "Phone Number":
      
      while (temp != null || !nodes.empty())
      {
        while (temp !=  null)
        {
          nodes.push(temp);
          temp = temp.getLeft();
        }
        temp = nodes.pop();
        if(temp.getData().getPhone().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(temp.getData().toString());
          return true;
        }
        temp = temp.getRight();
      }
      return false;
      
       
      case "Email Address":
     	
      if(temp == null)
         return false;
      nodes.push(root);
      while(!nodes.empty()) 
      {
        temp = nodes.peek();
        if(temp.getData().getEmail().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(temp.getData().toString());
          flag = true;
        }         
        nodes.pop();
        if(temp.getRight() != null) 
           nodes.push(temp.getRight());
        if(temp.getLeft() != null) 
           nodes.push(temp.getLeft());
      }
      return flag;
       
   
      case "Address":
 
      if(temp == null)
         return false;
      nodes.push(root);
      while(!nodes.empty()) 
      {
        temp = nodes.peek();
        if(temp.getData().getEmail().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(temp.getData().toString());
          flag = true;
        }
        nodes.pop();
        if(temp.getRight() != null) 
           nodes.push(temp.getRight());
        if(temp.getLeft() != null) 
           nodes.push(temp.getLeft());
      }
      return flag;
     
             
      case "Birthday":
 
      if(temp == null)
        return false;
      nodes.push(root);
      while(!nodes.empty()) 
      {
        temp = nodes.peek();
        if(temp.getData().getEmail().equalsIgnoreCase(attribute)) 
        { 
          System.out.println(temp.getData().toString());
          flag = true;
        }
        nodes.pop();
        if(temp.getRight() != null) 
          nodes.push(temp.getRight());
        if(temp.getLeft() != null) 
          nodes.push(temp.getLeft());
      }
      return flag;
        
      default: 
     
      System.out.println("Please make sure criteria input is correct."); 
      return false; 
   }
}

public void display()
{
   if(isEmpty())
     return;
   Stack s = new Stack();
   BSTNode temp = root;
   
   while (temp != null || !s.empty())
   {
     while (temp !=  null)
     {
       s.push(temp);
       temp = temp.getLeft();
     }
     temp = s.pop();
     System.out.println(temp.getData().toString());
     temp = temp.getRight();
  }
}

} 

   
