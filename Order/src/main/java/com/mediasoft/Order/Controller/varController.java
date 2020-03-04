package com.mediasoft.Order.Controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.Order.Entity.Variants;
import com.mediasoft.Order.Service.VarRe;

@CrossOrigin
@RestController
public class varController {
	
	@Autowired
	VarRe vaRe ;
	
	@Autowired
	 private SequenceGeneratorService sequenceGeneratorService;
	
	
	@RequestMapping(value = "/var", method = RequestMethod.GET)
	  public Collection<Variants> getvar() {	  
			return vaRe.findAll();
	}
	 @RequestMapping(value = "/var", method = RequestMethod.POST , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public  Variants addvar( @RequestBody Variants var) {
		 long id = this.sequenceGeneratorService.getMaxEmpId() + 1;
		 var.setId(id);
	     return  vaRe.save(var);
	  }
}
