import java.util.*;
public class Phonebook
{
 static Scanner key = new Scanner(System.in);
 public static void main(String [] args)
 {
   
   
   BST Phonebook = new BST();
   LinkedListEvent Events = new LinkedListEvent();
   
   key.useDelimiter("\n");
   System.out.println("Welcome to the Binary Search Tree Phonebook!");
   boolean menuFlag = true;
   
   do 
   {
      System.out.println("Please choose an option:");
      System.out.println("1.Add a contact");
      System.out.println("2.Search for a contact");
      System.out.println("3.Delete a contact");
      System.out.println("4.Schedule an event/appointment");
      System.out.println("5.Print event/appointment details");
      System.out.println("6.Print contacts by first name");
      System.out.println("7.Print all events and appointments alphabetically");
      System.out.println("8.Print contacts attending an event");
      System.out.println("9.Add a contact to a scheduled event");
      System.out.println("10.Delete a scheduled event or appointment");
      System.out.println("11.Print all contacts in phonebook");
      System.out.println("12.Exit");
      System.out.println();
      System.out.print("Enter your choice: ");
      int criteria = key.nextInt();
      if !isInt(criteria) 
      {
         System.out.println("Pleaese Enter a number from the menu "); continue;
      }
      
      switch (criteria)
      {
        case 1:
        
        System.out.print("Enter the contact's name(FirstName LastName): ");
        String name = key.next();
        if !(isAllLetters(name)) continue;
        boolean hasSpace = false;
        for (int i=0; !hasSpace; i++) if(charAt(i)=='') hasSpace=true; 
        if !hasSpace {System.out.print("Please enter name as follows(FirstName LastName): "); continue;}
        if(Phonebook.search(name, "Name")) 
        {
          System.out.println("Contact already exists in phonebook, look above, addition is rejected.\n");
          continue;
        } 
        System.out.print("Enter the contact's phone number: ");
        String phoneNum = key.next();
        if()
        if(Phonebook.search(phoneNum, "Phone Number"))
        {
           System.out.println("Contact already exists in phonebook, look above, addition is rejected.\n");
           continue;
        }
        System.out.print("Enter the contact's email address: ");
        String email = key.next();
        System.out.print("Enter the contact's address(Street, City, Zip): ");
        String address = key.next();
        System.out.print("Enter the contact's birthday(DD-MM-YYYY): ");
        String birthday = key.next();
        System.out.print("Enter any notes for the contact: ");
        String notes = key.next();
        System.out.println();        
        Phonebook.insertContact(new Contact(name, phoneNum, email, address, birthday, notes));
        System.out.println("Contact added successfully!");
        System.out.println();        
        break; 
        
        
        case 2:
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Name");
        System.out.println("2.Phone Number");
        System.out.println("3.Email Address");
        System.out.println("4.Address");
        System.out.println("5.Birthday");
        System.out.print("Enter your choice: ");
        criteria = key.nextInt();
         if !isInt(criteria) 
      {
         System.out.println("Pleaese Enter a number from the menu "); continue;
      }
          switch (criteria)
          {
            case 1:
            
            System.out.print("Enter the contact's name: ");
            name = key.next();
            System.out.println();
            if(!Phonebook.search(name, "Name")) //case it is found will be printed by the method itself! 
              System.out.println("Contact not found!");
            else        
              System.out.println("Look above, contact found!");    
            System.out.println();
            break;     
               
            case 2:
            
            System.out.print("Enter the contact's phone number: ");
            phoneNum = key.next();
            if !(isInt(phoneNum)) continue;
            System.out.println();
            if(!Phonebook.search(phoneNum, "Phone Number")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact found!");    
            System.out.println();
            break; 
            
            case 3:
            
            System.out.print("Enter the contact's email address: ");
            email = key.next();
            System.out.println();
            if(!Phonebook.search(email, "Email Address")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 
            
            case 4:
            
            System.out.print("Enter the contact's address: ");
            address = key.next();
            System.out.println();
            if(!Phonebook.search(address, "Address")) //case it is found will be printed by the method itself! 
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 

            case 5:
            
            System.out.print("Enter the contact's birthday: ");
            birthday = key.next();
            System.out.println();
            if(!Phonebook.search(birthday, "Birthday")) //case it is found will be printed by the method itself!
               System.out.println("Contact not found!"); 
            else        
              System.out.println("Look above, contact(s) found!");  
            System.out.println();
            break; 
             
            default:
            
            System.out.println();
            System.out.println("You entered a number outside the allowed range, try again!\n");
            break;
          }
         break;
         
         
         case 3:
         
         System.out.print("Enter the contact's name: ");
         name = key.next();
         if !(isAllLetters(name)) continue;
         System.out.println();
         if(Phonebook.deleteContact(name)) //method will look for the contact that will be deleted and return true if the operation is successful
         { 
           Events.deleteAll(name, "Name"); //method in LinkedListEvent that deletes contacts from events based on contact's name or phone number
           System.out.println("Contact successfully deleted!");
         }
         else
           System.out.println("Contact couldn't be found, deletion is not successful!");
         System.out.println();
         break;
         
         
         
         case 4: 
         
         int count = 0;
         System.out.println("Enter type:");
         System.out.println("1.Event");
         System.out.println("2.Appointment");
         System.out.print("Enter your choice: ");
         int type = key.nextInt();
         if (type!=1 || type!=2) 
         {
         System.out.println("Pleaese Enter a number from the menu "); continue;
         }
         if(type == 1)
         {   
           System.out.print("Enter the event's title: ");
           String title = key.next();
           System.out.print("Enter the contacts' name(s) delimited by commas: ");
           String contactNames = key.next();          
           System.out.print("Enter the event's date and time(DD/MM/YYYY HH:MM): ");
           String dateAndTime = key.next();
           System.out.print("Enter the event's location: ");
           String location = key.next();
           System.out.println();
           if(Events.isNotATimeConflict(dateAndTime)) 
           {
             contactNames += ",";
             String temp, cname = contactNames.substring(0,contactNames.indexOf(","));
             boolean allE = true;
             if(Phonebook.search(cname, "Name"))
             {                    
                System.out.println("Contact exists!");
                Events.insertEvent(new Event(title, Phonebook.retrieve(), dateAndTime, location, true));
             }
             else
             {
                System.out.println("Make sure all contacts exist!");
                allE = false;
             }
             count = cname.length()+1;
             temp = contactNames.substring(contactNames.indexOf(",")+1);
             while(count < contactNames.length() && allE)
             { 
               cname = temp.substring(0,temp.indexOf(","));
               if(Phonebook.search(cname, "Name")) 
               {
                  System.out.println("Contact exists!");
                  Events.addContactToEvent(Phonebook.retrieve());
               }
               else
               {
                  System.out.println("Make sure all contacts exist!");
                  allE = false;
               }
               count += cname.length()+1;
               temp = temp.substring(temp.indexOf(",")+1);
             } 
             if(allE)
               System.out.println("Event scheduled successfully!");
             else
               Events.deleteEvent(title, dateAndTime);
           }
           else
             System.out.println("Event couldn't be scheduled because of a time conflict!"); 
         }
         else if(type == 2)
         { 
           System.out.print("Enter the appointment's title: ");
           String title = key.next();
           System.out.print("Enter the contact's name: ");
           String contactName = key.next();
           if !(isAllLetters(name)) continue;
           System.out.print("Enter the appointments's date and time(MM/DD/YYYY HH:MM): ");
           String dateAndTime = key.next();
           System.out.print("Enter the appointments's location: ");
           String location = key.next();
           System.out.println();
           if(Events.isNotATimeConflict(dateAndTime)) 
           {
             if(Phonebook.search(contactName, "Name"))
             {
               System.out.println("Appointment will be scheduled with the contact above!");
               Events.insertEvent(new Event(title, Phonebook.retrieve(), dateAndTime, location, false));
               System.out.println("Appointment scheduled successfully!");
             }
             else
                System.out.println("Make sure the contact exists in the phonebook!");
           }
           else
              System.out.println("Appointment couldn't be scheduled because of a time conflict!");           
         }
        System.out.println();
        break; 
        
        
        case 5:
        
        System.out.println("Enter search criteria:");
        System.out.println("1.Contact name");
        System.out.println("2.Event/appointment title");
        System.out.print("Enter your choice: ");
        criteria = key.nextInt();
        if (criteria!=1 || criteria!=2) 
        {
         System.out.println("Pleaese Enter a number from the menu "); continue;
        }

        if (criteria == 1)
        {
         System.out.print("Enter the contact's name: ");
         String contactName = key.next();
         if !(isAllLetters(name)) continue;
         System.out.println();
         if(!Phonebook.search(contactName, "Name"))
           System.out.println("Contact with this name is not found!");
         else
         {
          System.out.println("The contact exists, look above, and these are the event(s) and appointment(s) scheduled with it: "); 
          Events.searchE(contactName, "Contact Name");
         }
        }    
        else if (criteria == 2)
        {
         System.out.print("Enter the event's or appointment's title: ");
         String title = key.next();
         System.out.println();
         if(!Events.searchE(title, "Title")) //case it is found will be printed by the method itself 
           System.out.println("Event/appointment not found!"); 
        } 
        System.out.println();   
        break; 
        
      
        case 6:
        
        System.out.print("Enter the first name: ");
        name = key.next();
        if !(isAllLetters(name)) continue;
        System.out.println();
        displayByFirstName(Phonebook, name); 
        System.out.println();
        break;
        
     
        case 7: 
        
        System.out.println();
        Events.displayEvents();
        System.out.println();
        break; 
        
        
        case 8:
        
        System.out.print("Please enter event's date and time(DD/MM/YYYY HH:MM): ");
        String dAndT = key.next();  
        if(Events.isNotATimeConflict(dAndT))
          System.out.print("\nEvent with this date and time doesn't exist!");
        else
        {
          if(!Events.retrieve().getType())
            System.out.println("\nWhat is scheduled at this time is an appointment!\n");
          else
          {         
            System.out.print("Please enter event's title: ");
            String title = key.next();         
            contactsByEvent(Events, title, dAndT);
            System.out.println();
          }
        }
        break; 
        
        
        case 9:
        
        System.out.print("Please enter event's date and time(DD/MM/YYYY HH:MM): ");
        dAndT = key.next();  
        if(Events.isNotATimeConflict(dAndT))
          System.out.print("\nEvent with this date and time doesn't exist!");
        else
        {
          if(!Events.retrieve().getType())
            System.out.println("\nWhat is scheduled at this time is an appointment, you cannot add any contacts!");
          else
          {        
            System.out.print("Please enter event title: ");
            String title = key.next();
            System.out.println();
            if(!Events.searchEUnique(title, dAndT))
              System.out.println("Event not found!");
            else
            {
              System.out.println("Event found look above!");
              System.out.print("Enter contact name: ");
              name = key.next();
              System.out.println();
              if(Phonebook.search(name, "Name")) //case it is found will be printed by the method itself! 
              {   
                System.out.println("Contact exists, look above!");
                if(Events.addContactToEvent(Phonebook.retrieve()))
                  System.out.println("Contact added to the event successfully!");
                else
                  System.out.println("Contact already exists in this event's contact list, look above, addition is rejected!");          
              }
              else
                System.out.println("Contact doesn't exist!");
            }
          }
        }     
        System.out.println();
        break;
        
        
        case 10:
        
        System.out.print("Please enter event title: ");
        String title = key.next();
        System.out.print("Please enter event's date and time(DD/MM/YYYY HH:MM): ");
        dAndT = key.next();  
        System.out.println();
        if(Events.deleteEvent(title, dAndT)) //method will look for the event that will be deleted and return true if the operation is successful
          System.out.println("Event successfully deleted!");
        else
          System.out.println("Event couldn't be found, deletion is not successful!");
          System.out.println();
        break;
        
        
        case 11:
        
        Phonebook.display();
        System.out.println();
        break; 

        
        case 12:
        
        menuFlag = false;
        break;
        
        default:
        
        System.out.println();
        System.out.println("You entered a number outside the allowed range, try again!\n");
        break;
      }
   }while(menuFlag);
   
   System.out.println("Thank you for using the phonebook!");

}

 //contacts by shared event method
 public static void contactsByEvent(LinkedListEvent list, String eventName, String dAndT)
 {
    if(!list.searchEUnique(eventName,dAndT))
      System.out.println("Event not found!");
    else
    {
      System.out.println("All contacts belonging to the event above: ");
      list.retrieve().getContactList().findFirst();
      while(!list.retrieve().getContactList().last())
      {
         System.out.println(list.retrieve().getContactList().retrieve().toString());
         list.retrieve().getContactList().findNext();
      }
      System.out.println(list.retrieve().getContactList().retrieve().toString()); //prints last element
    } 
 } 
 
 //contacts that share a first name method
 public static void displayByFirstName(BST list, String name) 
 {
  boolean flag = false;
  BSTNode temp = list.getRoot();
  while(temp != null)
  { 
    if(name.equalsIgnoreCase(temp.getData().getName().substring(0, temp.getData().getName().indexOf(' ')))) //first instance of first name is found, start traversal
    { 
      flag = true;
      break;
    }
    else if(temp.getData().getName().compareTo(name) < 0)
      temp = temp.getRight();
    else if(temp.getData().getName().compareTo(name) > 0)
      temp = temp.getLeft();
  } 
  if(flag)
  {
    Stack<BSTNode> s = new Stack<BSTNode>();  
    while (temp != null || !s.empty())
    {
      while (temp !=  null)
      { 
        s.push(temp);
        temp = temp.getLeft();
      }
      temp = s.pop();
      if(name.equalsIgnoreCase(temp.getData().getName().substring(0, temp.getData().getName().indexOf(' '))))
         System.out.println(temp.getData().toString());
      temp = temp.getRight();
    }
  }
 } 
 
 //input validation method for phone numbers
 public static boolean isInt(String num)
 {
    if (num == null)
      {
          return false;
      }
    try 
      {
        int n = Integer.parseInt(num);
      } 
    catch (NumberFormatException e) 
      {
        return false;  System.out.println("Please enter a number");
      }
    return true;
 }
 
 //input validation method for names
 public static boolean isAllLetters(String name)
 { 
    for (int i=0; charAt(i)!=''; i++) 
      {
       if !(charAt(i)<='A' && charAt(i)>='z') {  System.out.println("Please enter letters only"); return false;}
      }
    return true;
 }
  
 
} 
  
  
 
