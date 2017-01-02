package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin
@RestController
public class ParamController {
	
	static Logger log = LoggerFactory.getLogger(ParamController.class);
	
	@RequestMapping(value = "/paramQuery", method = {RequestMethod.GET, RequestMethod.POST})
	public String param(
			@RequestParam(name = "paramList", required = true) String paramList,
			@RequestParam(name = "type", required = true) String type) {
		
		log.info("-----paramQuery paramList:{} type:{} ", paramList, type);
		
		return paramList;
	}

}
