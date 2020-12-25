package com.ljx.exercise.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.ljx.exercise.helper.Conv;
import com.ljx.exercise.helper.Result;
import com.ljx.exercise.helper.UploadUtils;
import com.mysql.cj.xdevapi.JsonString;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.print.DocFlavor;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 17:19 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
@Controller
@RequestMapping("/upload")
public class FileUploadController {

    @RequestMapping("/api/upload")
    @ResponseBody
    public String upload(HttpServletRequest request){
        try{
            Map<String, Object> stringObjectMap = UploadUtils.fileUpload(request);
            if (Conv.toInt(stringObjectMap.get("code"))==200) {
                return JSONObject.toJSONString(stringObjectMap.get("data"));
            }else {
                return "error";
            }

        }catch (Exception e){
            System.out.println(e);
            return "error";
        }
    }



}
