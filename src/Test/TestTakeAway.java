package Test;

import Model.TakeAway;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;

public class TestTakeAway {

    TakeAway testTakeAway;

    @Before
    public void setup(){
        testTakeAway = new TakeAway();

    }

    //Todo: method testOrderNoName to check whether i can place order without a name.
    // outcome: I shall not be able to.
    @Test
    public void testOrderNoName(){
        testTakeAway.order();
        assertTrue((testTakeAway.getName())!=null);
    }

    //todo: testComboID, entering the values from the required list
    // outcome: should be b/a A and D or '\u0000' (default char value)
    @Test
    public void testComboID(){
        testTakeAway.setComboID('D');
        assertEquals(testTakeAway.getComboID(),'D');

        testTakeAway.setComboID('E');
        System.out.println(testTakeAway.getComboID());
        assertEquals(testTakeAway.getComboID(),'\u0000');
    }

    // todo: testCustomerID comparing the customerIDs of main TakeAwaya and the one we'll create.
    // outcome: new customer's customer id should be one more than the main one
    @Test
    public void testCustomerID(){
        TakeAway newTA = new TakeAway();
        System.out.print("old Customer: " +testTakeAway.getCustomerID() + "new Customer: " + newTA.getCustomerID());
        assertTrue(testTakeAway.getCustomerID()+1==newTA.getCustomerID());
    }
    
    //Todo: testPriceBasedOnComboID giving comboID's in and out of bound.
    // outcome: price for in bound comboID's should vary accordingly and
    //          for out of bound price must remain 30 Rs.
    @Test
    public void testPriceBasedOnComboID(){
        testTakeAway.setComboID('A');
        assertEquals(testTakeAway.getPrice(),25.0);
        testTakeAway = new TakeAway();
        testTakeAway.setComboID('C');
        assertEquals(testTakeAway.getPrice(),15.0);
        testTakeAway = new TakeAway();
        testTakeAway.setComboID('E');
        assertEquals(testTakeAway.getPrice(),30.0);

    }
}

