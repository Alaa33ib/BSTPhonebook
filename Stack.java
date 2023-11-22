public class Stack<T>
{
  private SNode<T> top;
  
  public Stack() 
  { 
    top = null;
  }
  
  public boolean empty()
  { 
    return (top == null);
  }
  
  public void push(T e)
  {
    SNode tmp = new SNode(e); 
    tmp.next = top;
    top = tmp;
  }
  
  public T pop()
  {
    T e = top.data;
    top = top.next;
    return e; 
  }

  public T peek() 
  {
     T tmp = pop();
     push(tmp);
     return tmp; 
  }
}
