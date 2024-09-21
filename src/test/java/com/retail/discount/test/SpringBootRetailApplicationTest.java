package com.retail.discount.test;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

@SpringBootTest
@AutoConfigureMockMvc
class SpringBootRetailApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testProcessBillForEmployee() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"100\",\"items\":[{\"itemName\":\"Mobile\",\"price\":\"500\"},{\"itemName\":\"Soap\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("850.0"));

	}

	@Test
	public void testProcessBillForAffiliate() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"103\",\"items\":[{\"itemName\":\"Mobile\",\"price\":\"500\"},{\"itemName\":\"Soap\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("950.0"));

	}

	@Test
	public void testProcessBillForCustomer() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"104\",\"items\":[{\"itemName\":\"Mobile\",\"price\":\"500\"},{\"itemName\":\"Soap\",\"price\":\"490\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("945.0"));

	}

	@Test
	public void testProcessBillForTwoYearOldCustomer() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"102\",\"items\":[{\"itemName\":\"Mobile\",\"price\":\"500\"},{\"itemName\":\"Soap\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("975.0"));

	}

	@Test
	public void testProcessBillForGroceryItem() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"102\",\"items\":[{\"itemName\":\"Oil\",\"price\":\"500\"},{\"itemName\":\"Soap\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("1000.0"));

	}

	@Test
	public void testProcessBillForNonGroceryItem() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"102\",\"items\":[{\"itemName\":\"Charger\",\"price\":\"500\"},{\"itemName\":\"Mobile\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk())

				.andExpect(jsonPath("$.payableAmount").value("950.0"));

	}

	@Test
	public void testProcessBillWhenItemIsBlank() throws Exception {

		// Arrange
		String userJson = "{\"billNumber\":\"123\",\"userID\":\"102\",\"items\":[{\"itemName\":\"\",\"price\":\"500\"},{\"itemName\":\"Mobile\",\"price\":\"500\"}]}";

		// Act
		ResultActions result = mockMvc.perform(get("http://localhost:8080/api/generatebill")
				.contentType(MediaType.APPLICATION_JSON).content(userJson));

		// Assert
		result.andExpect(status().isOk()).andExpect(jsonPath("$.payableAmount").value("975.0"));

	}

}
