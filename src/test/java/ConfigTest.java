import com.dina.controller.CarCrashController;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigTest {

    @Test
    public void test() throws IOException {
        String path ="src/main/resources/config.properties";

        Properties properties = new Properties();
        // 使用InPutStream流读取properties文件
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        properties.load(bufferedReader);
        // 获取key对应的value值
        String url = properties.getProperty("url");
        System.out.println(url);
    }
}
