package fr.mayccos.stock;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.mayccos.stock.pojo.Product;
import fr.mayccos.stock.service.ProductService;
import fr.mayccos.stock.ws.ProductWs;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@WebMvcTest(ProductWs.class)
class StockApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProductService productService;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testGetProducts() throws Exception {

        mockMvc.perform(get("/api/product"))
                .andExpect(status().isOk());
    }

    @Test
    public void createProduct() throws Exception {
        Product myProduct = new Product("stylo", "cest un beau stylo", 1.2F, 5);

        mockMvc.perform(post("/api/product")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(myProduct)))
                .andExpect(status().isOk());

    }

}
