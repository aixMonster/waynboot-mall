package com.wayn.common.core.service.tool;


import com.baomidou.mybatisplus.extension.service.IService;
import com.wayn.common.core.entity.tool.EmailConfig;

public interface IMailConfigService extends IService<EmailConfig> {

    boolean checkMailConfig(EmailConfig emailConfig);
}
