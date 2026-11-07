public class LinkedListMethods{
    public static void main(String[] args){
        ListNode<String> head = new ListNode<>("hello", null);

        head = new ListNode<>("foo", head);
        head = new ListNode<>("boo", head);
        head = new ListNode<>("nonsense", head);

        head = new ListNode<>("computer",
            new ListNode<>("science",
            new ListNode<>("java",
            new ListNode<>("coffee", head))));

        printList(head);

    }
    

    //Precondition : Must have a parameter of type ListNode<String>
    //Postcondition : Prints the values of the linked list in order, seperated by a space
    public static void printList(ListNode<String> head){
        if(head.getNext() == null){
            System.out.print(head.getValue());
            return;
        }
        System.out.print(head.getValue() + " ");
        printList(head.getNext());
    }

}
