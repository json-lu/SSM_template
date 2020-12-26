package com.ljx.exercise.helper;


import com.ljx.exercise.enums.MsgNum;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.*;

/**
 * <p>
 *      上传工具类 原生写法
 * </p>
 *
 * @Since: Created  in 17:19 2020/12/21
 * @Author: Ljx
 * @Decription:
 */
public class UploadUtils {

        public static Map<String,Object> fileUpload(HttpServletRequest request) throws  Exception{
            request.setCharacterEncoding("UTF-8");
            Map<String,Object> resultMap = new HashMap<>();
            List<String> filedNameList = new ArrayList<>();
            //1、判断表单是否支持上传文件
            boolean multipartContent = ServletFileUpload.isMultipartContent(request);
            System.out.println("--------------------------------------"+multipartContent+"----------------------------------");
            if (!multipartContent){//不支持上传文件
                resultMap.put("code",MsgNum.FROM_NO_TYPE.getCode());
                resultMap.put("message",MsgNum.FROM_NO_TYPE.getMessage());
                return resultMap;
            }
            //2、创建DiskFileItemFactory对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            /**
             * setRepository:设置缓存文件的目录（commons-fileupload是使用缓存的。
             * 原则：大小是否超过10kb。如果超过10kb则使用临时文件作为缓存）
             * 如果不超过10KB则使用内存作为缓存
             * 如果下面这行代码没有配置,则默认使用tomcat目录作为缓存目录
             */
            //factory.setRepository(new File("D:\\temp"));
            //3、创建ServletFileUpload对象，设置文件上传限制
            ServletFileUpload servletFileUpload = new ServletFileUpload(factory);
            servletFileUpload.setFileSizeMax(1024*1024*10);//文件大小
            servletFileUpload.setHeaderEncoding("utf-8");//设置编码格式
            //4、解析request,得到FileItem对象的集合
            List<FileItem> fileItems = servletFileUpload.parseRequest(request);
            System.out.println(fileItems);
            //遍历FileItem对象的集合
            for (FileItem fileItem : fileItems) {
                //5、判断fileItem是否是文件字段
                if (fileItem.isFormField()){//是普通表单字段
                    String fieldName = fileItem.getFieldName();//普通字段字段名
                    String fieldValue = fileItem.getString("UTF-8");//普通字段字段值
                    System.out.println(fieldName+":"+fieldValue);
                }else {//是文件
                    //获取文件名
                    String name = fileItem.getName();
                    //String suffix = name.substring(name.lastIndexOf("."));
                    //拼接新文件名
                    //String newName = UUID.randomUUID().toString().replace("-","").toUpperCase()+System.currentTimeMillis()+suffix;
                    filedNameList.add(name);
                    //创建文件夹用来存放上传文件 必须是绝对路径
                    File file = new File("D:\\amain_workspace\\Work\\test_code\\SSM_template\\src\\main\\webapp\\uploads");
                    if (!file.exists()){
                        file.mkdirs();
                    }
                    //服务器内部路径
                    //String realPath = request.getServletContext().getRealPath("/uploads");
                    //将文件从缓冲区写到磁盘
                    fileItem.write(new File(file,name));
                    //从缓存区删除
                    fileItem.delete();
                }
            }
            System.out.println("文件上传成功!");
            resultMap.put("code",MsgNum.SUCCESS.getCode());
            resultMap.put("message",MsgNum.SUCCESS.getMessage());
            resultMap.put("data",filedNameList);
            return resultMap;
        }
}
