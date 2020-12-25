package com.ljx.exercise.helper;

import com.ljx.exercise.enums.MsgNum;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 14:05 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
public class DownloadUtils {

    /**
     *
     * @param name 文件名
     * @param response 响应
     * @return
     */
    public static Map<String,Object> downloadFile(String name, HttpServletResponse response){
        Map<String,Object> resultMap = new HashMap<>();
        if (Conv.isEmpty(name)){
            File file = new File("D:\\amain_workspace\\Work\\test_code\\SSM_template\\src\\main\\webapp\\uploads",name);
            File absoluteFile = file.getAbsoluteFile();
            try(InputStream is = new FileInputStream(absoluteFile);
                BufferedInputStream bif = new BufferedInputStream(is);
                OutputStream out = response.getOutputStream();
                BufferedOutputStream bout = new BufferedOutputStream(out);){
                //设置响应输出格式
                //清空响应头
                response.reset();
                response.setContentType("application/x-download");
                //response.setHeader("Content-Disposition","inline;filename="+ URLEncoder.encode(name,"UTF-8"));
                response.setHeader("Content-Disposition","attachment;filename="+ URLEncoder.encode(name,"UTF-8"));
                int len = 0;
                byte [] bytes = new byte[1024];
                while ((len=bif.read(bytes))!=-1){
                        bout.write(bytes);
                }
                bout.flush();
                resultMap.put("code", MsgNum.SUCCESS.getCode());
                resultMap.put("message",MsgNum.SUCCESS.getMessage());
            }catch (Exception e){
                System.out.println(e);
                resultMap.put("code", MsgNum.ERROR.getCode());
                resultMap.put("message",MsgNum.ERROR.getMessage()+e);
            }
        }else {
            resultMap.put("code", MsgNum.DOWNLOAD_ERROR.getCode());
            resultMap.put("message",MsgNum.DOWNLOAD_ERROR.getMessage());
        }
        return resultMap;
    }
}
