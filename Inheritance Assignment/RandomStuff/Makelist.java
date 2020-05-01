package RandomStuff;

public class Makelist {
    Node head;

    public void insert(String species_name) {
        Node node = new Node();
        node.species_name = species_name;
        node.next = null;
        node.count = 0;

        if (head == null) {
            head = node;
        } else {
            Node n = head;
            while (n.next != null) {
                n = n.next;
            }
            n.next = node;
        }
        node.count += 1;
    }
    public void show_species_name() {
        Node node = head;

        while (node != null) {
            System.out.println(node.species_name);
            node = node.next;
        }
    }
    public void show_how_much() {
        Node node = head;

        while (node != null) {
            System.out.println(node.count);
            node = node.next;
        }
    }

    public void find_species(String tofind) {
        Node node = head;

        while (node != null){
            if(node.species_name.equals(tofind)){
                System.out.println("There are" + " " +tofind);
                node = node.next;
            } else {
                System.out.println("Nothing here");
            }
        }
    }
}

