package virtualcmd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Node {

    private List<Node> childDirectory = new ArrayList<Node>();
    private Node parentDirectory = null;
    private String name = null;
    private Date date;

    // root
    public Node(String name) {
        this.name = name;
        this.date = new Date();
    }

    // sub- directories
    public Node(String name, Node parent) {
        this.name = name;
        this.parentDirectory = parent;
        this.date = new Date();
    }

    // list of children or sub-directories of a directory
    public List<Node> getChildren() {
        return childDirectory;
    }

    // Function to add children to the list
    public void addChild(Node child) {

        this.childDirectory.add(child);
    }

    public boolean isRoot() {
        return (this.parentDirectory == null);
    }

    public boolean isLeaf() {
        return this.childDirectory.size() == 0;
    }

    // Getter START
    public String getName() {
        return this.name;
    }

    public Node getParent() {
        return this.parentDirectory;
    }

    public Date getDate() {
        return this.date;
    }
    // GETTER END
}