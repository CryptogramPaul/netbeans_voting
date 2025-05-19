package com.voting.controller;

import com.voting.connection.database;
import com.voting.main.dashboard;
import com.voting.main.login;
import static com.voting.main.login.login_view;
//import static com.voting.main.login.login_view;
import javax.swing.JOptionPane;
import static com.voting.main.login.username;
import static com.voting.main.login.password;
import static com.voting.main.login.schoolyear_box;
import java.sql.SQLException;

public class login_controller {
    
    public static void LoginAction(){
        try{
            database.openConn();
             
            String u = username.getText();
            String p = new String (password.getPassword());
            
            String sql = "SELECT * FROM `tb_login` WHERE username = ? AND password = ? ";
            database.ps = database.conn.prepareStatement(sql);
            database.ps.setString(1, u);
            database.ps.setString(2, p);
            database.rs = database.ps.executeQuery();
           
            if(database.rs.next()){
                new dashboard().setVisible(true);
                dashboard.SchoolYear = (String) schoolyear_box.getSelectedItem();
                
                login_view.dispose();
              
                
            }else{
                JOptionPane.showMessageDialog(null, "Username or password is incorrect!");
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }finally {
            database.closeConn();
        }
    }
    
    
    public static void schoolyear(){
        try{
            database.openConn();
            
            String query = "SELECT * FROM `tb_schoolyear`";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();
            
            while(database.rs.next()) {
                schoolyear_box.addItem(database.rs.getString("sy"));
                if (database.rs.getInt("isActive") == 1) {
                    schoolyear_box.setSelectedItem(database.rs.getString("sy"));
                }
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }finally {
            database.closeConn();
        }
    }
}
