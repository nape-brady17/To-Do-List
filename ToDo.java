/*
*              This program was written by: Brady Napier
* This is a small command line program that allows users to create a single to-do list
* The program was written as a way to create, manage, edit, and view a to-do list
*/

import java.util.*;

public class ToDo{
    //Class variables
    private static Scanner in = new Scanner(System.in);
    private static int selection, tmp, to, from;
    private static List todoList = null, completedList;
    private static Element ele; 
    private static boolean cont = true, highPriority;
    private static String name, notes, temp;

    //Prints the main menu for the user
    private static void printMenu(){
        System.out.println("\nMenu");
        System.out.println("\t1. Create a list");
        System.out.println("\t2. See a list");
        System.out.println("\t3. Add to a list");
        System.out.println("\t4. Delete an element of a list"); 
        System.out.println("\t5. Mark an element of a list as complete");
        System.out.println("\t6. See the items of the list you have completed");
        System.out.println("\t7. Modify a list or element");
        System.out.println("\t8. Reorder an element of the list");
        System.out.println("\nIf you wish to stop press 0");
        System.out.print("Please select an item from above: ");
    }

    //Prints the modification menu for the user
    private static void printModify(){
        System.out.println("Modification Menu");
        System.out.println("\t1. Modify the list name");
        System.out.println("\t2. Modify the lists notes");
        System.out.println("\t3. Modify an elements name");
        System.out.println("\t4. Modify an elements notes");
        System.out.println("\t5. Modify an elements priority");
        System.out.print("\nPlease select an item from above: ");
    }

    //Gets the users option from the main menu and executes that option
    private static boolean runOptions(){
        try{
            printMenu();
            selection = in.nextInt();
            in.nextLine();  //Clears the input buffer of the enter
            System.out.println();   //Print a new line

            switch(selection){  //Switch based on the user input
                case 1: //Create a list
                    System.out.print("Please enter the name of the list: ");
                    name = in.nextLine();
                    System.out.print("Please enter any notes about this list: ");
                    notes = in.nextLine();

                    todoList = new List(name, notes);   //Creates the list
                    break;

                case 2: //See a list
                    if (todoList == null) System.out.println("Must create a list first");
                    else System.out.print(todoList.toString());
                    break;

                case 3: //add to a list
                    if (todoList == null) System.out.println("Must create a list first");
                    else{
                        System.out.print("Enter the name of the element you wish to add: ");
                        name = in.nextLine();
                        System.out.print("Enter any notes about the element you wish to add: ");
                        notes = in.nextLine();

                        System.out.print("Is this a high priority element (Y/N): ");
                        temp = in.nextLine();
                        temp = temp.toUpperCase();
                        switch(temp){   //Switch based on the user input
                            case "Y":
                                highPriority = true;
                                break;

                            case "N":
                                highPriority = false;
                                break;

                            default:
                                System.out.println("Incorrect input format, defaulted to not being a high priority element");
                                highPriority = false;
                        }
                        todoList.addElement(name, notes, highPriority); //Creates an Element and adds it to the list
                    }
                    break;

                case 4: //Delete an element of a list
                    if (todoList == null) System.out.println("Must create a list first");
                    else if (todoList.listEmpty()) System.out.println("Must have elements in the list first");
                    else{
                        todoList.elementsMenu();
                        System.out.print("\nEnter the number of the element you wish to delete: ");
                        tmp = in.nextInt() - 1;
                        ele = todoList.getElement(tmp);
                        todoList.deleteElement(ele);   //Deletes Element from the list
                    }
                    break;

                case 5: //Mark an element of a list as complete
                    if (todoList == null) System.out.println("Must create a list first");
                    else if (todoList.listEmpty()) System.out.println("Must have elements in the list first");
                    else{
                        todoList.elementsMenu();
                        System.out.print("\nEnter the number of the element you wish to mark as completed: ");
                        tmp = in.nextInt() - 1;
                        ele = todoList.getElement(tmp);

                        todoList.completeElement(ele);
                    }
                    break;

                case 6: //See the items from the list you have completed
                    System.out.print(completedList.toString()); //Prints the formatted list
                    break;

                case 7: //Modify a list or element
                    if (todoList == null) System.out.println("Must create a list first");
                    else{
                        printModify();
                        tmp = in.nextInt();
                        System.out.println();

                        if (todoList.listEmpty()){
                            System.out.println("Must have elements in the list first");
                            break;
                        }

                        if (tmp == 3 || tmp == 4 || tmp == 5){
                            todoList.elementsMenu();
                            System.out.print("\nEnter the number of the element you wish to modify: ");
                            from = in.nextInt() - 1;
                        }

                        in.nextLine();  //Clears the input buffer of enter
                        
                        switch(tmp){    //Switch based on user input
                            case 1: //Modify the lists name
                                System.out.print("Enter the new name of the list: ");
                                name = in.nextLine();
                                todoList.setName(name); //Updates the name of the list
                                break;

                            case 2: //Modify the lists notes
                                System.out.print("Enter the new note of the list: ");
                                notes = in.nextLine();
                                todoList.setNotes(notes);   //Updates the notes of the list
                                break;

                            case 3: //Modify an elements name
                                ele = todoList.getElement(from);
                                if (ele == null) break; //Element does not exist in the list

                                System.out.print("Enter the new name for the element: ");
                                name = in.nextLine();
                                ele.setName(name);  //Updates the name of the element selected
                                break;

                            case 4: //Modify an elements notes
                                ele = todoList.getElement(from);
                                if (ele == null) break; //Element does not exist in the list

                                System.out.print("Enter the new note for the element: ");
                                name = in.nextLine();
                                ele.setNotes(name); //Updates the notes of the element selected
                                break;

                            case 5: //Modify an elements priority
                                ele = todoList.getElement(from);
                                if (ele == null) break; //Element does not exist in the list

                                System.out.print("Is this a high priority element (Y/N): ");
                                temp = in.nextLine();
                                temp = temp.toUpperCase();
                                switch(temp){   //Switch based on the user input
                                    case "Y":
                                        highPriority = true;
                                        break;

                                    case "N":
                                        highPriority = false;
                                        break;

                                    default:
                                        System.out.println("Incorrect input format, defaulted to not being a high priority element");
                                        highPriority = false;
                                }
                                ele.setHighPriority(highPriority);  //Updates the priority of the element selected
                                break;

                            default:
                            System.out.println("Incorrect input format, please try again");
                        }
                    }
                    break;

                case 8: //Reorder an element of the list
                    if (todoList == null) System.out.println("Must create a list first");
                    else if (todoList.listEmpty()) System.out.println("Must have elements in the list first");
                    else{
                        todoList.elementsMenu();
                        System.out.print("\nPlease enter the number of the element you wish to reorder: ");
                        from = in.nextInt() - 1; //Index of the element the user wishes to remove
                        System.out.print("Enter the place you would like to insert this item: ");
                        to = in.nextInt() - 1;  //Index of the place to user wishes to move the element

                        ele = todoList.getElement(from);    //The element to be moved
                        if (ele == null) break;

                        todoList.deleteElement(ele);    //Deletes the element from the list
                        todoList.addElement(ele, to);   //Adds the element to the correct location given by the user
                    }
                    break;

                case 0: //Exit program
                    System.out.println("Have a nice day!");
                    cont = false;   //Stop continuing
                    break;

                default:    //None of the previous options were inputted
                    System.out.println("Incorrect input format, please try again");
            }
        }
        catch (Exception e){
            System.out.println("\nAn error occurred, please try again");
            in.nextLine();  //Clears the input buffer that holds the error
        }
        return cont;    //Cont will be true unless option 0 is selected
    }

