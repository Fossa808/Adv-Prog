import java.util.*;

//TODO: Write Comments
public class AssassinManager {
    private AssassinNode killRing;
    private AssassinNode graveyard;

    //Constructor - Takes a list of names and puts it in a LinkList 
    //that keeps track of who is stalking whom.
    //Prints who is stalking who.
    //Throws IllegalArgumentException if the list is empty or null.
    public AssassinManager(ArrayList<String> names){
        if (names.isEmpty() || names == null) {
            throw new IllegalArgumentException();
        }

        this.killRing = new AssassinNode(names.get(0));
        AssassinNode current = this.killRing;

        for (int i = 1; i < names.size(); i++) {
            current.next = new AssassinNode(names.get(i));
            current = current.next;
        }
    }

    //Prints the killRing as "_____ is stalking ______"
    //Each person is stalking the next person in the linklist.
    //The last person is stalking the first person.
    public void printKillRing(){
        AssassinNode current = killRing;
        while (current.next != null) {
            System.out.println(current.name + " is stalking " + current.next.name);
            current = current.next;
        }
        System.out.println(current.name + " is stalking " + killRing.name);
    }

    //prints the people who have been killed and who they have been killed by.
    //Prints as "_______ was killed by _______"
    public void printGraveyard(){
        if (graveyard != null) {
            AssassinNode current = graveyard;
            while (current != null) {
                System.out.println(current.name + " was killed by " + current.killer);
                current = current.next;
            }
        }  
    }

    //Checks if the killRing AssassinNode contains a specific name and returns the same
    public boolean killRingContains(String name){
        AssassinNode current = killRing;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Checks if the graveyard AssassinNode contains a specific name
    public boolean graveyardContains(String name){
        AssassinNode current = graveyard;
        while (current != null) {
            if (current.name.equalsIgnoreCase(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Checks if the game is over.
    //This means that there is only one name left in the killRing AssassinNode.
    public boolean isGameOver(){
        if (killRing.next == null) {
            return true;
        }
        return false;
    }

    //Returns the winner of the "game" after checking if there 
    //is only one person left.
    public String winner(){
        if (isGameOver()) {
            return killRing.name;
        }else{
            return null;
        }
    }

    //Kills the person whose name has been given as a parameter. 
    //Transfers AssassinNode of person to graveyard and notes down killer.
    //Stalker of killed person becomes stalker of the next person in the list.
    //Throws IllegalStateException if Game is over.
    //Throws IllegalArgumentException if the name given is not in the list.
    public void kill(String name){
        if (isGameOver()) {
            throw new IllegalStateException();
        }
        if (!killRingContains(name)) {
            throw new IllegalArgumentException();
        }
        AssassinNode current = killRing;
        if (killRing.name.equalsIgnoreCase(name)) {
            nameInFront(current, name);    
        }else{
            nameInMiddle(current, name);
        }
    }

    // private boolean checkNameOccurs(String name){
    //     AssassinNode temp = killRing;
    //     boolean nameOccurs = false;
    //     while (temp != null) {
    //         if (temp.name.equalsIgnoreCase(name)) {
    //             nameOccurs = true;
    //         }
    //         temp = temp.next;
    //     }
    //     return nameOccurs;
    // }

    //Case for if the name is the first person in the AssassinNode killRing.
    private void nameInFront(AssassinNode current, String name){
        killRing.killer = current.name;
        AssassinNode killed = killRing;
        killRing = killRing.next;
        killed.next = graveyard;
        graveyard = killed;
    }
    
    //Case for if the name occurs in the middle of the AssassinNode killRing.
    private void nameInMiddle(AssassinNode current, String name){
        while (current.next != null) {
            if (current.next.name.equalsIgnoreCase(name)){
                current.next.killer = current.name;
                AssassinNode killed = current.next;
                current.next = current.next.next;
                killed.next = graveyard;
                graveyard = killed;
                break;
            }
            current = current.next;
        }
    }
}
