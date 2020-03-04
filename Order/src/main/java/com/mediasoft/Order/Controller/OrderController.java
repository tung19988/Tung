package com.mediasoft.Order.Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mediasoft.Order.Entity.Order;
import com.mediasoft.Order.Entity.SalesReport;
import com.mediasoft.Order.Service.OrderRepository;
import com.mediasoft.Order.Service.OrderService;

@CrossOrigin
@RestController
public class OrderController {

	@Autowired
	OrderRepository orderRe ;
	
	@Autowired
    OrderService service;

	
	@Autowired
	 private SequenceGeneratorService sequenceGeneratorService;
	 
	 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
	
	@RequestMapping(value = "/order", method = RequestMethod.GET)
	  public Collection<Order> getOrder() {	  
			return orderRe.findAll();
	}
	
//	@GetMapping(path = "/order1")
//    public ResponseEntity<List<Order>> getAllOrder(
//                        @RequestParam(defaultValue = "0") Integer pageNo, 
//                        @RequestParam(defaultValue = "2") Integer pageSize,
//                        @RequestParam(defaultValue = "orderDate") String sortBy) 
//    {
//        List<Order> list = service.getAllEmployees(pageNo, pageSize, sortBy);
// 
//        return new ResponseEntity<List<Order>>(list, new HttpHeaders(), HttpStatus.OK); 
//    }
	
	@RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
	  public Order getOrderId(@PathVariable("id") long id) {	  
			return orderRe.findByid(id);
	}
	
	 @RequestMapping(value = "/order", method = RequestMethod.POST , consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public  Order addOrder( @RequestBody Order or) {
		 
		 long id = this.sequenceGeneratorService.getMaxEmpId() + 1;
		 or.setId(id);
		 or.setOrderDate(LocalDate.now());
	     return  orderRe.save(or);
	  }
	 
	 @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	  public Order updateOrder(@RequestBody Order Register, @PathVariable("id") long id) {

		 Register.setId(id);	
	  	return orderRe.save(Register);
	  }
	 
	 @RequestMapping(value = "/order/{id}", method = RequestMethod.DELETE)
	  public void deleteid(@PathVariable("id") long id) {
		    orderRe.delete(orderRe.findByid(id));
		}
	 
	 @RequestMapping(value = "/orderdate/{start}/{end}", method = RequestMethod.GET)
	  public Collection<Order> getOrderday(@PathVariable("start") String s,@PathVariable("end") String e) throws ParseException {	  
			return service.getdate(s, e);
	}
	 
//	 @RequestMapping(value = "/orderdate1", method = RequestMethod.GET)
//	  public Collection<Order> getOrderda1() throws ParseException {	  
//			return service.getdate("20-02-2020", "26-02-2020");
//	}
	 
	 @GetMapping(path = "/getOrderPage")
	    public ResponseEntity<Page<Order>> getAllOrders(@RequestParam(defaultValue = "0") Integer pageNo) 
	    {
	        Page<Order> list = service.searchCustom(pageNo, 2, "orderDate");
	 
	        return new ResponseEntity<Page<Order>>(list, new HttpHeaders(), HttpStatus.OK); 
	    }
	 
	 @RequestMapping(value = "/ordertotal", method = RequestMethod.GET)
	  public Collection<SalesReport> gettotal(){
		 
			return service.gettotal();
	}
}
