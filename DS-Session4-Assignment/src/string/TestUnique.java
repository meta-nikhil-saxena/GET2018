package string;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUnique {
	
    UniqueCharacterInString unique = new UniqueCharacterInString();

    @Test
    public void testUniqueue1() {
        unique.setStringRecieved("Nikhil");
        assertEquals(5, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue2() {
        unique.setStringRecieved("Ni");
        assertEquals(2, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue3() {
        unique.setStringRecieved("Niiiiii");
        assertEquals(2, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue4() {
        unique.setStringRecieved("Nikhilllllll");
        assertEquals(5, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue5() {
        unique.setStringRecieved("Nik");
        assertEquals(3, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue6() {
        unique.setStringRecieved("Nikhil Saxena");
        assertEquals(10, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue7() {
        unique.setStringRecieved("Hi Hello");
        assertEquals(5, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue8() {
        unique.setStringRecieved("Welcome");
        assertEquals(6, unique.CheckAndreturnUniqueNumberInString());
    }

    @Test
    public void testUniqueue9() {
        unique.setStringRecieved("Nikhil");
        assertEquals(5, unique.CheckAndreturnUniqueNumberInString());
    }

}
