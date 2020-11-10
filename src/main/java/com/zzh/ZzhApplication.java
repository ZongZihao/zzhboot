package com.zzh;

import com.sun.jndi.toolkit.url.UrlUtil;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.time.temporal.IsoFields;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @ClassName : ZzhApplication
 * @Description : 我的应用程序
 * @Author : 宗子豪
 * @Date: 2020-09-25 15:48
 */

public class ZzhApplication {

    /**
     * 将传入方法的类所属包下的所有类进行扫描
     * @param rootClazz
     */
    public static void run(Class<?> rootClazz) throws Exception {
        Package rootPackage = rootClazz.getPackage();

        String packageDirName = "";
        String packageName = "";

        if(rootPackage != null) {
            packageName = rootPackage.getName();
            packageDirName = rootPackage.getName().replace('.', '/');
        }
        //得到所有类名称
        List<String> classNames = getAllClassFile(packageDirName, packageName);

        //得到所有类文件
        List<Class<?>> classList = getClassByName(classNames);

        for (Class<?> clazz : classList) {

        }

    }

    /**
     * 获取rootPackage下所有类文件
     * @param rootDirName
     * @return
     */
    public static List<String> getAllClassFile(String rootDirName, String packageName) throws IOException {
         Enumeration<URL> dirs = Thread.currentThread().getContextClassLoader().getResources(rootDirName);

         List<String> classNameList = new ArrayList<>();

         while(dirs.hasMoreElements()){

             URL url = dirs.nextElement();
             String protocol = url.getProtocol();
             if("file".equals(protocol)){
                File file = new File(url.getFile());
                getFileFromDir(file, classNameList, packageName, true);
             }
         }

        return classNameList;
    }

    public static void getFileFromDir(File file, List<String> classNameList, String packageName, boolean isFirst){

        if(!file.isDirectory()){
            if(file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().replace(".class", "");
                classNameList.add(className);
            }
        }else{
            //如果是文件夹
            File[] childFiles = file.listFiles();
            if(childFiles != null) {
                if(!isFirst){
                    packageName = packageName + "." + file.getName();
                }
                for (File childFile : childFiles) {
                    getFileFromDir(childFile, classNameList, packageName, false);
                }
            }
        }
    }

    public static List<Class<?>> getClassByName(List<String> clazzNames) throws ClassNotFoundException {
        List<Class<?>> clazzList = new ArrayList<>();
        for (String clazzName : clazzNames) {
            clazzList.add(Class.forName(clazzName));
        }
        return clazzList;
    }


}