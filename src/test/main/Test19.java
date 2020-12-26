import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 * <p>
 *          Properties属性类   来表示一个持久的属性集 它使用键值结构存储数据，每个键及其对应值都是一个字符串
 *              (1)是一个集合类，Hashtable的子类
 *              (2)特有功能
 *                  A:public Object setProperty(String key,String value)
 *                  B:public String getProperty(String key)
 *                  C:public Set stringPropertyNames()
 *              (3)和IO流结合的方法
 *                  把键值对形式的文本文件内容加载到集合中
 *                  public void load(Reader reader)
 *                  public void load(InputStream inStream)
 *                  把集合中的数据存储到文本文件中
 *                  public void store(Writer writer,String comments)
 *                  public void store(OutputStream out,String comments)
 * </p>
 *
 * @Since: Created  in 11:24 2020/12/26
 * @Author: Ljx
 * @Decription:
 */
public class Test19 {

    public static void main(String[] args) {
        Properties properties = System.getProperties();
        System.out.println(properties);
        System.out.println(System.getProperty("file.separator"));
        System.out.println("你爱"+System.getProperty("line.separator")+"不爱我");
        System.out.println("当前系统信息："+System.getProperty("os.name"));

        properties.setProperty("msg","你好");

        String msg = System.getProperty("msg");

        System.out.println(msg);

        Set<String> strings = properties.stringPropertyNames();
        for (String string : strings) {
            String value = properties.getProperty(string);
            System.out.println(string+":"+value);
        }
    }
}
