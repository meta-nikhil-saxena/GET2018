package AssignmentClasses;

/**
 * 
 * Mutable class for Doing operations on set
 * size() , isMember(int) , isSubset(set) , getCompliment() , union(set2)
 *
 */
public final class InSet {
    private final int arraySet[];

    // Let Universal set U is :
    private final int arrayUniversalSet[] = { 1, 2, 3, 4, 100, 200, 456, 234,
            890, 990, 100, 210, 500, 700, 900 };

    // Stores the count of values in array
    private final int count[] = new int[1000];

    /**
     * Constructor for Initialization of Array
     * 
     * @param arraySet
     * @throws AssertionError
     *             if Range exceed from 1000 or smaller than 0, and duplicate
     *             elements are there
     */
    InSet(int arraySet[]) throws AssertionError {
        this.arraySet = arraySet;

        this.checkException(arraySet);
        this.checkException(arrayUniversalSet);

        // Counting current set
        for (int index = 0; index < arraySet.length; index++) {
            count[arraySet[index]]++;
        }

    }

    /**
     * Helper Function to check Exception in Function
     * 
     * @param arraySet
     */
    void checkException(int arraySet[]) {
        for (int index = 0; index < arraySet.length; index++) {
            // Checking if range of set exceed the given range 1...1000
            // and if there are duplicate entries
            if (arraySet[index] < 0 || arraySet[index] > 1000
                    || count[arraySet[index]] > 1) {
                throw new AssertionError(
                        "!! Values Out of Range Or Duplicate entries in set !!");
            }
        }
    }

    /**
     * Function for calculation of size of the set
     * 
     * @return size of arraySet
     */
    int size() {
        return this.arraySet.length;
    }

    /**
     * Function to check element is member of set
     * 
     * @param element
     * @return true if element is member in set or false if not a member in set
     */
    boolean isMember(int element) {
        for (int index = 0; index < this.size(); index++) {
            if (element == arraySet[index]) {
                return true;
            }
        }
        return false;
    }

    /**
     * Function to check a set say set2 is subset of other set set1
     * 
     * @param set
     * @return true if a set say set2 is subset of the other set say set1
     */
    boolean isSubset(InSet set) {

        int set2Array[] = new int[set.arraySet.length];
        for (int index = 0; index < set.size(); index++) {
            set2Array[index] = set.arraySet[index];
        }
        int count = 0;

        for (int index = 0; index < set.size(); index++) {
            int element = set2Array[index];
            for (int index2 = 0; index2 < this.size(); index2++) {
                if (element == arraySet[index2]) {
                    count++;
                }

            }
        }
        if (count == set.size()) {
            return true;
        }
        return false;
    }

    /**
     * Function to get compliment of set say set1
     * 
     * @return compliment set arraySet
     */
    int[] getComplement() {
        int complimentSet[];
        int num, count = 0, newIndex = 0;

        int complimentTemporary[] = new int[arrayUniversalSet.length];
        for (int index = 0; index < arrayUniversalSet.length; index++) {
            num = arrayUniversalSet[index];
            count = 0;

            // For iterating the current Set (this)
            for (int index2 = 0; index2 < this.size(); index2++) {
                if (num != this.arraySet[index2]) {
                    count++;
                    /*
                     * To store compliment in the array if element not found in
                     * current array
                     */
                    if (count == this.size()) {
                        complimentTemporary[newIndex++] = num;
                    }
                }
            }
        }
        complimentSet = new int[newIndex];
        for (int index = 0; index < newIndex; index++) {
            complimentSet[index] = complimentTemporary[index];
        }
        return complimentSet;
    }

    /**
     * Function to find union of two sets
     * 
     * @param set2
     * @return union of sets say set1 and set2
     */
    int[] unionOfSets(InSet set2) {

        int unionTemporary[] = new int[this.size() + set2.size()];
        int unionOfSets[];
        int newIndex = 0;

        // Adding current set(this) in the new array if count is 1 , avoiding
        // duplicate entries
        for (int index = 0; index < this.size(); index++) {
            if (count[arraySet[index]] == 1) {
                unionTemporary[newIndex++] = arraySet[index];
                count[arraySet[index]]++;
            }
        }

        // Adding current second set(set2) in the new array if count is 1 ,
        // avoiding duplicate entries
        for (int index = 0; index < set2.size(); index++) {
            if (count[set2.arraySet[index]] == 1) {
                unionTemporary[newIndex++] = set2.arraySet[index];
                count[set2.arraySet[index]]++;
            }
        }

        unionOfSets = new int[newIndex];

        for (int index = 0; index < newIndex; index++) {
            unionOfSets[index] = unionTemporary[index];
        }
        sort(unionOfSets);
        return unionOfSets;
    }

    /**
     * Helper function of bubble sort
     * 
     * @param array
     */
    void sort(int array[]) {

        for (int index1 = 0; index1 < array.length; index1++) {

            for (int index2 = 0; index2 < (array.length - 1) - index1; index2++) {

                if (array[index2] > array[index2 + 1]) {
                    int temporary = array[index2];
                    array[index2] = array[index2 + 1];
                    array[index2 + 1] = temporary;
                }
            }
        }
    }

    // Some manually testing inputs
    public static void main(String args[]) {
        try {
            int arraySet1[] = { 1, 2, 3, 4, 5 };
            int arraySet2[] = { 1, 2, 3, 6, 7, 9, 4, 5 };

            final InSet set1 = new InSet(arraySet1);
            final InSet set2 = new InSet(arraySet2);

            System.out.println("Set 1 size : " + set1.size());
            System.out.println("Set 2 size : " + set2.size());

            if (set1.isSubset(set2)) {
                System.out.println(" set2 is subset of set1 ");
            } else {
                System.out.println(" set2 is !!NOT!! subset of set1 ");
            }

            if (set1.isMember(5)) {
                System.out.println("Is set1 member");
            } else {
                System.out.println("NOT a Member set1");
            }

            if (set2.isMember(3)) {
                System.out.println("Is set2 member");
            } else {
                System.out.println("NOT a Member of set2");
            }

            System.out.println("Compliment for set 1 : ");
            int complimentSet1[] = set1.getComplement();
            for (int i = 0; i < complimentSet1.length; i++) {
                System.out.print("   " + complimentSet1[i] + "   ");
            }
            System.out.println();
            System.out.println("Compliment for set 2 : ");
            int complimentSet2[] = set2.getComplement();
            for (int i = 0; i < complimentSet2.length; i++) {
                System.out.print("   " + complimentSet2[i] + "   ");
            }
            System.out.println();
            System.out.println("Union Of Two Sets Set1 and Set2 : ");
            int unionOfSets[] = set1.unionOfSets(set2);
            for (int i = 0; i < unionOfSets.length; i++) {
                System.out.print("   " + unionOfSets[i] + "   ");
            }
        } catch (AssertionError e) {
            System.out
                    .println("!! Values Out of Range Or Duplicate entries in set !!");
        }
    }
}
