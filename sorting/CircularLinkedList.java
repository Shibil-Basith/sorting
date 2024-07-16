class ListNode {
    int data;
    ListNode next;

    ListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CircularLinkedList {
    private ListNode head;

    public CircularLinkedList() {
        this.head = null;
    }

    // Method to check if the list is empty
    private boolean isEmpty() {
        return head == null;
    }

    // Method to insert at the beginning of the list
    public void insertAtBeginning(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Circular reference for the first node
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            newNode.next = head;
            head = newNode;
            current.next = head; // Update last node's next to new head
        }
    }

    // Method to insert at the end of the list
    public void insertAtEnd(int data) {
        ListNode newNode = new ListNode(data);
        if (isEmpty()) {
            head = newNode;
            newNode.next = head; // Circular reference for the first node
        } else {
            ListNode current = head;
            while (current.next != head) {
                current = current.next;
            }
            current.next = newNode;
            newNode.next = head; // Make it circular
        }
    }

    // Method to insert at a specific position
    public void insertAtPosition(int data, int position) {
        ListNode newNode = new ListNode(data);
        if (position <= 0) {
            System.out.println("Invalid position");
            return;
        } else if (position == 1 || isEmpty()) {
            insertAtBeginning(data);
            return;
        }

        ListNode current = head;

        // Traverse to the position or wrap around the list if needed
        for (int currentPosition = 1; currentPosition < position - 1; currentPosition++) {
            current = current.next;
            if (current == head) {
                System.out.println("Position is beyond the end of the list.");
                return;
            }
        }

        // Insert newNode between current and current.next
        newNode.next = current.next;
        current.next = newNode;
    }

    // Method to delete the first node
    public void deleteFirst() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        ListNode current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = head.next;
        head = head.next;
    }

    // Method to delete the last node
    public void deleteLast() {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        ListNode current = head;
        while (current.next.next != head) {
            current = current.next;
        }
        current.next = head;
    }

    // Method to delete a node by specific data
    public void deleteByData(int data) {
        if (isEmpty()) {
            System.out.println("List is empty. Nothing to delete.");
            return;
        }

        ListNode current = head;

        if (head.data == data) { // If head node needs to be deleted
            deleteFirst();
            return;
        }

        while (current.next != head && current.next.data != data) {
            current = current.next;
        }

        if (current.next == head) {
            System.out.println("Node with data " + data + " not found.");
        } else {
            current.next = current.next.next;
        }
    }

    // Method to delete at a specific position
    public void deleteAtPosition(int position) {
        if (isEmpty() || position <= 0) {
            System.out.println("Invalid position or list is empty.");
            return;
        }

        if (position == 1) {
            deleteFirst();
            return;
        }

        ListNode current = head;

        // Traverse to the position or wrap around the list if needed
        for (int currentPosition = 1; currentPosition < position - 1; currentPosition++) {
            current = current.next;
            if (current.next == head) {
                System.out.println("Position is beyond the end of the list.");
                return;
            }
        }

        if (current.next == head) {
            System.out.println("Position is beyond the end of the list.");
            return;
        }

        // Delete node at current.next
        current.next = current.next.next;
    }

    // Method to display the circular linked list
    public void display() {
        if (isEmpty()) {
            System.out.println("List is empty.");
            return;
        }

        ListNode current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Method to search for a node with given data
    public boolean search(int data) {
        if (isEmpty()) {
            return false;
        }

        ListNode current = head;
        do {
            if (current.data == data) {
                return true; // Node found
            }
            current = current.next;
        } while (current != head);

        return false; // Node not found
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Inserting elements
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);
        list.insertAtBeginning(0);
        list.insertAtPosition(5, 3);

        // Displaying the list
        System.out.print("Original List: ");
        list.display();

        // Deleting elements
        list.deleteFirst();
        list.deleteLast();
        list.deleteByData(2);
        list.deleteAtPosition(2);

        // Displaying the list after deletion
        System.out.print("List after deletion: ");
        list.display();

        // Searching for elements
        System.out.println("Search for 3: " + (list.search(3) ? "Found" : "Not found"));
        System.out.println("Search for 10: " + (list.search(10) ? "Found" : "Not found"));
    }
}
