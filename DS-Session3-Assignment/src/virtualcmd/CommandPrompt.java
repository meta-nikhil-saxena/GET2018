package virtualcmd;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

//Class for command prompt console
public class CommandPrompt {
    // root directory creation
    private Node root = new Node("Root");
    private Node current;

    /**
     * Function to create a new directory
     * 
     * @param directory
     * @param parent
     */
    public void createDirectory(String directory, Node parent) {

        Node child = new Node(directory, parent);
        parent.addChild(child);

    }

    /**
     * Function to change the directory
     * 
     * @param directory
     * @return true or false
     */
    public boolean changeDirectory(String directory) {

        List<Node> childList = current.getChildren();

        Iterator<Node> iterateChild = childList.iterator();

        while (iterateChild.hasNext()) {
            Node child = iterateChild.next();

            if (child.getName().equals(directory)) {
                current = child;
                return true;
            }
        }

        return false;
    }

    /**
     * Function to go back in the directory structure
     * 
     * @return true or false
     */
    public boolean backToParent() {

        if (!this.current.getParent().equals(null)) {

            this.current = this.current.getParent();

            return true;

        }
        return false;
    }

    /**
     * Function to list the directories in current parent directory
     * 
     * @return true or false
     */
    public boolean listDirectories() {
        if (!current.isLeaf()) {
            List<Node> childList = this.current.getChildren();
            Iterator<Node> iterateChild = childList.iterator();

            while (iterateChild.hasNext()) {
                Node child = iterateChild.next();

                System.out.println(child.getDate() + "    " + child.getName());
            }

            return true;
        }

        return false;
    }

    /**
     * Helper function for finDirectories which recursively find the name of the
     * file specified
     * 
     * @param parent
     * @param directory
     */
    public void checkDirectories(Node parent, String directory) {

        List<Node> childList = parent.getChildren();
        Iterator<Node> iterateChild = childList.iterator();

        while (iterateChild.hasNext()) {
            Node child = iterateChild.next();
            if (!child.isLeaf()) {
                checkDirectories(child, directory);
            } else {
                if (child.getName().equals(directory)) {
                    System.out.println("name : " + directory);
                }
            }
        }
    }

    /**
     * Function to find directory in the directory structure
     * 
     * @param directory
     * @return
     */
    public Boolean findDirectories(String directory) {
        checkDirectories(current, directory);
        return true;
    }

    /**
     * Helper Recursive function to create tree of the directory structure
     * 
     * @param parent
     */
    public void directoryTree(Node parent) {
        List<Node> childList = parent.getChildren();
        Iterator<Node> iterateChild = childList.iterator();

        while (iterateChild.hasNext()) {
            Node child = iterateChild.next();
            System.out.print("|___" + child.getName());
            if (!child.isLeaf()) {
                directoryTree(child);
            } else {
                System.out.println();
            }
        }
    }

    /**
     * Function to print tree structure for specified parent directory
     * 
     * @return true or false
     */
    public Boolean createTree() {
        directoryTree(current);
        return true;
    }

    @SuppressWarnings("resource")
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        CommandPrompt prompt = new CommandPrompt();
        prompt.current = prompt.root;
        String value[], command;
        String path = prompt.root.getName() + ":/";
        do {

            System.out.print(path + ">");
            command = scan.nextLine();
            value = command.split(" ");

            switch (value[0]) {
            case "mkdir": {
                prompt.createDirectory(value[1], prompt.current);
                break;
            }
            case "cd": {
                if (prompt.changeDirectory(value[1])) {
                    path = path + "/" + value[1];
                } else {
                    System.out.println("No such directory found");
                }
                break;
            }
            case "bk": {

                if (prompt.backToParent()) {

                    String newPath[] = path.split("/");
                    String newLocationPath = "";

                    int i = 0;

                    while (i < newPath.length - 1) {

                        newLocationPath = newLocationPath + newPath[i] + "/";
                        i++;
                    }

                    path = newLocationPath;

                } else {
                    throw new AssertionError("already in root");
                }
                break;
            }
            case "ls": {
                if (!prompt.listDirectories()) {
                    System.out.println("at last of the directories");
                }
                break;
            }
            case "find": {
                if (!prompt.findDirectories(value[1])) {
                    System.out.println("at last of the directories");
                }
                break;
            }
            case "tree": {
                if (!prompt.createTree()) {
                    System.out.println("at last of the directories");
                }
                break;
            }
            case "exit": {
                System.exit(0);
            }
            default:
                System.out.println("No such command found");
            }
        } while (true);
    }
}
