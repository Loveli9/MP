package com.hyp.task.file.multyUp;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class MultyLogService {

    public String logUploads(HttpServletRequest request) throws Exception {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        BufferedOutputStream stream = null;
        for (MultipartFile file : files) {
            if(!file.isEmpty()) {
                try {
                    byte[] bytes = file.getBytes();
                    stream = new BufferedOutputStream(new FileOutputStream(
                            new File("file" + File.separator + file.getOriginalFilename())));
                    stream.write(bytes);
                    stream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return "OK";
    }

}
