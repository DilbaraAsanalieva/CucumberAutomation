package cashwise;

import org.junit.Assert;
import org.junit.Test;
import utilities.APIRunner;

public class Expenses {

    @Test
    public void seller(){
        String path = "/api/myaccount/sellers/394";
        APIRunner.runGET(path);
//        Assert.assertNotNull();
    }
}
