package com.ljx.exercise.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.*;


/**
 * <p>
 *
 * </p>
 *
 * @Since: Created  in 14:20 2020/12/18
 * @Author: Ljx
 * @Decription:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping("/hello")
    @ResponseBody
    public String helloSpringMVC(){
        return "hello  springMVC";
    }

    @GetMapping("/")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile file,HttpServletRequest request) {
        StringBuffer requestURL = request.getRequestURL();
        String originalFilename = file.getOriginalFilename();
        InputStream is = null;
        OutputStream out = null;
        try{
            System.out.println(requestURL);
            is = file.getInputStream();
            File upload = new File("D:\\amain_workspace\\Work\\test_code\\SSM_template\\src\\main\\webapp\\upload");
            if (!upload.exists()){
                boolean mkdirs = upload.mkdirs();
                if (mkdirs){
                    System.out.println("创建成功!");
                }else{
                    System.out.println("创建失败~!");
                }
            }
            out = new FileOutputStream(upload+File.separator+originalFilename);
            int len = 0;
            byte [] bytes = new byte[1024];
            while ((len = is.read(bytes))!= -1){
                out.write(bytes);
            }
            out.flush();

            File[] files = upload.listFiles();
            for (File file1:files){
                String name = file1.getName();
                System.out.println(name);
            }
            System.out.println(File.separator);
        }catch (Exception e){
            System.out.println(e);
        }finally {
                if (out!=null){
                    try {
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
        }
        return requestURL+"/"+originalFilename;
    }


}
