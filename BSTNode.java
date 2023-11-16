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