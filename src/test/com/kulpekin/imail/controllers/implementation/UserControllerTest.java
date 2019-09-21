package com.kulpekin.imail.controllers.implementation;

import com.kulpekin.imail.models.SMS;
import com.kulpekin.imail.service.interfaces.SMSServiceInterface;
import com.kulpekin.imail.service.interfaces.UserServiceInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.View;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import static org.hamcrest.beans.HasProperty.hasProperty;

@SpringBootTest
@Transactional
@Rollback
@RunWith(SpringRunner.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private SMSServiceInterface smsServiceInterface;

    @Mock
    private UserServiceInterface userServiceInterface;

    @Mock
    private View view;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(userController)
                .setSingleView(view)
                .build();
    }

    @Test
    public void homePage() {
//        List<SMS> ticketList = new ArrayList<>();
//        ticketList.add(expectedTicket);
//        when(ticketService.listTickets()).thenReturn(ticketList);
//        MvcResult mvcResult = mockMvc.perform(get(url))
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("ticket",ticketList.get(0)))
//                .andExpect(view().name("listTickets"))
//                .andReturn();
//        int resultStatusCode = mvcResult.getResponse().getStatus();
//        int expectedStatusCode = 200;
//        assertEquals(expectedStatusCode,resultStatusCode);
    }



}