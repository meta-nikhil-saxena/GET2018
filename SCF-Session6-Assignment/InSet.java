package AssignmentClasses;

public final class InSet {
    private int arraySet[];
    private int arrayUniversalSet[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
    private int complimentSet[];
    private int count[] = new int[1000];

    /**
     * Constructor for Initialization of Array
     * 
     * @param arraySet
     * @throws AssertionError
     *             if Range exceed from 1000 or smaller than 0, and duplicate
     *             elements are there
     */
    InSet(int arraySet[]) throws AssertionError {
        for (int i = 0; i < arraySet.length; i++) {
            count[arraySet[i]]++;
            if (arraySet[i] < 0 || arraySet[i] > 1000 || count[arraySet[i]] > 1) {
                throw new AssertionError(
                        "!! Values Out of Range Or Duplicate entries in set !!");

            }
        }
        this.arraySet = arraySet;
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
        for (int i = 0; i < size(); i++) {
            if (element == arraySet[i]) {
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
        int set2Array[] = set.arraySet;
        int count = 0;

        for (int i = 0; i < set.size(); i++) {
            int n = set2Array[i];
            for (int j = 0; j < size(); j++) {
                if (n == arraySet[j]) {
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
        int num, count = 0, newIndex = 0;
        int complimentTemporary[] = new int[arrayUniversalSet.length];
        for (int i = 0; i < arrayUniversalSet.length; i++) {
            num = arrayUniversalSet[i];
            count = 0;
            for (int j = 0; j < size(); j++) {
                if (num != arraySet[j]) {
                    count++;
                    if (count == size()) {
                        complimentTemporary[newIndex++] = num;
                    }
                }
            }
        }
        complimentSet = new int[newIndex];
        for (int i = 0; i < newIndex; i++) {
            complimentSet[i] = complimentTemporary[i];
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
        for (int i = 0; i < size(); i++) {
            if (count[arraySet[i]] == 1) {
                unionTemporary[newIndex++] = arraySet[i];
                count[arraySet[i]]++;
            }
        }
        for (int i = 0; i < set2.size(); i++) {
            if (count[set2.arraySet[i]] == 1) {
                unionTemporary[newIndex++] = set2.arraySet[i];
                count[set2.arraySet[i]]++;
            }
        }
        unionOfSets = new int[newIndex];
        for (int i = 0; i < newIndex; i++) {
            unionOfSets[i] = unionTemporary[i];
        }
        sort(unionOfSets);
        return unionOfSets;
    }

    void sort(int array[]) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < (array.length - 1) - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temporary = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temporary;
                }
            }
        }
    }

    public static void main(String args[]) {
        try {
            int arraySet1[] = { 1, 2, 3, 4, 5 };
            int arraySet2[] = { 1, 2, 3, 6, 7, 9, 4, 5 };

            InSet set1 = new InSet(arraySet1);
            InSet set2 = new InSet(arraySet2);

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
