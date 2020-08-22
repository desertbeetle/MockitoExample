import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.spy;

public class SpyTest {

    /**
     * that the spy creates a partial mock of the real object.
     * The spy() method let the real action continue to happen
     * except the stuff where they want to change the behavior.
     * It means spy() method allows us to keep track of what is
     * happening with the real object as well as allow us to
     * overrides a specific behavior.
     */
    @Test
    public void spyTest1() {
        List spyList = spy(ArrayList.class);
        Assert.assertEquals(0, spyList.size());
        spyList.add("hello");
        Assert.assertEquals(1, spyList.size());

    }
}
