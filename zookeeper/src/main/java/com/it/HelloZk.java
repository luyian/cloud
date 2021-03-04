package com.it;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.List;

/**
 * zookeeper测试
 * @author admin
 */
public class HelloZk {
    private static final String CONNECTURL = "yinianliu.cn:2181";
    private static final int SESSIONTIMEOUT = 30 * 1000;

    public static void main(String[] args) throws Exception {
        ZooKeeper instance = getInstance();
        System.out.println(instance);
    }

    /**
     * 获取zk实例
     * @return
     * @throws Exception
     */
    public static ZooKeeper getInstance() throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTURL, SESSIONTIMEOUT,
                new Watcher() {
                    @Override
                    public void process(WatchedEvent watchedEvent) {

                    }
                });
        return zooKeeper;
    }

    /**
     * create /path data
     */
    public static String createZnode(ZooKeeper zooKeeper, String path, String value) throws Exception{
        String returnInfo = null;
        if (zooKeeper.exists(path, false) == null){
            returnInfo = zooKeeper.create(path, value.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        return returnInfo;
    }

    /**
     * get /path
     */
    public static String getZnode(ZooKeeper zooKeeper, String path) throws Exception{
        String returnInfo = null;
        byte[] bytes = zooKeeper.getData(path, false, new Stat());
        returnInfo = new String(bytes);
        return returnInfo;
    }

    /**
     * set /pate newData
     */
    public static String setZnode(ZooKeeper zooKeeper, String path, String value) throws Exception{
        String returnInfo = null;
        if (zooKeeper.exists(path, false) != null){
            Stat stat = zooKeeper.setData(path, value.getBytes(), Version.REVISION);
            returnInfo = stat.toString();
        }
        return returnInfo;
    }

    /**
     * delete /path
     */
    public static void deleteZnode(ZooKeeper zooKeeper, String path) throws Exception{
        zooKeeper.delete(path, Version.REVISION);
    }

    /**
     * ls /path
     */
    public static String lsZnode(ZooKeeper zooKeeper, String path) throws Exception{
        String returnInfo = null;
        if (zooKeeper.exists(path, false) != null){
            List<String> znodes = zooKeeper.getChildren(path, false);
            returnInfo = znodes.toString();
        }
        return returnInfo;
    }
}