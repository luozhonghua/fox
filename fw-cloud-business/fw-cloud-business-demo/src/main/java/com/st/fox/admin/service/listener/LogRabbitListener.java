package com.st.fox.admin.service.listener;

/*import com.st.fox.core.beans.system.AuthLog;
import com.st.fox.core.commons.constants.MqQueueConstant;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;*/
import org.springframework.stereotype.Component;

/**
 * Created by luozhonghua on 2018/8/16.
 */
@Component
//@RabbitListener(queues = MqQueueConstant.LOG_QUEUE)
public class LogRabbitListener {

    //@Autowired
   // private LogService logService;

    //@RabbitHandler
    public void receive(/*AuthLog authLog*/) {
       /* Log sysLog = authLog.getLog();
        MDC.put(CommonConstant.KEY_USER, authLog.getLog().getCreateBy());
        Date currentDate = new Date();
        if (null == sysLog.getCreateTime()) sysLog.setCreateTime(currentDate);
        if (null == sysLog.getUpdateTime()) sysLog.setUpdateTime(currentDate);
        SysAdminLog logInfo = new SysAdminLog();
        BeanUtils.copyProperties(sysLog, logInfo);
        logService.saveOrUpdate(logInfo);
        MDC.remove(CommonConstant.KEY_USER);*/
    }

}
