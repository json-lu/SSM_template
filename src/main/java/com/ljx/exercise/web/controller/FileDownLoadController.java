package com.ljx.exercise.web.controller;

import com.ljx.exercise.helper.DownloadUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 14:30 2020/12/22
 * @Author: Ljx
 * @Decription:
 */
@Controller
@RequestMapping("/download")
public class FileDownLoadController {


    @RequestMapping("/api/downloadFile")
    public Map<String,Object> download(String filename, HttpServletResponse response){
        Map<String, Object> stringObjectMap = DownloadUtils.downloadFile(filename, response);
        return stringObjectMap;
    }
}
