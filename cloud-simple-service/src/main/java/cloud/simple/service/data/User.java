/**
 * @(#)User.java, 十月 28, 2016.
 * <p>
 * Copyright 2016 fenbi.com. All rights reserved.
 * FENBI.COM PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package cloud.simple.service.data;

import java.io.Serializable;

/**
 * @author zhangpeng
 */
public class User implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private int id;
    private String username;
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}