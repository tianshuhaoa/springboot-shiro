package com.example.demo;

import com.example.demo.common.Result;
import com.example.demo.web.IndexController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.bind.annotation.RequestMapping;
import junit.framework.*;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.ApplicationContext;

import static sun.plugin.util.ProgressMonitor.get;


@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
//@WebMvcTest(value = IndexController.class)
public class IndexControllerTests extends TestCase{

    private MockMvc mockMvc;

    @Autowired
    WebApplicationContext wac;



    @Before
    public void setup(){
        this.mockMvc=MockMvcBuilders.standaloneSetup(new IndexController()).build();
    }

    @Test
    public void testIndex() throws Exception{
       MvcResult r= mockMvc.perform(MockMvcRequestBuilders.get("/index")).andExpect(MockMvcResultMatchers.status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();
       System.out.println(r.getResponse().getContentAsString());

    }

    @Test
    public void testLogin() throws Exception{
        MvcResult r= mockMvc.perform(MockMvcRequestBuilders.get("/login?userName=aaaa")).andExpect(MockMvcResultMatchers.status().isOk())
                //.andDo(MockMvcResultHandlers.print())
                .andReturn();
        System.out.println(r.getResponse().getContentAsString());

    }


}
