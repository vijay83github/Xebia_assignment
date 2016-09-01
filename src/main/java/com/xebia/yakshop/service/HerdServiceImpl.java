package com.xebia.yakshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xebia.yakshop.model.Herd;
import com.xebia.yakshop.model.Yak;
import com.xebia.yakshop.utils.ProductCalculator;
import com.xebia.yakshop.utils.YakshopConstants;

@Service("herdService")
public class HerdServiceImpl implements HerdService, YakshopConstants{
	
	
	@Autowired
	HerdReader herdReader;
	
	@Autowired
	ProductCalculator productCalculator;

	@Override
	public Herd findAllYaks(Integer elapsedDays) {
		Herd herd = herdReader.readList(HERD_XML);
		return	updateAgeWithElapsedDays(herd,elapsedDays);
	}

	private Herd updateAgeWithElapsedDays(Herd herd, Integer elapsedDays) {
		Yak[] yaks =  herd.getYaks();
		for (Yak yak : yaks) {
			float elapsedAge = (elapsedDays)*DAYS_TO_YEARS_FACTOR;
			int daysToShave = productCalculator.calculateDaysToShave(yak.getAge(),(elapsedDays-CURRENT_DAY));
			yak.setLastShaved(yak.getAge());
			int shavingDone = (elapsedDays-CURRENT_DAY)/(daysToShave+DAYS_REQUIRED_TO_SHAVE);
			if(shavingDone>0){
				yak.setLastShaved(yak.getAge()+ (shavingDone*daysToShave*DAYS_TO_YEARS_FACTOR));
			}
			yak.setAge(yak.getAge()+elapsedAge);
		}
		return herd;
	}
	

}
