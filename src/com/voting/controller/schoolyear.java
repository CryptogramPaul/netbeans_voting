package com.voting.controller;

import com.voting.connection.database;
import com.voting.main.dashboard;
import com.voting.model.SchoolYearModel;
import com.voting.schoolyear.SchoolYear;
import static com.voting.schoolyear.SchoolYear.isActive;
import static com.voting.schoolyear.SchoolYear.save_sy;
import static com.voting.schoolyear.SchoolYear.OperationUpdate;
import static com.voting.schoolyear.SchoolYear.sy;
import static com.voting.schoolyear.SchoolYear.sy_delete;
import static com.voting.schoolyear.SchoolYear.table_schoolyear;
import static com.voting.schoolyear.SchoolYear.tbm_sy;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class schoolyear {
    public static String query;
    
    public static void showrecord() {  
        tbm_sy.setRowCount(0);  
        try{            
            
            database.openConn();
            
           
            query = "SELECT * FROM `tb_schoolyear` ORDER BY id ASC";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();
            
            String isActive;
            while (database.rs.next() ) {
                if( database.rs.getInt("isActive") == 1){
                    isActive = "Active";
                }else{
                    isActive = "In-active";
                }
                tbm_sy.addRow(new Object[]{
                        database.rs.getInt("id"),
                        database.rs.getString("sy"),
                        isActive,     
                });
            }
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }

    }
    public static void refresh(SchoolYearModel model){
        showrecord();
        sy.setText("");
        isActive.setSelected(false);
        sy_delete.setEnabled(false);
        save_sy.setIcon(new ImageIcon(schoolyear.class.getResource("/com/voting/assets/icons/buttons/btn-save.png")));
        OperationUpdate = 0;
        schoolyear(model);
    }
    
     private static int getCount(String query) throws SQLException {
        database.ps = database.conn.prepareStatement(query);
        database.rs = database.ps.executeQuery();
        if (database.rs.next()) {
            return database.rs.getInt(1);
        }
        return 0;
    }
    
    
    public static void AddSchoolYear(SchoolYearModel model){
        //  Not Active = 0, Active = 1      
         try{
            database.openConn();
            
            int _isActive = 0;
            
            if(isActive.isSelected()){
                _isActive = 1 ;
            }
            
          
            
            String CountQuery = "SELECT count(*) FROM tb_schoolyear WHERE isActive = 1";
            
            int active_count = getCount(CountQuery);
            
            System.out.print(active_count);
            
            if (active_count == 0) {
                query = "INSERT INTO `tb_schoolyear`(sy,isActive)values(?,?)";
            
                database.ps =  database.conn.prepareStatement(query);
                database.ps.setString(1, sy.getText() );
                database.ps.setInt(2, _isActive);
                database.ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Save successfully");
                refresh(model);   
             }else{
                JOptionPane.showMessageDialog(null, "Other school year is still active, you can't activate new school year.");
             }
            

         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }

    public static void edit() {
        OperationUpdate = 1;
        save_sy.setIcon(new ImageIcon(schoolyear.class.getResource("/com/voting/assets/icons/buttons/btn-update.png")));
        
        int row = table_schoolyear.getSelectedRow();
//        SchoolYear.sy_id = Integer.parseInt(canid);
        SchoolYear.sy_id = (int) SchoolYear.table_schoolyear.getValueAt(row, 0);
        sy.setText(SchoolYear.table_schoolyear.getValueAt(row, 1).toString());
        
        if(SchoolYear.table_schoolyear.getValueAt(row, 2).toString() == "Active"){
            isActive.setSelected(true);
        }else{
            isActive.setSelected(false);
        }
    }

    public static void UpdateSchoolYear(SchoolYearModel model) {
         try{
            database.openConn();
            
            int _isActive = 0;
            
            if(isActive.isSelected()){
                _isActive = 1 ;
            }
            
            String CountQuery = "SELECT count(*) FROM tb_schoolyear WHERE isActive = 1 and id <> "+SchoolYear.sy_id+" ";
            
            int active_count = getCount(CountQuery);
            
            if(active_count == 0){
            
                query = "UPDATE `tb_schoolyear` SET sy = ?, isActive = ? WHERE id = ? ";
                database.ps = database.conn.prepareStatement(query);

                database.ps.setString(1, sy.getText() );
                database.ps.setInt(2, _isActive);
                database.ps.setInt(3, SchoolYear.sy_id);
              

                database.ps.executeUpdate();
                JOptionPane.showMessageDialog(null, "Update successfully");
                
                refresh(model);
            }else{
                JOptionPane.showMessageDialog(null, "Other school year is still active, you can't activate new school year.");
            }
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void delete(SchoolYearModel model) {
        try{
            database.openConn();
            
            query = "DELETE FROM tb_schoolyear WHERE id = ?";
            database.ps = database.conn.prepareStatement(query);

            database.ps.setInt(1, SchoolYear.sy_id);
            database.ps.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Delete Successfully");
            refresh(model);
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void schoolyear(SchoolYearModel model){
        
        try{
            database.openConn();
            
            String query = "SELECT * FROM `tb_schoolyear` WHERE isActive = 1 ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();
            
            while(database.rs.next()) {
                model.setSchoolyear (database.rs.getString("sy") );
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }finally {
            database.closeConn();
        }
    }
}
