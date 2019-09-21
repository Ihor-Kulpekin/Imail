package com.kulpekin.imail.controllers.implementation;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.View;

import static org.junit.Assert.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.beans.HasProperty.hasProperty;
import static org.hamcrest.core.IsInstanceOf.instanceOf;

@SpringBootTest
@RunWith(SpringRunner.class)
public class LoginControllerTest {

    @InjectMocks
    private LoginController loginController;

    @Mock
    private View view;

    private MockMvc mockMvc;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(loginController)
                .setSingleView(view)
                .build();
    }

    @Test
    public void loginInSystemTest() throws Exception {
      String url = "/login";
      String namePage = "login";
      MvcResult mvcResult = mockMvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(view().name(namePage))
                .andReturn();

      int resultStatus = mvcResult.getResponse().getStatus();
      int expectedStatus = 200;
      assertEquals(expectedStatus,resultStatus);
    }
}