package thunderbirdsonly.thunderbirdsonly.MybatisTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.mockito.Mockito;
import thunderbirdsonly.thunderbirdsonly.controller.PostsController;
import thunderbirdsonly.thunderbirdsonly.service.PostService;

import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(PostsController.class)
class PostsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PostService postService;

    @BeforeEach
    void setUp() {
        reset(postService); // Reset mock before each test
    }

    @Test
    void testGetAllPosts() throws Exception {
        when(postService.getAllPosts(0, 10))
                .thenReturn(Collections.emptyList()); // Mock behavior

        mockMvc.perform(get("/api/posts/all")
                        .param("page", "1")
                        .param("size", "10")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.status").value(1))
                .andExpect(jsonPath("$.data").isEmpty());

        verify(postService, times(1)).getAllPosts(0, 10);
    }

    @TestConfiguration
    static class TestConfig {
        @Bean
        public PostService postService() {
            return Mockito.mock(PostService.class);
        }
    }
}




