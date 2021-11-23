/*.
I did not write the base linked list implementation and menu to operate on the list, that was written by Faizan Parvez
at https://www.mygreatlearning.com/blog/data-structures-using-java/
However, I modified the list to be doubly linked (adding a prev node reference),
added the functions DisplayPreviousAtPos and DisplayNextAtPos to show the next and prev node of a node at an index
Additionally, I added those functions to the menu, and changed how the menu worked because it annoyed me. Furthermore,
some of the naming conventions and spacings annoyed me, so I changed them.
The menu options are stored in the text file LinkedListMenu.
- Isaiah Hogue
 */

package com.example.linkedlist;

import java.util.*;

class Node{

    int data;
    // the object itself is referenced, no pointer needed
    Node next;
    Node prev;

    Node(int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}


class LinkedList{

    Node head;

    Node InsertAtBeginning(int key, Node head)
    {
        Node temp = new Node(key);
        // if null head = temp, else temp.next = old head, temp = new head
        if (head != null) {
            temp.next = head;
            head.prev = temp;
        }
        head = temp;
        return head;
    }


    Node InsertAtEnd(int key, Node head)
    {
        Node temp = new Node(key);
        Node temp1 = head;

        if(temp1 == null) {
            head = temp;
        }
        else
        {
            while(temp1.next != null)// here1
                temp1 = temp1.next;//here2
            temp.prev = temp1;//should work
            temp1.next = temp;//or end here?
        }
        return head;
    }


    Node insertAtPos(int key,int pos,Node head)
    {
        Node temp = new Node(key);

        if(pos == 1)
        {
            temp.next = head;
            head = temp;
        }
        else
        {
            Node temp1 = head;
            for(int i = 1; temp1 != null && i < pos; i++)
                temp1 = temp1.next;
            temp.prev = temp1;
            temp.next = temp1.next;
            temp1.next=temp;
        }

        return head;
    }


    Node delete(int pos,Node head)
    {
        Node temp = head;
        if(pos == 1)
            head = temp.next;
        else if (pos == length(head)){
            while(temp.next != null)
                temp = temp.next;
            temp = temp.prev;
            temp.next = null;
        }
        else
        {
            for(int i = 1;temp != null && i < pos-1 ;i++)
                temp = temp.next;
            temp.next.next.prev = temp; // for any case where node is neither head nor tail
            temp.next = temp.next.next;
        }
        return head;
    }

    int length(Node head)
    {
        Node temp=head;
        int x = 0;
        if(temp == null)
            return 0;
        else
        {
            while(temp != null)
            {	temp = temp.next;
                x++;
            }
        }
        return x;
    }


    Node reverse(Node head)
    {
        Node prevLNode=null,curLNode=head,nextLNode=null;
        while(curLNode!=null)
        {
            nextLNode=curLNode.next;
            curLNode.next=prevLNode;

            prevLNode=curLNode;
            curLNode=nextLNode;
        }

        head=prevLNode;
        return head;
    }


    void Display(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    void DisplayReverseList(Node head)
    {
        Node temp = head;
        while(temp!=null)
        {System.out.print(temp.data+" ");
            temp=temp.next;
        }
    }

    void DisplayPreviousAtPos(int pos,Node head)
    {
        if(pos != 1){
            Node temp = head;
            for(int i = 1; temp != null && i < pos; i++)
                temp = temp.next;
            {System.out.print(temp.prev.data);}

        }
        else{
            {System.out.print("Null: Position Invalid");}
        }
    }

    void DisplayNextAtPos(int pos,Node head)
    {
        if(pos != length(head)){
            Node temp = head;
            for(int i = 1; temp != null && i < pos; i++)
                temp = temp.next;
            {System.out.print(temp.next.data);}

        }
        else{
            {System.out.print("Null: Position Invalid");}
        }
    }


    public static void main(String[] args)
    {
        LinkedList l= new LinkedList();
        l.head=null;
        Scanner in=new Scanner(System.in);
        boolean done = false;
        while(!done)
        {
            System.out.println("Command:");
            int n = in.nextInt();
            //String x = in.next();
            switch(n)
            {case 1: System.out.println("\nenter the value ");
                l.head=l.InsertAtEnd(in.nextInt(),l.head);
                break;
                case 2: System.out.println("\nenter the value");
                    l.head=l.InsertAtBeginning(in.nextInt(),l.head);
                    break;
                case 3: System.out.println("\nenter the value");
                    l.head=l.insertAtPos(in.nextInt(),in.nextInt(),l.head);
                    break;
                case 4:
                    l.head=l.delete(in.nextInt(),l.head);
                    break;
                case 5:
                    System.out.println(l.length(l.head));
                    break;
                case 6:
                    l.head=l.reverse(l.head);
                    break;
                case 7:
                    l.Display(l.head);
                    break;
                case 8: System.out.println("\nenter the position");
                    l.DisplayPreviousAtPos(in.nextInt(), l.head);
                    System.out.println("\n");
                    break;
                case 9: System.out.println("\nenter the position");
                    l.DisplayNextAtPos(in.nextInt(), l.head);
                    System.out.println("\n");
                    break;
                case 10:
                    int[] primes = {
                            1,2,3,5,7,11,13,17,19,23,29,31,37,41,43,47,53,59,61,67,71,73,79,83,89,97
                    };
                    for (int prime : primes) {
                        l.head = l.InsertAtEnd(prime, l.head);
                    }
                    break;
                case 11: done = true;
                    break;
                default: System.out.println("\n Wrong Choice!");
                    break;
            }
            l.Display(l.head);
            System.out.println("\n");
        }
        System.exit(0);
    }
}
/*
"C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\bin\java.exe" "-javaagent:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\lib\idea_rt.jar=62415:C:\Program Files\JetBrains\IntelliJ IDEA Community Edition 2020.2.3\bin" -Dfile.encoding=UTF-8 -classpath "C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\charsets.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\access-bridge-64.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\cldrdata.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\dnsns.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\jaccess.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\localedata.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\nashorn.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunec.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunjce_provider.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunmscapi.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\sunpkcs11.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\ext\zipfs.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jce.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jfr.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\jsse.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\management-agent.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\resources.jar;C:\Program Files\AdoptOpenJDK\jdk-8.0.265.01-hotspot\jre\lib\rt.jar;C:\Users\isaia\source\java\LinkedList\out\production\LinkedList" com.example.linkedlist.LinkedList
Command:
10
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

Command:
8

enter the position
13
31

1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

Command:
9

enter the position
13
41

1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97

Command:
11
1 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97


Process finished with exit code 0

*/