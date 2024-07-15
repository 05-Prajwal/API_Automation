package StepDefinations;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.example.Configure;

public class Hook{
    @Before
    public void setup(){
        System.out.println("Before Triggered");
        Configure.loadConfigure();
    }
    @After
    public void teardown(){
        System.out.println("After triggered");
    }
}
