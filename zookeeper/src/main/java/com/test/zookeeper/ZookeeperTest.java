/**
 * Project Name:zookeeper-test
 * File Name:ZookeeperTest.java
 * Package Name:com.wk.zookeeper.zookeeper_test
 * Date:2017年9月15日下午2:23:30
 * Copyright (c) 2017 嘉源锐信 All Rights Reserved.
 *
*/

package com.test.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs.Ids;
import org.apache.zookeeper.ZooKeeper;

/**
 * ClassName:ZookeeperTest
 * Function: TODO ADD FUNCTION
 * Reason:	 TODO ADD REASON
 * Date:     2017年9月15日 下午2:23:30
 * @author   lijie
 * @version  
 * @see 	 
 */
public class ZookeeperTest {
    
    private static final int TIME_OUT = 3000;
    private static final String HOST = "192.168.106.128:4181,192.168.106.128:4182,192.168.106.128:4184";
    
    public static void main(String[] args) throws Exception{
        
        ZooKeeper zookeeper = new ZooKeeper(HOST, TIME_OUT, null);
        
        System.out.println("=========创建节点==========="); 
        
        if(zookeeper.exists("/test", false) == null){
            
            zookeeper.create("/test", "znode1".getBytes(), Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        
        System.out.println("=============查看节点是否安装成功===============");
        
        System.out.println(new String(zookeeper.getData("/test", false, null)));
         
        System.out.println("=========修改节点的数据==========");
        
        String data = "zNode2";
        
        zookeeper.setData("/test", data.getBytes(), -1);
         
        System.out.println("========查看修改的节点是否成功=========");
        
        System.out.println(new String(zookeeper.getData("/test", false, null)));
         
//        System.out.println("=======删除节点==========");
//        
//        zookeeper.delete("/test", -1);
//         
//        System.out.println("==========查看节点是否被删除============");
//        
//        System.out.println("节点状态：" + zookeeper.exists("/test", false));
         
        zookeeper.close();
    }
}

