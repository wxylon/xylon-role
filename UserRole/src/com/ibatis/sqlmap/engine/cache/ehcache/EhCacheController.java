
package com.ibatis.sqlmap.engine.cache.ehcache;
    
import java.net.URL;
import java.util.Properties;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

import com.ibatis.sqlmap.engine.cache.CacheController;
import com.ibatis.sqlmap.engine.cache.CacheModel;
    
    /**
    * EhCache Implementation of the {@link com.ibatis.sqlmap.engine.cache.CacheController} interface to be able to use
    * EhCache as a cache implementation in iBatis. You can configure your cache model as follows, by example, in your
    * sqlMapping files:
    * &lt;cacheModel id="myCache" type="nl.rabobank.springproject.ibatis.EhCacheController" readOnly="true" serialize="false"&gt;
    *   &lt;property name="configFile" value="/path-to-ehcache.xml"/&gt;
    * &lt;/cacheModel&gt;
    * Alternatively, you can use a type alias in your type attribute and defining the class with a
    * &lt;TypeAlias&gt; declaration, see iBatis documentation on how to do this.
    */
    public class EhCacheController implements CacheController {
    
    /** The EhCache CacheManager. */
    private CacheManager cacheManager;
    
    /**
    * Flush a cache model.
    * @param cacheModel - the model to flush.
    */
    public void flush(CacheModel cacheModel) {
    getCache(cacheModel).removeAll();
    }
    
    /**
    * Get an object from a cache model.
    * @param cacheModel - the model.
    * @param key        - the key to the object.
    * @return the object if in the cache, or null(?).
    */
    public Object getObject(CacheModel cacheModel, Object key) {
    Object result = null;
    Element element = getCache(cacheModel).get(key);
    if (element != null) {
    result = element.getObjectValue();
    }
    return result;
    
    }
    
    /**
    * Put an object into a cache model.
    * @param cacheModel - the model to add the object to.
    * @param key        - the key to the object.
    * @param object     - the object to add.
    */
    public void putObject(CacheModel cacheModel, Object key, Object object) {
    getCache(cacheModel).put(new Element(key, object));
    }
    
    /**
    * Remove an object from a cache model.
    * @param cacheModel - the model to remove the object from.
    * @param key        - the key to the object.
    * @return the removed object(?).
    */
    public Object removeObject(CacheModel cacheModel, Object key) {
    Object result = this.getObject(cacheModel, key);
    getCache(cacheModel).remove(key);
    return result;
    }
    
    /**
    * Configure a cache controller. Initialize the EH Cache Manager as a singleton.
    * @param props - the properties object continaing configuration information.
    */
    public void setProperties(Properties props) {
    URL url = getClass().getResource(props.getProperty("configFile"));
    cacheManager = CacheManager.create(url);
    }
    
    /**
    * Gets an EH Cache based on an iBatis cache Model.
    * @param cacheModel - the cache model.
    * @return the EH Cache.
    */
    private Cache getCache(CacheModel cacheModel) {
    String cacheName = cacheModel.getId();
    Cache cache = cacheManager.getCache(cacheName);
    return cache;
    }
    
    /**
    * Shut down the EH Cache CacheManager.
    */
    public void finalize() {
    if (cacheManager != null) {
    cacheManager.shutdown();
    }
    }
    }