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
        System.out.println();
        copyList(head);
        System.out.println();
        copyRest(head);
        System.out.println();
        copyRestButTarget(head, "java");
        System.out.println();
        ListNode<String> newHead = insert(head, "inserted", 3);
        printList(newHead);
        System.out.println();
        ListNode<String> newHead2 = insertLast(head, "insertedLast");
        printList(newHead2);
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

    public static ListNode<String> copyNode(ListNode<String> arg){
        return new ListNode<>(arg.getValue(), null);
    }

    public static ListNode<String> copyList(ListNode<String> arg){
        if(arg == null){
            return null;
        }
        System.out.print(arg.getValue() + " ");
        ListNode<String> head = new ListNode<>(arg.getValue(), copyList(arg.getNext()));
        return head;
    }

    public static ListNode<String> copyRest(ListNode<String> arg){
        if(arg == null || arg.getNext() == null){
            return null;
        }
        System.out.print(arg.getNext().getValue() + " ");
        ListNode<String> head = new ListNode<>(arg.getNext().getValue(), copyRest(arg.getNext()));
        return head;
    }

    public static ListNode<String> copyRestButTarget(ListNode<String> current, String target){
        if(current == null){
            return null;
        }
        if(current.getValue().equals(target)){
            return copyRestButTarget(current.getNext(), target);
        }
        System.out.print(current.getValue() + " ");
        ListNode<String> head = new ListNode<>(current.getValue(), copyRestButTarget(current.getNext(), target));
        return head;
    }

    public static ListNode<String> insert(ListNode<String> current, String value, int index){
        if(index == 0){
            return new ListNode<>(value, current);
        }
        if(current == null){
            return null;
        }
        ListNode<String> head = new ListNode<>(current.getValue(), insert(current.getNext(), value, index-1));
        return head;
    }
    public static ListNode<String> insertLast(ListNode<String> current, String value){
        if(current == null){
            return new ListNode<>(value, current);
        }
        ListNode<String> head = new ListNode<>(current.getValue(), insertLast(current.getNext(), value));
        return head;
    }
}
