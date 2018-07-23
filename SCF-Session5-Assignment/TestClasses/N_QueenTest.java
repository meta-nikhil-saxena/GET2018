package TestClasses;

import static org.junit.Assert.*;

import org.junit.Test;

import AssignmentClasses.N_Queen;

public class N_QueenTest {

    N_Queen operation = new N_Queen();
    
    int case1Board[][] = { { 0, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 0, 0 },
            { 0, 0, 0, 0 } };
    int case1ExpectedBoard[][] = { { 0, 0, 1, 0 }, { 1, 0, 0, 0 },
            { 0, 0, 0, 1 }, { 0, 1, 0, 0 } };
    
    @Test
    public void Test1(){
        assertArrayEquals(case1ExpectedBoard, operation.N_Queen_Board(case1Board));
    }

}
