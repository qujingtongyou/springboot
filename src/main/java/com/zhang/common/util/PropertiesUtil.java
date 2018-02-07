package com.zhang.common.util;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.ui.Model;

/**
 * properties文件工具类
 * @author QJL
 *
 */
public class PropertiesUtil {
	private static final Log log = LogFactory.getLog(PropertiesUtil.class);
	/* 缓存properties */
	public static final Map<String, Properties> map = new HashMap<String, Properties>();
	/* properties配置文件路径*/
	private static final String CONFIG_PATH = "classpath*:properties/param/*.properties";
	
	static{
		ResourcePatternResolver loader = new PathMatchingResourcePatternResolver();

		try {
			Resource resource[] = loader.getResources(CONFIG_PATH);
			if(resource!= null){
				for(Resource r : resource){
					Properties pro = PropertiesLoaderUtils.loadProperties(r);
					log.info("加载配置文件->"+r.getFilename());
					log.info("key->"+r.getFilename().substring(0,r.getFilename().lastIndexOf(".")));
					map.put(r.getFilename().substring(0,r.getFilename().lastIndexOf(".")), pro);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Properties reloadProperties(String fileName){
		ResourcePatternResolver loader = new PathMatchingResourcePatternResolver();
		Properties pro = null;
		try {
			Resource resource = loader.getResource("classpath*:properties/param/"+fileName+".properties");
			if(resource!= null){
					pro = PropertiesLoaderUtils.loadProperties(resource);
					log.info("重新加载配置文件->"+resource.getFilename());
					log.info("key->"+resource.getFilename().substring(0,resource.getFilename().lastIndexOf(".")));
					map.put(resource.getFilename().substring(0,resource.getFilename().lastIndexOf(".")), pro);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pro;
	}
	
	public static Properties getProperties(String fileName){
	 Properties p = map.get(fileName);
	 if(p == null){
		 synchronized (p) {
			 if(p == null)
				 p = reloadProperties(fileName);
		}
	 }
	 return p;
	}
	
	/**
	 * 获取接口url
	 * @param key
	 * @return
	 */
	public static String getUrl(String key)  {
		Properties p = getProperties("cs");
		String url = p.getProperty(key);
		return url;
	}
	
	public static void clear(){
		log.info("开始->清除properties配置缓存");
		map.clear();
		log.info("结束->清除properties配置缓存");
	}
	
	/**
	 * 获取Properties中的参数
	 * 模板中引用
	 */
	public static Model getMediaStatic(Model model) {
		
		String webRoot = PropertiesUtil.getProperties("testspringboot").getProperty("webRoot");
		String uploadImageWebRoot = PropertiesUtil.getProperties("testspringboot").getProperty("uploadImageWebRoot");
		model.addAttribute("uploadImageWebRoot", uploadImageWebRoot);
		model.addAttribute("webRoot", webRoot);
		return model;
	}
	
}
