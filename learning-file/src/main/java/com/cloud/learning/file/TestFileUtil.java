package com.cloud.learning.file;

import java.io.File;
import java.io.InputStream;

/**
 * @ClassName: TestFileUtil
 * @Description: 兼容第一行为空的情况
 * @Author: pzl
 * @CreateDate: 2021/1/29 16:07
 * @Version: 1.0
 */
public class TestFileUtil {


    public static InputStream getResourcesFileInputStream(String fileName) {
        return Thread.currentThread().getContextClassLoader().getResourceAsStream("" + fileName);
    }

    public static String getPath() {
        return TestFileUtil.class.getResource("/").getPath();
    }

    public static File createNewFile(String pathName) {
        File file = new File(getPath() + pathName);
        if (file.exists()) {
            file.delete();
        } else {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
        }
        return file;
    }

    public static File readFile(String pathName) {
        return new File(getPath() + pathName);
    }

    public static File readUserHomeFile(String pathName) {
        return new File(System.getProperty("user.home") + File.separator + pathName);
    }
}
