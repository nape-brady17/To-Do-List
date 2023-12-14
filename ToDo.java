import java.util.*;

public class ToDo{
        private static Scanner in = new Scanner(System.in);
        private static int selection, tmp;
        private static List todoList = null, completedList;
        private static Element ele; 
        private static boolean cont = true, highPriority;
        private static String name, notes, temp;

    private static void printMenu(){
        System.out.println("\nMenu");
        System.out.println("\t1. Create a list");
        System.out.println("\t2. See a list");
        System.out.println("\t3. Add to a list");
        System.out.println("\t4. Delete an element of a list"); 
        System.out.println("\t5. Mark an element of a list as complete");
        System.out.println("\t6. See the items of the list you have completed");
        System.out.println("\t7. Modify a list or element");
        System.out.println("\nIf you wish to stop press 0");
        System.out.print("Please select an item from above: ");
    }

    private static void printModify(){
        System.out.println("\nModification Menu");
        System.out.println("\t1. Modify the list name");
        System.out.println("\t2. Modify the lists notes");
        System.out.println("\t3. Modify an elements name");
        System.out.println("\t4. Modify an elements notes");
        System.out.println("\t5. Modify an elements priority");
        System.out.print("\nPlease select an item from above: ");
    }

    private static boolean runOptions(){
        try{
            printMenu();
            selection = in.nextInt();
            in.nextLine();  //clears the input buffer of the enter
            System.out.println();

            switch(selection){
                case 1: //create a list
                    System.out.print("Please enter the name of the list: ");
                    name = in.nextLine();
                    System.out.print("Please enter any notes about this list: ");
                    notes = in.nextLine();

                    todoList = new List(name, notes);
                    break;

                case 2: //see a list
                        //Still want to better format the elements in the list
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
                        switch(temp){
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
                        todoList.addElement(name, notes, highPriority);
                    }
                    break;

                case 4: //delete an element of a list
                    if (todoList == null) System.out.println("Must create a list first");
                    else{
                        System.out.print("What is the name of the element you wish to delete: ");
                        name = in.nextLine();
                        todoList.deleteElement(name);
                    }
                    break;

                case 5: //mark an element of a list as complete
                    if (todoList == null) System.out.println("Must create a list first");
                    else{
                        System.out.print("What is the name of the element you wish to mark as completed: ");
                        name = in.nextLine();

                        ele = todoList.completeElement(name);
                        if (ele != null) completedList.addElement(ele.getName(), ele.getNotes(), ele.getHighPriority());
                    }
                    break;

                case 6: //see the items from the list you have completed
                    System.out.print(completedList.toString());
                    break;

                case 7: //modify a list or element
                    if (todoList == null) System.out.println("Must create a list first");
                    else{
                        printModify();
                        tmp = in.nextInt();
                        in.nextLine();  //clears the input buffer of enter
                        
                        switch(tmp){
                            case 1: //modify the lists name
                                System.out.print("Enter the new name of the list: ");
                                name = in.nextLine();
                                todoList.setName(name);
                                break;
                            case 2: //modify the lists notes
                                System.out.print("Enter the new note of the list: ");
                                notes = in.nextLine();
                                todoList.setNotes(notes);
                                break;
                            case 3: //modify an elements name
                                System.out.print("Enter the name of the element you would like to modify: ");
                                name = in.nextLine();
                                ele = todoList.findElement(name);
                                if (ele == null) break;
                                System.out.print("Enter the new name for the element: ");
                                name = in.nextLine();
                                ele.setName(name);
                                break;
                            case 4: //modify an elements notes
                                System.out.print("Enter the name of the element you would like to modify: ");
                                name = in.nextLine();
                                ele = todoList.findElement(name);
                                if (ele == null) break;
                                System.out.print("Enter the new note for the element: ");
                                name = in.nextLine();
                                ele.setNotes(name);
                                break;
                            case 5: //modify an elements priority
                                System.out.print("Enter the name of the element you would like to modify: ");
                                name = in.nextLine();
                                ele = todoList.findElement(name);
                                if (ele == null) break;
                                System.out.print("Is this a high priority element (Y/N): ");
                                temp = in.nextLine();
                                temp = temp.toUpperCase();
                                switch(temp){
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
                                ele.setHighPriority(highPriority);
                                break;
                            default:
                        }
                    }
                    break;

                case 0: //stop
                    System.out.println("Have a nice day!");
                    cont = false;
                    break;

                default:    //none of the others were inputted
                    System.out.println("Incorrect input format, please try again");
            }
        }
        catch (Exception e){
            System.out.println("\nAn error occurred, please try again");
            in.nextLine();  //clears the input buffer that holds the error
            cont = true;
        }
        return cont;
    }

    public static void main(String[] args){
        completedList= new List("Completed", "This list contains all of the elements that have been marked as completed");  //initialize completed list
        System.out.println("Welcome to this To-Do List");

        while (cont){
            runOptions();
        }
        in.close();
    }
}

class List{
    private String name;
    private String notes;
    private ArrayList<Element> list;

    //constructors for the List class
    public List(){
        name = notes = null;
        list = new ArrayList<>();
    }
    public List(String name, String notes){
        this.name = name;
        this.notes = notes;
        list = new ArrayList<>();
    }

    //setters for each of the class variables
    public void setName(String name){
        this.name = name;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }

    //getters for each of the class variables
    public String getName(){
        return name;
    }
    public String getNotes(){   //****
        return notes;
    }

    //toString override for the List class
    public String toString(){
        String ele = "";
        for (Element el : list){
            ele = ele.concat(el.toString());
        }
        return name + ":\t(" + notes + ")\n" + ele;
    }

    //add element to a list
    public void addElement(String name, String notes, boolean highPriority){
        Element temp = new Element(name, notes, highPriority);
        list.add(temp);
    }

    //delete element from the list
    public void deleteElement(String name){
        Element temp = findElement(name);
        if (temp != null){
            list.remove(temp);
        }
    }

    //mark element as completed (delete it from the list), return the element to save it to a completed list
    public Element completeElement(String name){
        Element temp = findElement(name);
        if (name != null){
            list.remove(temp);
            return temp;
        }
        return null;
    }

    //search for an element in the list of elements
    public Element findElement(String name){
        for (Element el : list){
            if (el.getName().toUpperCase().equals(name.toUpperCase())){
                return el;
            }
        }
        System.out.println("\nNo element in this list exists with that name");
        return null;
    }
}

class Element{
    private String name;
    private String notes;
    private boolean highPriority;

    //constructors for the Elements class
    public Element(){
        name = notes = null;
        highPriority = false;
    }
    public Element(String name, String notes, boolean highPriority){
        this.name = name;
        this.notes = notes;
        this.highPriority = highPriority;
    }

    //setters for each of the class variables
    public void setName(String name){
        this.name = name;
    }
    public void setNotes(String notes){
        this.notes = notes;
    }
    public void setHighPriority(boolean highPriority){
        this.highPriority = highPriority;
    }

    //getters for each of the class variables
    public String getName(){
        return name;
    }
    public String getNotes(){   //***
        return notes;
    }
    public boolean getHighPriority(){   //*** 
        return highPriority;
    }

    //toString override for the Elements class
    public String toString(){
        String ret = "\t- ";
        ret = ret.concat(String.format(" %-50.50s", name));
        if (highPriority) ret = ret.concat("*****");
        ret = ret.concat(String.format("\n\t\t- %-75.75s\t\n", notes));

        return ret;
    }
}
