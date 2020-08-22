import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    @Test
    public void testList_Size() {
        List mockList = mock(List.class);
        when(mockList.size()).thenReturn(1);
        Assert.assertEquals(1, mockList.size());
    }

    @Test
    public void testList_Get() {
        List mockList = mock(List.class);
        when(mockList.get(0)).thenReturn("Hello");
        Assert.assertEquals("Hello", mockList.get(0));
    }
}
