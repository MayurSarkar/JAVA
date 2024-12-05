package LinkedList;

class Node {
    int data; // Data stored in the node (can be any type)
    Node next; // Reference to the next node in the list

    Node(int data1, Node next1){
        this.data=data1;
        this.next=next1;
    }
    // Constructor to initialize node
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class LinkedList {
    private Node head; // First node in the list
    private Node tail; // Last node in the list
    private int size;  // Track the size of the list

    // Constructor to create an empty list
    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Method to add an element at the end
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {  // If the list is empty
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode; // Link the new node to the current last node
            tail = newNode;      // Update the tail to the new node
        }
        size++;
    }

    // Method to add an element at the start
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head; // Link the new node to the current head
            head = newNode;      // Update the head to the new node
        }
        size++;
    }

    // Method to remove the first element
    public void removeFirst() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            head = head.next; // Move head to the next node
            size--;
        }
    }

    // Method to remove the last element
    public void removeLast() {
        if (head == null) {
            System.out.println("List is empty!");
        } else if (head.next == null) {  // Only one element
            head = null;
            tail = null;
            size--;
        } else {
            Node current = head;
            while (current.next != tail) {  // Traverse to the second last node
                current = current.next;
            }
            current.next = null;  // Remove reference to the last node
            tail = current;       // Update the tail
            size--;
        }
    }

    // Method to display the linked list
    public void display() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // Get the size of the list
    public int size() {
        return size;
    }
}
public class LLBasics {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Adding elements to the list
        list.addLast(10);
        list.addLast(20);
        list.addFirst(5);
        list.display();  // Output: 5 -> 10 -> 20 -> null

        // Removing elements from the list
        list.removeFirst();
        list.display();  // Output: 10 -> 20 -> null

        list.removeLast();
        list.display();  // Output: 10 -> null

        // Displaying size of the list
        System.out.println("Size: " + list.size());  // Output: Size: 1
    }
}

