This program was written by: Brady Napier

Program Basics:
    This is a command line program that allows users to create a single to-do list. The program was written as a way to create, manage, and view a to-do list
    while only using the keyboard. Using only the keyboard allows for a more efficient and productive way to manage the to-do list. The basic to-do list allows 
    the user to have the following functionalities:
        1. Create a list
        2. See a list
        3. Add to a list
        4. Delete an element of a list
        5. Mark an element of a list as complete
        6. See the items of the list you have completed
    These allow the user to create, manage, and view their to-do list with simplicity. This program was written mainly for personal use as a way to keep track 
    of daily items that needed to be completed. The simplicity of the to-do list allows for ease of use and is time efficient.

Functionalities:
    1. Create a list   
        This allows the user to create the single to-do list that this program contains. The user is able to name the list and add any notes that they want.

    2. See a list  
        This allows the user to view the list that is already created. This command prints the to-do list in the following format:
            [To-Do List Name]: ([To-Do List Notes])
                - [Element Name]    ([Element Notes])   !!!
        The 3 exclamation marks (!!!) are only there is the element in the to-do list is marked as high priority

    3. Add to a list  
        This allows the user to add elements to their to-do list. It will ask them for the name of the element as well as notes and weather it is a high
        priority element. It will then add this element to the end of the to-do list.

    4. Delete an element of a list
        This allows the user to delete an element. If an element is deleted then it does not go to the completed list, it is simply removed from the list.

    5. Mark an element of a list as complete
        This allows the user to mark an element as complete. If an element is marked as completed then it is removed from the list and added to a completed
        list (which can be seen using the next command).

    6. See the items of the list you have completed
        This allows the user to view all of the items that they have completed. It is printed in the same format as above.

***More functionalities will be added. Some of the functionalities I hope to add are:
    - a way to edit both the list and the elements of a list
        - change/edit the name and notes, as well as change the priority of the elements
    - a way to add multiple to-do lists
        - the main goal of this program was to be simple and easy to use, adding multiple to-do lists may make it harder to use
        - if this is done you would have to add deleting, editing, adding, and printing for the multiple lists
    - allow an element to have its own list
        - if an element has a sequence of elements, then the element can have its own list with the same functionalities as the bigger to-do list
    - allow of printing the to-do list only by name (no notes or priority)
