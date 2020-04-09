package com.hyp.task.file.up;

import com.alibaba.fastjson.JSONObject;
import com.hyp.task.file.common.GlobalException;
import com.hyp.task.file.common.ReturnMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@Service
public class LogUpService {

    public JSONObject logUpload(MultipartFile file) throws Exception {
        if (file == null || file.isEmpty()) {
            throw new GlobalException("未选择需上传的日志文件");
        }

        String filePath = new File("file").getAbsolutePath();
        File fileUpload = new File(filePath);
        if (!fileUpload.exists()) {
            fileUpload.mkdirs();
        }

        fileUpload = new File(filePath, file.getOriginalFilename());
        if (fileUpload.exists()) {
            throw new GlobalException("上传的日志文件已存在");
        }

        try {
            file.transferTo(fileUpload);

            return ReturnMessage.success();
        } catch (IOException e) {
            throw new Exception("上传日志文件到服务器失败：" + e.toString());
        }
    }
}