    //Runs the options while the user wishes to continue
    public static void main(String[] args){
        completedList= new List("Completed", "This list contains all of the elements that have been marked as completed");  //Initialize the completed list
        System.out.println("Welcome to this To-Do List");

        while (cont){
            runOptions();  
        }
        in.close();
    }
}

class List{
    //Class variables
    private String name;
    private String notes;
    private ArrayList<Element> list;

    //Constructors for the List class
    public List(){ 
        name = notes = null;
        list = new ArrayList<>();
    }
    public List(String name, String notes){
        this.name = name;
        this.notes = notes;
        list = new ArrayList<>();
    }

    //Sets the name of the list
    public void setName(String name){
        this.name = name;
    }

    //Sets the notes of the list
    public void setNotes(String notes){
        this.notes = notes;
    }

    //Returns the name of the list
    public String getName(){
        return name;
    }

    //Returns the element at the given index
    public Element getElement(int idx){
        try{
            return list.get(idx);
        }
        catch (Exception e){
            System.out.println("\nAn error occurred, please try again");
            return null;
        }
    }

    //toString override for the List class
    @Override
    public String toString(){
        String ele = "";
        for (Element el : list){    //Create a long string of all elements toStrings
            ele = ele.concat(el.toString());
        }
        return name + ":\t(" + notes + ")\n" + ele;
    }

    //Adds an element to the list given name, notes, and priority
    public void addElement(String name, String notes, boolean highPriority){
        Element temp = new Element(name, notes, highPriority);  //Creates a new Element
        list.add(temp); //Adds it to the list
    }

    //Adds an element to a specific index to the list
    public void addElement(Element ele, int idx){
        list.add(idx,  ele);
    }

    //Deletes an element from the list given the element
    public void deleteElement(Element ele){
        list.remove(ele);
    }

    //Marks an element as completed (deletes it from the list), return the element to save it to a completed list
    public void completeElement(Element ele){
        deleteElement(ele);   //Deletes the Element from the list
        list.add(ele);
    }

    //Prints the list of elements to select one to reorder
    public void elementsMenu(){
        for (int i = 0; i < list.size(); i++){
            System.out.print("\t" + (i + 1) + ". " + list.get(i).getName() + "\n");
        }
    }

    //Returns if the list has anything in it
    public boolean listEmpty(){
        return list.size() == 0;
    }
}

class Element{
    //Class variables
    private String name;
    private String notes;
    private boolean highPriority;

    //Constructors for the Elements class
    public Element(){
        name = notes = null;
        highPriority = false;
    }
    public Element(String name, String notes, boolean highPriority){
        this.name = name;
        this.notes = notes;
        this.highPriority = highPriority;
    }

    //Sets the name of the element
    public void setName(String name){
        this.name = name;
    }

    //Sets the notes of the element
    public void setNotes(String notes){
        this.notes = notes;
    }

    //Sets the priority of the element
    public void setHighPriority(boolean highPriority){
        this.highPriority = highPriority;
    }

    //Returns the name of the element
    public String getName(){
        return name;
    }

    //Returns the notes of the element
    public String getNotes(){
        return notes;
    }

    //Returns the priority of the element
    public boolean getHighPriority(){
        return highPriority;
    }

    //toString override for the Elements class
    @Override
    public String toString(){
        String ret = "\t- ";
        ret = ret.concat(String.format(" %-50.50s", name));
        if (highPriority) ret = ret.concat("*****");    //If the element is highPriority, add "*****" to the String
        ret = ret.concat(String.format("\n\t\t- %-75.75s\t\n", notes));

        return ret;
    }
}
