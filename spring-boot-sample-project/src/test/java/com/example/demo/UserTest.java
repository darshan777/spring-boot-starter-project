package com.example.demo;
import com.example.demo.controller.UserController;
import com.example.demo.pojo.User;
import com.example.demo.repository.UserRRepository;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@RunWith(SpringRunner.class)
@WebMvcTest(value = UserController.class, secure = false)
public class UserTest {

    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    UserController userController;

    @Mock
    UserRRepository userRRepository;

    @Test
    public void testFindAll(){
        User u = new User();
        u.setFirstName("");
    }

    @Test
    public void testCreateUser(){
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        When(userRRepository.save(any(User.class))).thenReturn(true);

        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setEmail("a@gmail.com");
        user.setPassword("abc");


        Mockito.when(
                UserService.addCourse(Mockito.anyString(),
                        Mockito.any(User.class))).thenReturn(User);

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/user")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());

    }

    @Test
    public void testFindUser(){
        User user = new User();
        user.setFirstName("first");
        user.setLastName("last");
        user.setEmail("a@gmail.com");
        user.setPassword("abc");
        Mockito.when(
                studentService.retrieveCourse(Mockito.anyString(),
                        Mockito.anyString())).thenReturn(user);

        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/user/2").accept(
                MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());

    }
}
