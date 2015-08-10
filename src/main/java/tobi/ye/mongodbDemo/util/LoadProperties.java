package tobi.ye.mongodbDemo.util;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.util.Properties;

/**
 * This class encapsulates  some methods to get the value of properties file.
 *
 * @author YangFan
 * @version 1.0
 */
public class LoadProperties {
    private final static Logger LOGGER = LoggerFactory.getLogger(LoadProperties.class);

    /**
     * this map is used to store all the property name and value.
     */
    private static Properties pro = new Properties();

    public LoadProperties(String path) {
        loadMaperties(path);
    }

    /**
     * loadProperties
     * 用getClassLoader()，路径前面不要加/，否则会有空指针异常
     * @param path
     * @return
     */
    public static InputStream getResouceInputStream(String path) {
        return LoadProperties.class.getClassLoader().getResourceAsStream(path);
    }

    /**
     * load property file by given path
     *
     * @param path
     */
    public static void loadMaperties(String path) {
        try {
            pro.load(getResouceInputStream(path));
        } catch (Exception e) {
            LOGGER.error("系统资源文件读取出错!" + path + e.getMessage(), e);
        }
    }

    /**
     * get property value by key.
     *
     * @param key
     * @return
     */
    public String getValue(String key) {
        return pro.getProperty(key);
    }
}
