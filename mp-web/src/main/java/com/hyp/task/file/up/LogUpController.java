package com.hyp.task.file.up;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/log")
public class LogUpController {

    @Autowired
    private LogUpService logService;

    /**
     * 上传日志接口
     *
     * @param file
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/upload")
    public JSONObject logUpload(@RequestParam("file") MultipartFile file) throws Exception {
        return logService.logUpload(file);
    }

}
