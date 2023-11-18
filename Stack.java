public class Stack
{
  private SNode top;
  
  public Stack() 
  { 
    top = null;
  }
  
  public boolean empty()
  { 
    return (top == null);
  }
  
  public void push(BSTNode e)
  {
    SNode tmp = new SNode(e); 
    tmp.next = top;
    top = tmp;
  }
  
  public BSTNode pop()
  {
    BSTNode e = top.data;
    top = top.next;
    return e; 
  }

  public BSTNode peek() 
  {
     BSTNode tmp = pop();
     push(tmp);
     return tmp; 
  }
}