package com.whu.librarylendingplatform;


import com.whu.librarylendingplatform.controller.RequestController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author: Colin
 * @Date: 2020/11/8 16:19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = MockServletContext.class)
public class LibrarylendingplatformTests {
    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new RequestController()).build();
    }

    @Test
    public void testRequestController() throws Exception {
        RequestBuilder request = null;

        // 1、get查一下request列表，应该为空
        request = get("/requests/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
        // 2、post提交一个request
        request = post("/requests/")
                .param("requestId", "1")
                .param("stuId", "18001")
                .param("bookName", "HigherMathematics")
                .param("bookPress", "WHU");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 3、get获取request列表，应该有刚才插入的数据
        request = get("/requests/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[{\"requestId\":1,\"stuId\":18001,\"bookName\":\"HigherMathematics\",\"bookPress\":\"WHU\"}]")));

        // 4、put修改requestId为1的request
        request = put("/requests/1")
                .param("stuId","18002")
                .param("bookName", "LinearAlgebra")
                .param("bookPress", "TONGJIU");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 5、get一个requestId为1的request
        request = get("/requests/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("{\"requestId\":1,\"stuId\":18002,\"bookName\":\"LinearAlgebra\",\"bookPress\":\"TONGJIU\"}")));

        // 6、del删除requestId为1的request
        request = delete("/requests/1");
        mvc.perform(request)
                .andExpect(content().string(equalTo("success")));

        // 7、get查一下request列表，应该为空
        request = get("/requests/");
        mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
    }

}
