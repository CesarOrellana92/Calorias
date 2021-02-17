package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.core.StringContains.containsString;

@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void calculaCaloriasTest() throws Exception {
		this.mockMvc.perform(post("/caloriasTotal")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"nombre\": \"Guiso\",\n" +
						"    \"ingredientes\" : [\n" +
						"        {\n" +
						"            \"nombre\":\"Ajos\",\n" +
						"            \"peso\":50\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Cebolla\",\n" +
						"            \"peso\":500\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Perejil\",\n" +
						"            \"peso\":50\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Pimiento\",\n" +
						"            \"peso\":250\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Tomates\",\n" +
						"            \"peso\":500\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Zanahoria\",\n" +
						"            \"peso\":250\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("{\"nombre\":\"Guiso\",\"caloriaTotal\":105.0}")));
	}

	@Test
	void getIngredientes() throws Exception {
		this.mockMvc.perform(post("/ingredientes")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\n" +
						"    \"nombre\": \"Guiso\",\n" +
						"    \"ingredientes\" : [\n" +
						"        {\n" +
						"            \"nombre\":\"Ajos\",\n" +
						"            \"peso\":50\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Cebolla\",\n" +
						"            \"peso\":500\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Perejil\",\n" +
						"            \"peso\":50\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Pimiento\",\n" +
						"            \"peso\":250\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Tomates\",\n" +
						"            \"peso\":500\n" +
						"        },\n" +
						"        {\n" +
						"            \"nombre\":\"Zanahoria\",\n" +
						"            \"peso\":250\n" +
						"        }\n" +
						"    ]\n" +
						"}"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(containsString("[" +
						"{\"name\":\"Ajos\"," +
						"\"calories\":84.5}," +
						"{\"name\":\"Cebolla\"," +
						"\"calories\":235.0}," +
						"{\"name\":\"Perejil\"," +
						"\"calories\":27.5}," +
						"{\"name\":\"Pimiento\"," +
						"\"calories\":55.0}," +
						"{\"name\":\"Tomates\"," +
						"\"calories\":110.0}," +
						"{\"name\":\"Zanahoria\"," +
						"\"calories\":105.0}]")));
	}

}
