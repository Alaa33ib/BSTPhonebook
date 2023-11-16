public class BSTNode //Nodes that contain Contact as data
{

     private Contact data;
     private BSTNode right, left;
     private String key;

   public BSTNode(Contact s, String k)
   {
      data = s;
      right = left = null;
      key = k;
   }
    public BSTNode(Contact s, String k, BSTNode1 l, BSTNode1 r)
   {
      data = s;
      right = r;
      left = l;
      key = k;
   }

    public int compareTo(Object s) //compares contact names alphabetically
   {
    Contact str = (Contact)s;
    int firstLength = this.getData().getName().length();  
    int secondLength = str.getData().getName().length();  
    int minLength = Math.min(firstLength, secondLength);
    int i = 0;  
    while(i < minLength) 
    {  
     char ch1 = this.getDate().getName().charAt(i);  
     char ch2 = str.getData().getName().charAt(i);  
     if(ch1 != ch2) 
     {  
      if((int)(ch1-ch2) > 0)
       return 1;
      else
       return -1;
     }
     i++;  
   }  
   return 0;  
   } 
   
   public Contact getData()
   {
     return data;
   }

   public void setLeft(BSTNode left)
   {
     this.left = left;
   }
   public void setRight(BSTNode right)
   {
     this.right = right;
   }
   
   public BSTNode getRight()
   {
     return right;
   }
   public BSTNode getLeft()
   {
     return left;
   }
   public int getKey(){
    return key;
   }
   public void setKey(int k){
    key=k;
   }

}
