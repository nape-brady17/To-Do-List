This program was written by: Brady Napier

Program Basics:
    This is a command line program that allows users to create a single to-do list. The program was written as a way to create, manage, edit, and view a to-do 
    list while only using the keyboard. Using only the keyboard allows for a more efficient and productive way to manage the to-do list. The basic to-do list
    allows the user to have the following functionalities:
        1. Create a list
        2. See a list
        3. Add to a list
        4. Delete an element of a list
        5. Mark an element of a list as complete
        6. See the items of the list you have completed
        7. Modify a list or element
    These allow the user to create, manage, edit, and view their to-do list with simplicity. This program was written mainly for personal use as a way to keep 
    track of daily tasks that they wish to complete. The simplicity of the to-do list allows for ease of use and is time efficient.

Functionalities:
    1. Create a list   
        This allows the user to create the single to-do list that this program contains. The user is able to name the list and add any notes that they want.

    2. See a list  
        This allows the user to view the list that is already created. This command prints the to-do list in the following format:
            [To-Do List Name]: ([To-Do List Notes])
                - [Element Name]        !!!
                    - [Element Notes]
        The 3 exclamation points ("!!!") are only there if the element in the to-do list is marked as high priority. It displays the full To-Do List name and 
        notes, however only displays the first 50 characters of an elements name and first 75 characters of an elements notes. The brackets are not displayed
        either, they are only used for the formatting above.

    3. Add to a list  
        This allows the user to add elements to their to-do list. It will ask them for the name of the element as well as notes and weather it is a high
        priority element. It will then add this element to the end of the to-do list. The name and notes for elements can be as long as desired (up to 
        2,147,483,647 characters), but only the first 50 characters of a name and 75 characters of a note will be displayed using the above (second) option.

    4. Delete an element of a list
        This allows the user to delete an element. If an element is deleted then it does not go to the completed list, it is simply removed from the list. 
        Deleted elements cannot be recovered, they are permanently deleted.

    5. Mark an element of a list as complete
        This allows the user to mark an element as complete. If an element is marked as completed then it is removed from the list and added to a completed
        list (which can be seen using the next command). After an element has been completed it cannot be deleted or edited.

    6. See the items of the list you have completed
        This allows the user to view all of the items that they have completed. It is printed in the same format as above (option 2). This lists name is
        defaulted to "Completed" and the notes are defaulted to "This list contains all of the elements that have been marked as completed". These cannot be 
        changed, you also cannot delete or edit any element in the completed list.

    7. Modify a list or element
        This allows the user to modify the existing list, or any existing elements. After selecting the 7th option another menu will appear with the options:
            1. Modify the list name
            2. Modify the lists notes
            3. Modify an elements name
            4. Modify an elements notes
            5. Modify an elements priority
        These options modify what they say. It will ask the user to input the name of the element they wish to modify followed by instructions to type what they 
        want to change that item to. Whenever something is modified the original item is not saved. This modification process deletes the original item and is 
        replaced with the modification.

***More functionalities may be added be added. Some of the functionalities I hope to add are:
    - a way to add multiple to-do lists
        - the main goal of this program was to be simple and easy to use, adding multiple to-do lists may make it harder to use
        - if this is done you would have to add deleting, editing, adding, and printing for the multiple lists
    - allow an element to have its own list
        - if an element has a sequence of elements, then the element can have its own list with the same functionalities as the bigger to-do list
    - allow of printing the to-do list only by name (no notes or priority)
    - allow for a way to reorder items in the list
    - allow for a time frame, a date when the task must be done by
