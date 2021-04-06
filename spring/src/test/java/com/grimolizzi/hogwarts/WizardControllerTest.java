package com.grimolizzi.hogwarts;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import com.grimolizzi.hogwarts.generics.GenericService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.grimolizzi.hogwarts.model.House;
import com.grimolizzi.hogwarts.model.Wizard;
import com.grimolizzi.hogwarts.wizards.WizardController;

@RunWith(SpringRunner.class)
@WebMvcTest(WizardController.class)
public class WizardControllerTest {

	private static final String URL_TEMPLATE = "/wizards";
	
	private static final String WIZARD_1_ID = "001";
	private static final String WIZARD_1_NAME = "Harry";
	private static final String WIZARD_1_SURNAME = "Potter";
	private static final String WIZARD_2_ID = "002";
	private static final String WIZARD_2_NAME = "Draco";
	private static final String WIZARD_2_SURNAME = "Malfoy";
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private GenericService<Wizard> service;
	
	@Test
	public void shouldGetAll() throws Exception {
		
		given(this.service.getAll()).willReturn(getMockList());

		this.mvc.perform(get(URL_TEMPLATE)
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(2)))
				.andExpect(jsonPath("$[0].name", equalTo(WIZARD_1_NAME)))
				.andExpect(jsonPath("$[0].surname", equalTo(WIZARD_1_SURNAME)))
				.andExpect(jsonPath("$[0].house", equalTo(House.GRYFFINDOR.toString())))
				.andExpect(jsonPath("$[1].name", equalTo(WIZARD_2_NAME)))
				.andExpect(jsonPath("$[1].surname", equalTo(WIZARD_2_SURNAME)))
				.andExpect(jsonPath("$[1].house", equalTo(House.SLYTHERIN.toString())));
	}
	
	@Test
	public void shouldGetById() throws Exception {
		
		Wizard mockedWizard = getMockList().get(0);
		
		given(this.service.get(mockedWizard.getId())).willReturn(mockedWizard);
		
		this.mvc.perform(get(URL_TEMPLATE)
				.param("id", mockedWizard.getId())
				.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(1)))
				.andExpect(jsonPath("$[0].name", equalTo(mockedWizard.getName())))
				.andExpect(jsonPath("$[0].surname", equalTo(mockedWizard.getSurname())))
				.andExpect(jsonPath("$[0].house", equalTo(mockedWizard.getHouse().toString())));
	}
	
	@Test
	public void shouldPost() throws Exception {
		
		Wizard mockedWizard = getMockList().get(0);
		
		String jsonBody = new ObjectMapper()
				.writeValueAsString(mockedWizard);
		
		this.mvc.perform(post(URL_TEMPLATE)
				.content(jsonBody)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(status().isOk());
		
		verify(this.service).create(mockedWizard);
	}
	
	private static List<Wizard> getMockList() {
		
		List<Wizard> list = new ArrayList<>();
		list.add(new Wizard(WIZARD_1_ID, WIZARD_1_NAME, WIZARD_1_SURNAME, House.GRYFFINDOR));
		list.add(new Wizard(WIZARD_2_ID, WIZARD_2_NAME, WIZARD_2_SURNAME, House.SLYTHERIN));
		return list;
	}
}
