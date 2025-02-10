import java.util.*;

//This class checks whether all the tags in a given HTML file match.
//The public methods in this class are: addTag, removeAll, getTag and validate
//Through these methods you can validate the tags in an HTML file.
public class HtmlValidator {
    //FIELDS
    Queue<HtmlTag> tags;

    //BEHAVIOR

    //Constructors

    //Zero Parameter Constructor
    public HtmlValidator(){
        tags = new LinkedList<>();
    }
    //Constructor that takes a Queue of HtmlTags as a parameter
    public HtmlValidator(Queue<HtmlTag> tags){
        if (tags == null){
            throw new IllegalArgumentException("Cannot Submit null Queue!!!");
        }
        this.tags = tags;
    }

    //Adds the given HtmlTag in the parameters to the end of the queue of tags
    public void addTag(HtmlTag tag){
        if (tag == null){
            throw new IllegalArgumentException("Cannot provide null HtmlTag");
        }
        this.tags.add(tag);
    }

    //Returns whole queue of HtmlTags. Returns queue with all edits/changes 
    //made to the queue when addTag or removeAll was called
    public Queue<HtmlTag> getTags(){
        return tags;
    }

    //removes all html tags of provided type. Removes both opening 
    //and closing tabs. Parameters: String --> tag type
    public void removeAll(String element){
        if (element == null) {
            throw new IllegalArgumentException();
        }

        int size = tags.size();
        for(int i = 0; i < size; i++){
            if (tags.peek().getElement().equals(element)) {
                tags.remove();
            }else{
                tags.add(tags.remove());
            }
        }
    }

    //Prints an indented representation of the HtmlTags in the queue.
    //Analyzes the Html tags and finds and points out any unclosed or
    //unexpected tags.
    public void validate(){
        Stack<HtmlTag> openTags = new Stack<>();
        int indent = 0;
        int size = tags.size();

        //traverses through the Queue of tags
        for (int i = 0; i < size; i++) {
            HtmlTag tempTag = tags.remove();

            //Checks the type of tag and prints with the correct indentation
            if (tempTag.isSelfClosing()) {
                printTags(indent, tempTag);
            }else if (tempTag.isOpenTag() && !tempTag.isSelfClosing()) {
                //Prints open tags that are not self closing
                printTags(indent, tempTag);
                indent += 4;
                openTags.push(tempTag);
            }else if (!tempTag.isOpenTag()) {
                //Prints tags that are not opening tags
                //also checks if they match with the latest opening tag
                if (!openTags.isEmpty() && tempTag.matches(openTags.peek())) {
                    indent -= 4;
                    printTags(indent, tempTag);
                    openTags.pop();
                }else{//Prints error message if there is an unexpected tag
                    System.out.println("ERROR unexpected tag: " + tempTag);
                }
            }

            tags.add(tempTag);
        }

        int openSize = openTags.size();

        //Prints error messaged if a certain tag is not closed
        if (!openTags.isEmpty()) {
            for(int i = 0; i < openSize; i++){
                System.out.println("Error unclosed tag: " + openTags.pop());
            }
        }
    }

    //Adds indentation based on HtmlTag to help with the
    //representation of HtmlTags
    private void addIndent(int indent){
        for (int j = 0; j < indent; j++){
            System.out.print(" ");
        }
    }

    //Prints tags in validate method with proper indentation
    //Takes an int and an HtmlTag as parameters
    private void printTags(int indent, HtmlTag tag){
        addIndent(indent);
        System.out.println(tag);
    }
}