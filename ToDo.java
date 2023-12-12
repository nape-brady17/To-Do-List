import java.util.*;

public class ToDo{
    public static void printMenu(){
        System.out.println("\n\t1. Create a list");
        System.out.println("\t2. See a list");
        System.out.println("\t3. Add to a list");
        System.out.println("\t4. Delete a list");
        System.out.println("\t5. Delete an element of a list");
        System.out.println("\nIf you wish to stop press 0");
        System.out.print("Please select an from above: ");
    }
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int selection;
        List todoList = null;   //later make this an array list of lists so that you can have multiple to do lists
        boolean cont = true;

        System.out.println("Welcome to this To-Do List");

        while (cont){
            try{
                printMenu();
                selection = in.nextInt();
                in.nextLine();
                System.out.println();

                switch(selection){
                    case 1: //create a list
                        String name, notes;

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
                        String temp;
                        boolean highPriority;

                        System.out.print("Enter the name of the element you wish to add: ");
                        name = in.nextLine();
                        System.out.print("Enter any notes about the element you wish to add: ");
                        notes = in.nextLine();
                        System.out.print("Is this a high priority element (Y/N): ");
                        temp = in.nextLine();
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
                        break;
                    case 4: //delete a list
                        System.out.println("Not completed yet");
                        break;
                    case 5: //delete an element of a list
                        System.out.println("Not completed yet");
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
                in.nextLine();
                cont = true;
            }
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
    public String getNotes(){
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
    public String getNotes(){
        return notes;
    }
    public boolean getHighPriority(){
        return highPriority;
    }

    //toString override for the Elements class
    public String toString(){
        String priority;
        if (highPriority) priority = "!!!";
        else priority = "";

        return "\t- " + name + "\t(" + notes + ")\t" + priority + "\n";
    }
}