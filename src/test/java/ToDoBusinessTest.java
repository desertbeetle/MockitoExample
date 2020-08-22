import com.javalab.todo.ToDoBusiness;
import com.javalab.todo.ToDoService;
import com.javalab.todo.ToDoStubSerivce;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

public class ToDoBusinessTest {

    /**
     *  There are a lot of maintenance problems using stubs.
     *  For example, if we want to add a new method or delete
     *  an existing method to/from the ToDoService interface,
     *  we need to keep track on the stub related to this interface.
     *  Another problem with stubs is the dynamic conditions that
     *  makes the code more complicated.
     *
     */

    @Test
    public void testUsingStub() {
        ToDoService service = new ToDoStubSerivce();
        ToDoBusiness business = new ToDoBusiness(service);
        Assert.assertEquals(2, business.getToDosForSpring("Leo").size());
    }

    /**
     * We are going to test with mock objects.
     * Notice we can specify the value to return over a mock object method
     * using when... thenReturn...
     * More flexible than using a stub.
     */

    @Test
    public void testUsingMock() {
        ToDoService mockService = mock(ToDoService.class);
        ToDoBusiness business = new ToDoBusiness(mockService);
        List<String> combinedlist = Arrays.asList(" Use Core Java ", " Use Spring Core ",
                " Use w3eHibernate ", " Use Spring MVC ");
        when(mockService.getTodos("dummy")).thenReturn(combinedlist);

        Assert.assertEquals(2, business.getToDosForSpring("dummy").size());
    }

    /**
     * We can assure the a method is indeed get called
     * using verify()
     */


    @Test
    public void deleteTest() {
        ToDoService mockService = mock(ToDoService.class);
        ToDoBusiness business = new ToDoBusiness(mockService);
        business.deleteToDo("dummy");
        verify(mockService).deleteTodo("dummy");
    }

    /**
     * To verify a method is not get all.
     * To make this test fail change ToDoBusiness to call deleteAllTodos()
     */
    @Test
    public void deleteShouldNotInvokeDeleteAllTodosTest() {
        ToDoService mockService = mock(ToDoService.class);
        ToDoBusiness business = new ToDoBusiness(mockService);
        business.deleteToDo("dummy");
        verify(mockService, never()).deleteAllTodos();
    }
}
