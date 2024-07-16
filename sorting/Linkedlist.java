import java.util.*;

class Linkedlist
{
    Node head;

    public Linkedlist()
    {
        head = null;
    }

    public void add(int data)
    {
        Node newNode = new Node(data);

        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while(current.next!=null)
            {
                current = current.next;
            }

            current.next = newNode;
        }
    }

    public void add(int index, int data)
    {
        Node newNode = new Node(data);
        Node current = head;

        if(index == 0)
        {
            newNode.next = head;
            head = newNode;
        }

        for(int i=0; i<index-1; i++)
        {
            current = current.next;
        }

        newNode.next = current.next;
        current.next = newNode;
    }

    public boolean remove(int data)
    {
        if(head == null)
        {
            System.out.println("Cannot remove as Linkedlist is empty.");
            return false;
        }

        if(head.data == data)
        {
            System.out.println(head.data+ " removed from Linkedlist.");
            head = head.next;
            return true;
        }

        Node current = head;
        while(current.next!=null && current.next.data!=data)
        {
            current = current.next;
        }

        if(current.next == null)
        {
            System.out.println("Cannot remove as element not found in Linkedlist.");
            return false;
        }

        current.next = current.next.next;
        return true;
    }

    public boolean delete(int index)
    {
        if(head == null)
        {
            System.out.println("Cannot remove as Linkedlist is empty.");
            return false;
        }
        if(index == 0)
        {
            System.out.println(head.data+ " removed from Linkedlist.");
            head = head.next;
            return true;
        }
        Node current = head;
        for(int i=0; i<index-1; i++)
        {
            current = current.next;
            if(current == null)
            {
                System.out.println("Index not found in Linkedlist.");
                return false;
            }
        }
        System.out.println(current.next.data + " removed from Linkedlist.");
        current.next = current.next.next;
        return true;

    }

    public void display()
    {
        Node current;
        for(current = head; current!=null; current=current.next)
        {
            System.out.print(current.data +  "->");
        }
        System.out.println("null");
    }

    public void search(int data)
    {
        int pos = -1, i;
        Node current;
        for(i=0, current = head; current!=null; current=current.next, i++)
        {
            if(current.data == data)
            {
                pos = i;
                break;
            }
        }
        if(pos!=-1)
        {
            System.out.println("data found at position: " + pos);
        }
        else
        {
            System.out.println("Element not found.");
        }
    }






    public static void main(String args[])
    {
        Linkedlist list = new Linkedlist();
        Scanner input = new Scanner(System.in);

        System.out.println("Enter number of elements: ");

        int n = input.nextInt();
        System.out.println("Enter list elements: ");

        for(int i=0; i<n; i++)
        {
            int data = input.nextInt();
            list.add(data);
        }

        System.out.println("list after add operations: ");
        list.display();

        System.out.println("Enter data to remove: ");
        int data = input.nextInt();
        list.remove(data);

        System.out.println("list after remove operation: ");
        list.display();

        System.out.println("Enter element position: ");
        int index = input.nextInt();

        System.out.println("Enter element: ");
        data = input.nextInt();
        list.add(index, data);

        System.out.println("list after new addition based on index: ");
        list.display();

        System.out.println("Enter position of element to delete: ");
        index = input.nextInt();
        list.delete(index);

        System.out.println("list after deletion based on index: ");
        list.display();


        System.out.println("Enter element search: ");
        data = input.nextInt();
        list.search(data);
        


    }
}

class Node
{
    int data;
    Node next;

    public Node(int data)
    {
        this.data = data;
    }
}