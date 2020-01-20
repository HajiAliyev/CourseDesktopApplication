/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.lesson.course.dao;

import az.lesson.course.model.Login;
import az.lesson.course.model.Role;
import az.lesson.course.util1.JdbcUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import az.lesson.course.dao.DBHelper;

public class LoginDaoImpl implements LoginDao {

    @Override
    public Login login(String username, String password) throws Exception {
        Login login = new Login();
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT L.USERNAME,L.NAME,L.SURNAME,R.ROLE_NAME FROM LOGIN L\n"
                + " INNER JOIN ROLE R ON L.ROLE_ID = R.ID\n"
                + " WHERE L.ACTIVE = 1 AND L.USERNAME = ? AND L.PASSWORD = ? ";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
                if (rs.next()) {
                    login.setUsername(rs.getString("USERNAME"));
                    login.setName(rs.getString("NAME"));
                    login.setSurname(rs.getString("SURNAME"));
                    Role role = new Role();
                    role.setRoleName(rs.getString("ROLE_NAME"));
                    login.setRole(role);

                }
            } else {
                login = null;
            }
        } catch (Exception ex) {
            login = null;
            ex.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, rs);
        }
        return login;
    }

    @Override
    public boolean registration(Login login) throws Exception {
        boolean result = false;
        Connection c = null;
        PreparedStatement ps = null;
        String sql = "INSERT INTO LOGIN(ID,USERNAME,PASSWORD,ROLE_ID,NAME,SURNAME)\n"
                + " VALUES(LOGIN_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            c = DBHelper.getConnection();
            if (c != null) {
                ps = c.prepareStatement(sql);
                ps.setString(1, login.getUsername());
                ps.setString(2, login.getPassword());
                ps.setLong(3, login.getRole().getId());
                ps.setString(4, login.getName());
                ps.setString(5, login.getSurname());
                ps.execute();
                result = true;
            } else {
                System.out.println("Connection is null!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtility.close(c, ps, null);
        }

        return result;
    }

}
