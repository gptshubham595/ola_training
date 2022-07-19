/*
Author: Shubham Kumar Gupta
Date: 16th July 2022
*/
#include <bits/stdc++.h>
using namespace std;
class Node
{ // This is a Node class representing each node
public:
    int customerId;
    string customerName;
    string purchaseDate;
    double amount;
    Node *next;

    Node()
    {
        // This is a default constructor
        this->customerId = 0;
        this->customerName = "";
        this->purchaseDate = "";
        this->amount = 0.0;
        next = nullptr;
    }
    Node(int _customerId, string _customerName, string _purchaseDate, double _amount)
    {
        // This is a overloaded constructor
        this->customerId = _customerId;
        this->customerName = _customerName;
        this->purchaseDate = _purchaseDate;
        this->amount = _amount;
        next = nullptr;
    }
};

class LinkedList
{
public:
    Node *head; // This is head Node

    LinkedList()
    {
        this->head = nullptr;
    }
    void insert_begin()
    {
        cout << "========INSERTING VALUES USING INPUT========\n";
        int customerId;
        string customerName;
        string purchaseDate;
        double amount;
        cout << "Enter customer Id:";
        cin >> customerId;
        cout << "\nEnter customer Name:";
        cin >> customerName;
        cout << "\nEnter purchaseDate DD/MM/YYYY (Ex- 12/12/2020):";
        cin >> purchaseDate;
        cout << "\nEnter amount:";
        cin >> amount;

        Node *curr = new Node(customerId, customerName, purchaseDate, amount);
        if (!head)
            head = curr;
        else
        {
            curr->next = head;
            head = curr;
        }
        cout << "===========================================\n";
    }
    void insert_begin(int _customerId, string _customerName, string _purchaseDate, double _amount)
    {
        cout << "===============INSERTING VALUES============\n";
        Node *curr = new Node(_customerId, _customerName, _purchaseDate, _amount);
        if (!head)
        {
            head = curr;
        }
        else
        {
            curr->next = head;
            head = curr;
        }
        cout << "===========================================\n";
    }
    void traverse()
    {
        cout << "\n================TRAVERSING=================\n";
        Node *temp = head;
        while (temp)
        {
            cout << "ID: " << temp->customerId << ", ";
            cout << "CUSTOMER NAME: " << temp->customerName << ", ";
            cout << "PURCHASE DATE: " << temp->purchaseDate << ", ";
            cout << "AMOUNT: " << temp->amount << " \n";
            temp = temp->next;
        }
        cout << "===========================================\n";
    }
    void sorted_order_bill_amount()
    {
        cout << "=================SORTING===================\n";
        Node *current = head;
        Node *index = nullptr;
        int temp;
        if (!head)
            return;
        else
        {
            while (current)
            {
                index = current->next;
                while (index)
                {
                    if (current->amount > index->amount)
                    {
                        temp = current->amount;
                        current->amount = index->amount;
                        index->amount = temp;
                    }
                    index = index->next;
                }
                current = current->next;
            }
        }
        cout << "===========================================\n";
        traverse();
    }
    vector<string> split(string &s, char split_with)
    {
        vector<string> words;
        string token;
        stringstream ss(s);
        while (getline(ss, token, split_with))
            words.push_back(token);
        return words;
    }

    double totalAmount_Of_A_Year(int year)
    {

        double totalAmount = 0;
        Node *temp = head;
        while (temp)
        {
            string purchaseDate = temp->purchaseDate;
            vector<string> dateSplit = split(purchaseDate, '/');
            int currYear = stol(dateSplit[2], nullptr, 10);
            if (currYear == year)
                totalAmount += temp->amount;
            temp = temp->next;
        }
        if (totalAmount == 0)
            cout << "\n This year doesn't exist.\n";
        return totalAmount;
    }

    void userDetails(string username)
    {
        Node *temp = head;
        int i = 1;
        while (temp)
        {
            if (temp->customerName == username)
            {
                cout << "\n"
                     << i << "th username matching details:\n";
                cout << "ID: " << temp->customerId << ", ";
                cout << "CUSTOMER NAME: " << temp->customerName << ", ";
                cout << "PURCHASE DATE: " << temp->purchaseDate << ", ";
                cout << "AMOUNT: " << temp->amount << " \n";
                i++;
            }
            temp = temp->next;
        }
        if (i == 1)
        {
            cout << "\n This username doesn't exists.\n";
        }
    }
};

int main()
{
    LinkedList *l = new LinkedList();

    l->insert_begin();

    l->insert_begin(2, "John", "01/02/2012", 24);
    l->insert_begin(3, "Stela", "10/10/2020", 21);
    l->insert_begin(4, "Alex", "02/05/2020", 24);
    l->insert_begin(5, "Bob", "08/02/2020", 2);
    l->insert_begin(6, "Klaire", "11/09/2012", 4);
    l->insert_begin(7, "Danish", "13/10/2012", 217);
    l->insert_begin(8, "Roe", "22/11/2012", 201);

    l->traverse();

    while (1)
    {
        int choice = 0;
        cout << "Enter your choice(Ex- 1): \n";
        cout << "      [1]-Insert new record \n";
        cout << "      [2]-Traverse \n";
        cout << "      [3]-View all customer data in sorted order based on bill amount\n";
        cout << "      [4]-View total purchase amount for a specific year\n";
        cout << "      [5]-View details of a specific customer based on name\n";
        cout << "      [6]-Exit\n";
        cin >> choice;
        if (choice == 1)
        {
            l->insert_begin();
        }
        if (choice == 2)
        {
            l->traverse();
        }
        if (choice == 3)
        {
            cout << "\n Sorting and displaying on the basis of bill amount\n";
            l->sorted_order_bill_amount();
        }
        if (choice == 4)
        {
            int year;
            cout << "\nEnter year for which you want total amount: ";
            cin >> year;
            cout << "\n Total amount for the year " << year << " is: " << l->totalAmount_Of_A_Year(year) << "\n";
        }
        if (choice == 5)
        {
            cout << "\n Enter username to get details: ";
            string name;
            cin >> name;
            cout << "\n Matching on the basis of username " << name << ":\n";
            l->userDetails(name);
        }
        if (choice == 6)
        {
            cout << "\nExiting!";
            break;
        }
        cout << endl;
    }
    return 0;
}