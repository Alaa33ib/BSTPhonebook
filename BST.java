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
public boolean deleteContact(String name) 
{
  String str = name;
  BSTNode p = root;
  BSTNode q = null; // Parent of p
  while (p != null) 
  {
    if (p.compareTo(name) > 0)
    {
      q = p;
      p = p.getLeft();
    }
    else if (p.compareTo(name) < 0) 
    {
      q = p;
      p = p.getRight();
    }
    else //p.compareTo(name) = 0; name is found
    { 
      if ((p.getLeft() != null) && (p.getRight() != null)) //p has two children
      {    
        BSTNode min = p.getRight();
        q = p;
        while (min.getLeft() != null) //looks for minimum in right subtree, leftmost node in right subtree
        {
          q = min;
          min = min.getLeft();
        }
        p.setKey(min.getKey());
        p.setData(min.getData());
        str = min.getKey();
        p = min;
      }
      if(p.getLeft() != null) //p has one child
        p = p.getLeft();
      else //p has one or no children
        p = p.getRight();
      if(q == null)//No parent for p, root must change
        root = p; 
      else
      { 
        if(q.compareTo(str) > 0)
          q.setLeft(p);
        else
          q.setRight(p);
      }
      current = root;
      return true;
    }
  }
  return false;// Not found
}

}  

   
