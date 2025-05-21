package com.voting.controller;

import com.voting.connection.database;
import com.voting.main.dashboard;
import com.voting.model.SchoolYearModel;
import static com.voting.result.Result.DashboardSY;
import static com.voting.result.Result.overall_ave;
import static com.voting.result.Result.total_students;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.table.DefaultTableModel;

public class results {
    public static String query;
    public static String sy;
    
    private static int getCount(String query) throws SQLException {
        database.ps = database.conn.prepareStatement(query);
        database.rs = database.ps.executeQuery();
        if (database.rs.next()) {
            return database.rs.getInt(1);
        }
        return 0;
    }
    
    public static void updateCourseVotes(String courseFilter, JProgressBar progressBar, SchoolYearModel model) {
        try {
            database.openConn();

            String voteQuery = "SELECT COUNT(*) FROM tb_vote a " +
                               "JOIN tb_students b ON a.studid = b.studid " +
                               "WHERE " + courseFilter ;
            int voteCount = getCount(voteQuery);

            String studentQuery = "SELECT COUNT(*) FROM tb_students WHERE " + courseFilter;
            int studentCount = getCount(studentQuery);

            double percentage = studentCount > 0 ? (voteCount * 100.0) / studentCount : 0;
//            progressBar.setValue((int) Math.round(percentage));
            progressBar.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetOverallAve(){
        
        try{                           
            database.openConn();
            
            String studentQuery = "SELECT count(*) FROM `tb_students` ";
            double studentCount = getCount(studentQuery);
                                  
            String voteQuery = "SELECT count(*) FROM `tb_vote` ";
            double voteCount = getCount(voteQuery);
        
            double percentage = studentCount > 0 ? (voteCount * 100.0) / studentCount : 0;
            
            overall_ave.setText("Overall:" + (String.format("%.2f", percentage) + "%" ));
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void updateCandidateVotes(String position, String voteColumn, DefaultTableModel tbm, SchoolYearModel model) {
        tbm.setRowCount(0);
        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v." + voteColumn + " " +
                       "WHERE c.position = ? AND c.sy = ? " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.ps.setString(1, position);
            database.ps.setString(2, sy);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");
                tbm.addRow(new Object[]{fullName, votes});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void schoolyear(){
        
        try{
            database.openConn();
            
            String query = "SELECT * FROM `tb_schoolyear` WHERE isActive = 1 ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();
            
            while(database.rs.next()) {
//                model.setSchoolyear (database.rs.getString("sy") );
                sy = database.rs.getString("sy");
                DashboardSY.setText(database.rs.getString("sy"));
            }
            
        }catch(SQLException error){
            JOptionPane.showMessageDialog(null, error);
        }finally {
            database.closeConn();
        }
    }
}
