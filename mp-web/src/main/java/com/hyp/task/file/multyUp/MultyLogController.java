package com.hyp.task.file.multyUp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/batch")
public class MultyLogController {

    @Autowired
    private MultyLogService logService;

    /**
     * 批量上传日志接口
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload")
    public String logUploads(HttpServletRequest request) throws Exception {
        return logService.logUploads(request);
    }

}
