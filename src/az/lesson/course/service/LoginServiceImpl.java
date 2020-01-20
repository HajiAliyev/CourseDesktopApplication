/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.lesson.course.service;

import az.lesson.course.dao.LoginDao;
import az.lesson.course.model.Login;
import az.lesson.course.dao.CourseDao;

/**
 *
 * @author Asus
 */
public class LoginServiceImpl implements LoginService{

    private LoginDao loginDao;

    public LoginServiceImpl(LoginDao loginDao) {
        this.loginDao = loginDao;
    }
    
    @Override
    public Login login(String username, String password) throws Exception {
       
        return loginDao.login(username, password); 
    }

    @Override
    public boolean registration(Login login) throws Exception {
        return loginDao.registration(login);
    }
    
}
