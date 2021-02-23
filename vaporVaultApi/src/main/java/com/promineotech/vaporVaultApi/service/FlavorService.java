package com.promineotech.vaporVaultApi.service;

import java.util.NoSuchElementException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.promineotech.vaporVaultApi.entity.Flavor;
import com.promineotech.vaporVaultApi.repository.FlavorRepository;

@Service
public class FlavorService {

	private static final Logger logger = LogManager.getLogger(FlavorService.class);
	
	@Autowired
	private FlavorRepository repo;
	
	public Iterable<Flavor> GetFlavors() {
		return repo.findAll();
	}
	
	public Flavor createProduct(Flavor flavor) {
		return repo.save(flavor);
	}
	
	public Flavor updateProduct(Flavor flavor, Long id) {
		logger.info("Updating product {}" + flavor);
		Flavor oldFlavor = repo.findById(id)
					.orElseThrow(() -> new NoSuchElementException("Can't find prodcuct with id:" + id));
			
			oldFlavor.setName(flavor.getName());
			return repo.save(oldFlavor);
		
	}
	
	public void removeProduct(Long id) throws Exception {
		try {
			repo.deleteById(id);			
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete product: " + id, e);
			throw new Exception("Unable to delete product.");
		}
	}
		
}