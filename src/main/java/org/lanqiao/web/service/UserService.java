package org.lanqiao.web.service;

import org.lanqiao.web.dao.UserDao;
import org.lanqiao.web.model.User;

public class UserService {

    private UserDao dao = new UserDao();
    /**
     * 
     * Description: <br>
     * 验证User对象中的用户名和密码
     * @param user
     * @return 
     * @see
     */
    public boolean validate(User _user)  {
        //前置的业务处理
        //调用dao
        User user = dao.findByUser(_user);
        
        //后置的业务处理
        if (user==null) {
            return false;
        }else {
            return true;
        }
    }

}
