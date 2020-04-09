package com.hyp.task.file.down;

import com.hyp.task.file.common.GlobalException;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;

@Service
public class LogDownService {

    public void logDownload(String name, HttpServletResponse response) throws Exception {
        response.setContentType("application/force-download");
        response.setCharacterEncoding("utf-8");
        response.addHeader("Content-Disposition", "attachment;filename=" +
                new String(name.getBytes("utf-8"),"ISO8859-1"));
        File file = new File("file" + File.separator + name);
        if (!file.exists()) {
            throw new GlobalException(name + "文件不存在");
        }
        byte[] buffer = new byte[1024];
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            fis.close();
            bis.close();
            os.close();
        }
    }
}
