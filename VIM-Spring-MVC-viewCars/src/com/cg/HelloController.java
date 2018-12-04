package com.cg;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cg.beans.CarDTO;
import com.cg.dao.CarDAO;

@Controller
@RequestMapping("/*")
public class HelloController {

	@RequestMapping(method=RequestMethod.GET, value="hello")
	@ResponseBody
	public String sayHello(){
		return "Hello, world!!!";
	}
	
	@Autowired
	private CarDAO carDAO;
	
	@RequestMapping(method=RequestMethod.GET, value="controller")
//	@ResponseBody
	public String getCarMake(@RequestParam("action") String action){
		if(action.equals("viewCarList")){
			return "carList";
		}
		
		return carDAO.findAll().get(0).getMake();
	}
	
	@ModelAttribute("carList")
	public List<CarDTO> getCars(){
		return carDAO.findAll();
	}
	
	
	
	
	
	
	
	
	
}
