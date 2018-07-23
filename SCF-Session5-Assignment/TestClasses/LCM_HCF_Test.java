package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import AssignmentClasses.LCMandHCF;

public class LCM_HCF_Test {
    LCMandHCF operation = new LCMandHCF();
    int case1Number1 = 5, case1Number2 = 6;
    int case2Number1 = 4, case2Number2 = 16;
    int case3Number1 = 6, case3Number2 = 14;
    int case4Number1 = 9, case4Number2 = 3;

    @Test
    public void test1_For_LCM() {
        int actualCase = operation.lcm(case1Number1, case1Number2);
        assertEquals(30, actualCase);
    }

    @Test
    public void test2_For_LCM() {
        int actualCase = operation.lcm(case2Number1, case2Number2);
        assertEquals(16, actualCase);
    }

    @Test
    public void test3_For_LCM() {
        int actualCase = operation.lcm(case3Number1, case3Number2);
        assertEquals(42, actualCase);
    }

    @Test
    public void test4_For_LCM() {
        int actualCase = operation.lcm(case4Number1, case4Number2);
        assertEquals(9, actualCase);
    }

    // Test cases for HCF

    @Test
    public void test1_For_HCF() {
        int actualCase = operation.hcf(case1Number1, case1Number2);
        assertEquals(1, actualCase);
    }

    @Test
    public void test2_For_HCF() {
        int actualCase = operation.hcf(case2Number1, case2Number2);
        assertEquals(4, actualCase);
    }

    @Test
    public void test3_For_HCF() {
        int actualCase = operation.hcf(case3Number1, case3Number2);
        assertEquals(2, actualCase);
    }

    @Test
    public void test4_For_HCF() {
        int actualCase = operation.hcf(case4Number1, case4Number2);
        assertEquals(3, actualCase);
    }

}
