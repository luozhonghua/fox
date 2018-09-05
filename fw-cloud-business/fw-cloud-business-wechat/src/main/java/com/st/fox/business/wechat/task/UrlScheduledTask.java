package com.st.fox.business.wechat.task;

import com.st.fox.business.wechat.service.UrlInfoService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UrlScheduledTask {

	@Autowired
	private UrlInfoService urlInfoService;

	@Scheduled(cron = "0 0/50 * * * ?")
	public void execUrlScheduledTask() {
		log.info("【execUrlScheduledTask】:清除失效数据记录");
		long l = urlInfoService.clearAllExpire();
		log.info("【execUrlScheduledTask】:清除失效数据记录size|" + l);
	}

}
