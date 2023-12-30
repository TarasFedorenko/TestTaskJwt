package com.example.testtask;

import com.example.testtask.data.request.ProductsRequest;
import com.example.testtask.data.request.SignInRequest;
import com.example.testtask.data.request.SignUpRequest;
import com.example.testtask.entity.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TestTaskApplicationTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testAuthenticationController() throws Exception {
        SignUpRequest signUpRequest = new SignUpRequest("fullName", "username", "password");
        String signUpRequestBody = objectMapper.writeValueAsString(signUpRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(signUpRequestBody))
                .andExpect(status().isOk())
                .andReturn();

        SignInRequest signInRequest = new SignInRequest("username", "password");
        String signInRequestBody = objectMapper.writeValueAsString(signInRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/user/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(signInRequestBody))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").exists())
                .andReturn();
    }

    @Test
    @WithMockUser(username = "username", password = "password", roles = "USER")
    void testProductsController() throws Exception {
        Date product1 = new SimpleDateFormat("dd-MM-yyyy").parse("03-01-2023");
        Date product2 = new SimpleDateFormat("dd-MM-yyyy").parse("03-02-2023");
        ProductsRequest productsRequest = new ProductsRequest(Arrays.asList(
                new Product(product1, 11111,"Product1",20,"Paid"),
                new Product(product2, 11112,"Product2",10,"Paid")));
        String productsRequestBody = objectMapper.writeValueAsString(productsRequest);

        mockMvc.perform(MockMvcRequestBuilders.post("/products/add")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productsRequestBody))
                .andExpect(status().isOk())
                .andReturn();

        mockMvc.perform(MockMvcRequestBuilders.get("/products/list")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray())
                .andExpect(jsonPath("$.length()").value(2))
                .andReturn();
    }


}
