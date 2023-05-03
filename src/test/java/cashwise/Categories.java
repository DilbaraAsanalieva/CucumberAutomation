package cashwise;

import org.junit.Test;
import utilities.APIRunner;

public class Categories {
    @Test
    public void updateDescriptions(){
        String getCategoryPath = "/api/myaccount/categories/income";
        APIRunner.runGetList(getCategoryPath);

        for(int i = 0; i< APIRunner.getResponseList().length;i++){
            String updatePath = "/api/myaccount/categories/"+APIRunner.getResponseList()[i].getId();



        }
    }
}
