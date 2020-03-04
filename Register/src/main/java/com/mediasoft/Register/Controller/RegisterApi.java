package com.mediasoft.Register.Controller;

import java.time.LocalDate;
import java.util.Base64;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.Register.Entity.Register;
import com.mediasoft.Register.Service.RegisterRepository;
import com.mediasoft.Register.Service.SequenceGeneratorService;
import com.mediasoft.Register.dao.TokenidDao;

@CrossOrigin
@RestController
public class RegisterApi {
	@Autowired
	RegisterRepository regRe;
	
	@Autowired
	TokenidDao tdao;
	
	 @Autowired
	 private SequenceGeneratorService sequenceGeneratorService;
	
	
	private static final AtomicLong TS = new AtomicLong();
	public static long getUniqueTimestamp() {
	    long micros = System.currentTimeMillis() * 1000;
	    for ( ; ; ) {
	        long value = TS.get();
	        if (micros <= value)
	            micros = value + 1;
	        if (TS.compareAndSet(value, micros))
	            return micros;
	    }
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	  public Collection<Register> getRegister() {	  
			return regRe.findAll();
	}
	
	@RequestMapping(value = "/register/{id}", method = RequestMethod.GET)
	  public Register getRegisterId(@PathVariable("id") long id) {	  
			return regRe.findByid(id);
	}
	
	 @RequestMapping(value = "/register", method = RequestMethod.POST , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public  Register addRegister( @RequestBody Register re) {
		 long id = this.sequenceGeneratorService.getMaxEmpId() + 1;
		 re.setid(id);
		 re.setPass(Base64.getEncoder().encodeToString(re.getPass().getBytes()));
		 re.setRegister_date(LocalDate.now());
		 re.setToken_id(getUniqueTimestamp());
	      return  regRe.save(re);
	  }
	 
	 @RequestMapping(value = "/register/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public Register updateRegister(@RequestBody Register Register, @PathVariable("id") long id) {

		
		 Register.setid(id);
		 Register.setPass(Base64.getEncoder().encodeToString(Register.getPass().getBytes()));
	  	
	  	return regRe.save(Register);
	  }
	 
	 @PutMapping(path = "/register/{token_id}/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE},produces ={ MediaType.APPLICATION_JSON_VALUE})
	  public Register updateToken_num(@RequestBody Register t, @PathVariable("id") long id, @PathVariable("token_id") long token) {

		 Register re = regRe.findByid(id);
		  re = regRe.findBytoken(token);
	  	re.setid(id);
	  	re.setToken_id(0);
	  	
	  	return regRe.save(re);

	  }

	 @RequestMapping(value = "/register/{id}", method = RequestMethod.DELETE)
	  public void deleteid(@PathVariable("id") long id) {
		    regRe.delete(regRe.findByid(id));
		}
	 
	
}
