package com.grimolizzi.hogwarts.wizards;

import com.grimolizzi.hogwarts.generics.GenericController;
import com.grimolizzi.hogwarts.model.Wizard;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/wizards")
public class WizardController extends GenericController<Wizard> {

	public WizardController(Class<Wizard> type) {
		super.type = type;
	}
}
