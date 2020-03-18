import com.bootcamp.test.tdd.*;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class FamilyTreeTest {

    @Test
    public void getSiblingistTest(){
        FamilyTree familyTree = new FamilyTree();

        List<Person> relations = familyTree.getSiblings("ahit");
        assertEquals(1, relations.size());
    }


    @Test(expected = InvalidPersonException.class)
    public void getInvalidPersonExceptionTest(){
        FamilyTree familyTree = new FamilyTree();
        List<Person> relations = familyTree.getSiblings("murugan");
        assertEquals(1, relations.size());
    }

    @Test
    public void getPaternalUncleTest(){
        FamilyTree familyTree = new FamilyTree();
        List<Person> relations = familyTree.getPaternalUncle("ahit");
        assertEquals(4, relations.size());
    }

    @Test(expected = RecordNotFoundForMember.class)
    public void getPaternalUncleForAbandonmemberTest(){
        FamilyTree familyTree = new FamilyTree();
        familyTree.getPaternalUncle("arit");
    }

    @Test(expected = RecordNotFoundForMember.class)
    public void getPaternalUncleForAbandonmember2Test(){
        FamilyTree familyTree = new FamilyTree();
        familyTree.getPaternalUncle("aras");
    }

    @Test
    public void getSisterInLawTest(){
        FamilyTree familyTree = new FamilyTree();
        List<Person> relations  = familyTree.getSisterInLaw("ish");
        assertEquals(4, relations.size());
    }

}
