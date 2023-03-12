package com.grzzlyb.springrest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grzzlyb.springrest.entity.Bill;

@RestController
@RequestMapping("/api")
public class BillRestController {

	@Autowired
	private WebScrapeService webScrapeService;

	@GetMapping("/bills")
	public List<Bill> getBills() {

		List<Bill> theBills = webScrapeService.scrapWebsite();
		return theBills;
	}

	@GetMapping("/bills/{billStatus}")
	public List<Bill> getMatchingBills(@PathVariable String billStatus) {

		List<Bill> theBills = webScrapeService.scrapWebsite();
		List<Bill> matchingBills = new ArrayList<>();

		for (Bill bill : theBills) {
			if (bill.getBillStatus().toLowerCase().equals(billStatus)) {
				matchingBills.add(bill);
			}
		}
		
		if (matchingBills.isEmpty()) {
			throw new BillNotFoundException("Bills not found.");
		}

		return matchingBills;
	}
}
