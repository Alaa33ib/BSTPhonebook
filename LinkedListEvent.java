public class LinkedListEvent //LinkedList of Events
{

	private Node<Event> head;
	private Node<Event> current;	

	public LinkedListEvent()
   {
		head = current = null;
	}

	public boolean isEmpty()
   {
		return (head == null);
	}

	public boolean last()
   {
	  return (current.getNext() == null);
	}

	public void findFirst()
   {
		current = head;
	}

	public void findNext()
   {
	  current = current.getNext();
	}

	public Event retrieve()
   {
	  return current.getData();
	}

	public void update(Event data)
   {
	  current.setData(data);
	}

	public void insert(Event data)
   {
	  Node<Event> temp;
	  if(isEmpty()) 
       current = head = new Node<Event>(data);
	  else 
     {
		 temp = current.getNext();
		 current.setNext(new Node<Event>(data));
		 current = current.getNext();
		 current.setNext(temp);
	  }
   }
    
   public void remove()
   {
     if(current == head) 
       head = head.getNext();
    	else 
      {
    		Node<Event> temp = head;
    		while(temp.getNext() != current)
            temp = temp.getNext();
    		temp.setNext(current.getNext());	
    	}
    	if(current.getNext()!= null) 
        current = current.getNext();
    	else 
        current = head;
   }
   
  //end of ADT methods  
  
  public boolean isNotATimeConflict(String dateAndTime)
  {
    Node<Event> temp = head; 
    while(temp != null) 
    {
      if(temp.getData().getDateAndTime().equalsIgnoreCase(dateAndTime))
      {
        current = temp;
        return false;
      }
      temp = temp.getNext();
    }
    return true;
  } 

  public void deleteAll(String attribute, String criteria) //deletes all instances of a contact associated with an event; used exclusively when deleting a contact
  {
     Node<Event> tmp = head;
     switch(criteria)
     {
      case "Name":
       
      while(tmp != null)
      {
        tmp.getData().getContactList().findFirst();
        while(!tmp.getData().getContactList().last())
        {  
           if(tmp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute))
              tmp.getData().getContactList().remove();
           else
              tmp.getData().getContactList().findNext();
        }
        if(tmp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute))//checks last element
           tmp.getData().getContactList().remove();
        if(tmp.getData().getContactList().isEmpty())//Event's contact list is empty
        {
           current = tmp;
           this.remove();
           tmp = current;
        }
        else
          tmp = tmp.getNext();
      }
      break;
              
      case "Phone Number":
       
      while(tmp != null)
      {
        tmp.getData().getContactList().findFirst();
        while(!tmp.getData().getContactList().last())
        {  if(tmp.getData().getContactList().retrieve().getPhone().equalsIgnoreCase(attribute))
              tmp.getData().getContactList().remove();
           else
              tmp.getData().getContactList().findNext();
        }
        if(tmp.getData().getContactList().retrieve().getPhone().equalsIgnoreCase(attribute)) //checks last element
           tmp.getData().getContactList().remove();
        if(tmp.getData().getContactList().isEmpty()) //Event's contact list is empty
        {
           current = tmp;
           this.remove();
           tmp = current;
        }
        else
          tmp = tmp.getNext();
      }
      break;
    }
  }  
       
    public boolean searchE(String attribute, String criteria)
    {
      boolean flag = false; 
      Node<Event> temp = head;
      
      switch(criteria) 
      {

       case "Title": 
   
       while(temp != null)
       {
     	   if(temp.getData().getTitle().equalsIgnoreCase(attribute)) 
         { 
           System.out.println(temp.getData().toString());
           flag = true;
         }
     	   temp = temp.getNext();
     	 }
     	 return flag;
       
      case "Contact Name":
      
      while(temp != null)
      {
        temp.getData().getContactList().findFirst();
        while(!temp.getData().getContactList().last())
        {
     	    if(temp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute)) 
          { 
            System.out.println(temp.getData().toString());
            flag = true;
          }
     	    temp.getData().getContactList().findNext();
     	  }
        if(temp.getData().getContactList().retrieve().getName().equalsIgnoreCase(attribute)) //checks last element
        { 
          System.out.println(temp.getData().toString());
          flag = true;
        }
       temp = temp.getNext();
      }
      return flag;  
        
      default: 
     
      System.out.println("Please make sure criteria input is correct."); 
      return false;
     }
   }
  
  public void insertEvent(Event data) //inserts event to event list
  {
    Node<Event> ev = new Node<Event>(data);
    if(isEmpty()) 
    { 
      current = head = ev;
      return;
    }  
      
    if(data.compareTo(head.getData()) < 0)
    {
    	ev.setNext(head);
      head = ev;
    }
    else
    {
      Node<Event> p = head, q = head.getNext();
      while(p.getNext() != null)
     	{ if((data.compareTo(p.getData()) >= 0) && (data.compareTo(q.getData()) < 0))
          break;
        p = p.getNext();
        q = q.getNext(); 
      }
      current = p;
      insert(data);
    } 
  } 

   public void displayEvents() //displays all events in the list; they are already ordered alphabetically
   {
     if(this.isEmpty())
       System.out.println("No events found!");
     else
     {
       Node<Event> tmp = head;
       while(tmp != null)
       {
         System.out.println(tmp.getData().toString());
         tmp = tmp.getNext();
       }
     }
   }
   
   public boolean addContactToEvent(Contact contact) 
   {
     if(this.retrieve().getContactList().search(contact.getName(), "Name"))
       return false; 
     else
     {
       this.retrieve().getContactList().insertContact(contact);
       return true;
     }
   } 
   
   public boolean deleteEvent(String title, String dt) //deletes a event from the list
   {
      Node<Event> tmp = head;
      Node<Event> prev = null;
             
      while(tmp != null)
      {
         if(tmp.getData().getTitle().equalsIgnoreCase(title) && tmp.getData().getDateAndTime().equalsIgnoreCase(dt))
         {
           if(tmp == head) 
           {
             head = head.getNext();
             current = head;
           }
    	     else 
           {
    		    prev.setNext(tmp.getNext());	
             current = head;
           }
           return true;
         }
         prev = tmp;
         tmp = tmp.getNext();
      }
      return false;
   }
   
   public boolean searchEUnique(String title, String dateAndTime)
   {
      Node<Event> temp = current; 
      current = head;
   
      while(current != null)
      {
     	   if(this.retrieve().getTitle().equalsIgnoreCase(title) && this.retrieve().getDateAndTime().equalsIgnoreCase(dateAndTime)) 
         { 
           System.out.println(this.retrieve().toString());
           return true;
         }
     	   current = current.getNext();
     	}
      current = temp;
     	return false; 
   }
   
}


