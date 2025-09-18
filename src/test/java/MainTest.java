import org.example.Main;
import org.example.TesztversenyHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class MainTest {
    @Before
    public void testBefore() {
        Main.isRunningTest = true;
    }

    @Test
    public void testMain() throws IOException {
        Main.main(null);
    }

    @Test
    public void testHandler() {
        TesztversenyHandler handler = new TesztversenyHandler();
        handler.setValaszok(handler.getValaszok());
        handler.valaszai("bullshit");
    }

    @After
    public void testAfter() {
        Main.isRunningTest = false;
    }
}
