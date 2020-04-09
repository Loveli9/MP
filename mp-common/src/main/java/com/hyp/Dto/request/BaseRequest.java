package com.hyp.Dto.request;

import com.alibaba.fastjson.annotation.JSONField;
import com.hyp.Dto.entity.BaseEntity;
import org.apache.commons.lang3.StringUtils;
import java.util.UUID;

public class BaseRequest extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @JSONField(label = "essential")
    private String            requestId;

    private String            userId;

    public String getRequestId() {
        if (StringUtils.isBlank(requestId)) {
            requestId = (UUID.randomUUID()).toString();
        }
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
