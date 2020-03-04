package com.mediasoft.Login.Controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import java.util.UUID;

import org.apache.catalina.User;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.Login.Dao.CheckUserDao;
import com.mediasoft.Login.Dao.TimerDao;
import com.mediasoft.Login.Entity.JwtRequest;
import com.mediasoft.Login.Entity.ObjectToken;
import com.mediasoft.Login.Entity.UserDTO;
import com.mediasoft.Login.Service.UserRepository;

@CrossOrigin
@RestController
public class LoginController {
	@Autowired
	UserRepository dao;
	
	@Autowired
	CheckUserDao checkUser;
	
	TimerDao timedao;
	
	public static String generateString() {
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }
	
	protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 25) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
	
	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	
	ObjectToken obj ;
	
	Hashtable<String, Object> table = new Hashtable<String, Object>();
	
	@RequestMapping(value = "/login", method = RequestMethod.POST , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public UserDTO login(@RequestBody JwtRequest users) throws IOException {	
		
		UserDTO us = new UserDTO();
		UserDTO us1 = new UserDTO(null,false);
		
		
		 Date date = new Date();  
		us.settoken(generateString());
		
		if(checkUser.checkUser(users.getUsername()) == true && checkUser.checkPass(Base64.getEncoder().encodeToString(users.getPassword().getBytes()))==true ) {
			us.setstatus(true);
			obj = new ObjectToken(checkUser.getId(users.getUsername()),getexprValues(),getPropValues(),date.getTime(),date.getTime());
			table.put(us.gettoken(), obj);
//			return new String[] { users.getToken(), "True"};
			return us;
		
		}
		else {
			return us1;
		}

	}
	
	@RequestMapping(value = "/logout/{token}", method = RequestMethod.GET)
	public UserDTO logout(@PathVariable("token") String token) {
		UserDTO us = new UserDTO();
		us.setstatus(false);
			table.remove(token);
			
			return us;
	}
	
	@RequestMapping(value = "/show/{token}", method = RequestMethod.GET)
	public UserDTO show(@PathVariable("token") String token) {	
		
			ObjectToken  obj1 = (ObjectToken)table.get(token);
			UserDTO us = new UserDTO();
			
			if(timedao.activeTime(obj1.getLoginTime())>=obj1.getExprient()) {
				
				table.remove(token);
				us.setstatus(false);	
				return us ;
			}
			else {
				us.setstatus(true);
				return us;
			}

	}
	
	@RequestMapping(value = "/show1/{token}", method = RequestMethod.GET)
	public Object show1(@PathVariable("token") String token) {	
		
			Date date = new Date();
			ObjectToken  obj1 = (ObjectToken)table.get(token);
			UserDTO us = new UserDTO();
			
			if(timedao.activeTime(obj1.getlastActive())>=obj1.getTimeout()) {
				
				table.remove(token);
				us.setstatus(false);	
				return us ;
			}
			else {
			us.setstatus(true);
			obj1.setlastActive(date.getTime());
			table.replace(token, obj1);
			return dao.findById(obj1.getUser());
			}
			
	}
	
	@RequestMapping(value = "/showToken", method = RequestMethod.GET)
	public List<UserDTO> show() {	
//		Enumeration<String> enu = table.keys(); 
//		List<String> list = new ArrayList<String>();
//		while (enu.hasMoreElements()) { 
//			
//		  String b =	enu.nextElement(); 
//		  list.add(b);
//        } 
		
		List<UserDTO> list = new ArrayList<UserDTO>();
		Enumeration<String> enu = table.keys();
		while (enu.hasMoreElements()) {
			UserDTO a = new UserDTO(null,true) ;
			a.settoken(enu.nextElement());
			list.add(a);
		}
		return list;
	}
	
	@RequestMapping(value = "/settime", method = RequestMethod.POST , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public Integer show2(@RequestBody ObjectToken ob) throws ConfigurationException, IOException {	
		PropertiesConfiguration config = new PropertiesConfiguration("src\\main\\resources\\config.properties");
		config.setProperty("ot", ob.getTimeout());
		config.setProperty("exprient", ob.getExprient());
		config.save();
		return getPropValues();
	}
	
	Integer timeout,expr = 0;
	InputStream inputStream;
	
	public Integer getPropValues() throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			 timeout = Integer.parseInt(prop.getProperty("ot"));
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
       return timeout;
	}
	
	public Integer getexprValues() throws IOException {
		 
		try {
			Properties prop = new Properties();
			String propFileName = "config.properties";
 
			inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
 
			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
			}
 
			// get the property value and print it out
			 expr = Integer.parseInt(prop.getProperty("exprient"));
 
		} catch (Exception e) {
			System.out.println("Exception: " + e);
		} finally {
			inputStream.close();
		}
       return expr;
	}
	
	@RequestMapping(value = "/xyz")
    public Integer getName() throws IOException{
		
		return getPropValues();
    }

}