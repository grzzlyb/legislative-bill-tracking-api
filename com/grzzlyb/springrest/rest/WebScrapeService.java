package com.grzzlyb.springrest.rest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import com.grzzlyb.springrest.entity.Bill;

@Service
public class WebScrapeService {

	public List<Bill> scrapWebsite() {
		
		List<Bill> theBills = new ArrayList<>();
		final String url = "https://prsindia.org/billtrack";

		try {
			final Document doc = Jsoup.connect(url).get();
			Elements data = doc.select("div.views-row");

			for (Element element : data) {
				
				String billName = element.select("h3.cate").text();
				String billStatus = element.select("span.status-pending").text();
				Bill billObj = new Bill(billName, billStatus);
				theBills.add(billObj);
			}
		} 
		catch (IOException exc) {
			exc.printStackTrace();
		}

		return theBills;
	}
	
}
