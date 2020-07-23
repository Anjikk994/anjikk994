package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class RentProcessTaskimpl implements RentProcessService {

	 @Override
	    public boolean validateDL(String dlNumber) {
	        return dlNumber.length() > 5;
	    }


}
