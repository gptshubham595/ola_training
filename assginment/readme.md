Done in C++

/*
Store customer information in a linked list. The program should provide three different options for viewing information:
View all customer data in sorted order based on bill amount
View total purchase amount for a specific year
View details of a specific customer based on name

*/

Functions 
    - insert_begin()                    /* insert at beginning with inpupts */
    - insert_begin(parameters)          /* insert node at beginning with default parameters */
    - traverse()                        /* Traverse linked list and displays it */
    - sorted_order_bill_amount()        /* Sorts linked list using bubble sort */
    - totalAmount_Of_A_Year(year)       /* Returns total amount sum in a year  */
    - userDetails(name)                 /*  Returns details of a user*/

Each Node
    - CUstomer ID (single number int)
    - Customer Name (single word name string)
    - Purchase Date (string DD/MM/YYYY )
    - AMount (double amount value)

While loop provides 6 options
    - 1 Insert
    - 2 Traverse
    - 3 View all customer data in sorted order based on bill amount\n";
    - 4 View total purchase amount for a specific year\n";
    - 5 View details of a specific customer based on name\n";
    - 6 Exit\n";