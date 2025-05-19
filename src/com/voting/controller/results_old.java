package com.voting.controller;

import com.voting.connection.database;
import static com.voting.result.Result.bscje;
import static com.voting.result.Result.bsed;
import static com.voting.result.Result.bshm;
import static com.voting.result.Result.bsict;
import static com.voting.result.Result.bsit;
import static com.voting.result.Result.no_votes;
import static com.voting.result.Result.overall_ave;
import static com.voting.result.Result.tbm_ass_auditor;
import static com.voting.result.Result.tbm_ass_bm;
import static com.voting.result.Result.tbm_ass_sec;
import static com.voting.result.Result.tbm_ass_trea;
import static com.voting.result.Result.tbm_auditor;
import static com.voting.result.Result.tbm_businessmanager;
import static com.voting.result.Result.tbm_chairman;
import static com.voting.result.Result.tbm_pio;
import static com.voting.result.Result.tbm_secretary;
import static com.voting.result.Result.tbm_treasurer;
import static com.voting.result.Result.tbm_vicechairman;
import static com.voting.result.Result.total_students;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class results_old {
    private static String query;
//    private static int total
    
    public static void GetOverallAve(){
        
        try{            
            Double votes = 0.00;
            Double students = 0.00;
               
            database.openConn();
            
            query = "SELECT count(*) as count_student FROM `tb_students` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students = database.rs.getDouble("count_student");
            }
                                  
            query = "SELECT count(*) as votes FROM `tb_vote` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                votes = database.rs.getDouble("votes");
            }
        
            Double percentage = students > 0 ? (votes / students) * 100 : 0;
            
            overall_ave.setText("Overall:" + (String.format("%.2f", percentage) + "%" ));
//            overall_ave.setText(percentage);
            
            
            System.out.println(String.format("%.2f", percentage) + "%" );
            System.out.println(percentage);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
        
    public static void GetNoOfStudents(){
        
        try{            
            
            database.openConn();
            
           
            query = "SELECT count(*) as count_student FROM `tb_students` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                total_students.setText(database.rs.getString("count_student"));
//                System.out.print(database.rs.getInt("count_student"));
            }
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetNoOfVotes(){
        
        try{            
            database.openConn();
            
            query = "SELECT count(*) as votes FROM `tb_vote` ";
            database.ps = database.conn.prepareStatement(query);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                no_votes.setText(database.rs.getString("votes"));
//                System.out.print(database.rs.getInt("count_student"));
            }
            
         } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetBSED(){
        
        try{     
            Double vote_count = 0.00;
            Double students_count = 0.00;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                              FROM tb_vote a " +
"                              LEFT JOIN tb_students b ON a.studid = b.studid " +
"                              WHERE b.course = 'BSED' OR b.course = 'BTVTED' OR b.course = 'BEED' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getDouble("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSED' OR course = 'BTVTED' OR course = 'BEED' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getDouble("students");
            }
            
            double percentage = students_count > 0 ? (vote_count * 100) / students_count : 0;
            
            bsed.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
//            System.out.println(String.format("%.2f", percentage) + "%" );
//            System.out.println(bsed_count);
//            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    
    public static void GetIct(){
        
        try{     
            Double vote_count = 0.00;
            Double students_count = 0.00;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                                                FROM tb_vote a \n" +
"                                                LEFT JOIN tb_students b ON a.studid = b.studid \n" +
"                                                WHERE b.course = 'BSICT' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getDouble("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSICT' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getDouble("students");
            }
            
            double percentage = students_count > 0 ? (vote_count * 100) / students_count : 0;
            
            bsict.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
//            System.out.println(String.format("%.2f", percentage) + "%" );
//            System.out.println(vote_count);
//            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    
    public static void GetBscje(){
        
        try{     
            Double vote_count = 0.00;
            Double students_count = 0.00;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                                                FROM tb_vote a \n" +
"                                                LEFT JOIN tb_students b ON a.studid = b.studid \n" +
"                                                WHERE b.course = 'BSCJE' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getDouble("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSCJE' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getDouble("students");
            }
            
            double percentage = students_count > 0 ? (vote_count * 100) / students_count : 0;
            
            bscje.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
//            System.out.println(String.format("%.2f", percentage) + "%" );
//            System.out.println(vote_count);
//            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    public static void GetBsit(){
        
        try{     
            Double vote_count = 0.00;
            Double students_count = 0.00;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                                                FROM tb_vote a \n" +
"                                                LEFT JOIN tb_students b ON a.studid = b.studid \n" +
"                                                WHERE b.course = 'BSIT' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getDouble("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSIT' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getDouble("students");
            }
            
            double percentage = students_count > 0 ? (vote_count * 100) / students_count : 0;
            
            bsit.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
//            System.out.println(String.format("%.2f", percentage) + "%" );
//            System.out.println(vote_count);
//            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    public static void GetBshm(){
        
        try{     
            Double vote_count = 0.00;
            Double students_count = 0.00;
            
            database.openConn();
            
            String sql_bsed = "SELECT count(*) as votes " +
"                                                FROM tb_vote a \n" +
"                                                LEFT JOIN tb_students b ON a.studid = b.studid \n" +
"                                                WHERE b.course = 'BSHM' ";
            database.ps = database.conn.prepareStatement(sql_bsed);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                vote_count = database.rs.getDouble("votes");
            }
            
            String total_students = "SELECT count(*) as students FROM tb_students WHERE course = 'BSHM' ";
            database.ps = database.conn.prepareStatement(total_students);
            database.rs =  database.ps.executeQuery();

            while (database.rs.next() ) {  
                students_count = database.rs.getDouble("students");
            }
            
            double percentage = students_count > 0 ? (vote_count * 100) / students_count : 0;
            
            bshm.setValue((int) Double.parseDouble(String.format("%.2f", percentage)));
//            System.out.println(String.format("%.2f", percentage) + "%" );
//            System.out.println(vote_count);
//            System.out.print(students_count);
            
        } catch ( SQLException e ) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
       
    }
    
    // create a function to execute count queries
    
//    public int execCount(String query){
//        
//        int total = 0;
//        database.openConn();
//        
//        try {
//            Statement st = database.conn.createStatement();
//            ResultSet rs = st.executeQuery(query);
//            
//            if(rs.next()){
//                total = rs.getInt(1);
//            }
//            
//        } catch (SQLException ex) {
////            Logger.getLogger(Calc_Percentage.class.getName()).log(Level.SEVERE, null, ex);
//                JOptionPane.showMessageDialog(null, ex);
//        }
//        
//        return total;
//    }
    
//    RESULT BY POSITION
    //        tbm_chairman.setRowCount(0);  
//        try{ 
//            String name;
//            int count = 0;
//            
//            database.openConn();
//            
//            database.ps = database.conn.prepareStatement("SELECT * FROM tb_candidates WHERE position = 'CHAIRMAN'");
//            database.rs =  database.ps.executeQuery();
//
//            while (database.rs.next() ) {
//
//                name = database.rs.getString("fname") + " " + database.rs.getString("mname") + " " + database.rs.getString("lname");
//                String total_votes = "SELECT count(voteid) as votes FROM tb_vote WHERE cm =?   ";
//                database.ps.setString(1, name);
//                database.ps = database.conn.prepareStatement(total_votes);
//                database.rs =  database.ps.executeQuery();
//
//                if(database.rs.next()){
//                    count = database.rs.getInt(1);
//                }
//                tbm_chairman.addRow(new Object[]{
//                        database.rs.getString("fname") + " " + database.rs.getString("mname") + " " + database.rs.getString("lname"),
//                        count
//                });
//            }
//            
//         } catch ( SQLException e ) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally {
//            database.closeConn();
//        }
    
    
    
    public static void GetChairman(){
        tbm_chairman.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.cm " +
                       "WHERE c.position = 'CHAIRMAN' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_chairman.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
//    public int TotalVotesPerCandidate(String name){
//        int count = 0;
//        try{ 
//            database.openConn();
//            
//            query = "SELECT count(voteid) as votes FROM tb_vote WHERE cm =?   ";
//            database.ps.setString(1, name);
//            database.ps = database.conn.prepareStatement(query);
//            database.rs =  database.ps.executeQuery();
//            
//            if(database.rs.next()){
//                count = database.rs.getInt(1);
//            }
//         } catch ( SQLException e ) {
//            JOptionPane.showMessageDialog(null, e);
//        } finally {
//            database.closeConn();
//        }
//        return count;
//    }
    public static void GetViceChairman(){
        tbm_vicechairman.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.vcm " +
                       "WHERE c.position = 'VICE CHAIRMAN' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_vicechairman.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetSecretary(){
        tbm_secretary.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.sec " +
                       "WHERE c.position = 'SECRETARY' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");
                
                System.out.print(fullName);
                tbm_secretary.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetAssSecretary(){
        tbm_ass_sec.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.assec " +
                       "WHERE c.position = 'ASSISTANT SECRETARY' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_ass_sec.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetTreasurer(){
        tbm_treasurer.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.tre " +
                       "WHERE c.position = 'TREASURER' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_treasurer.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetAssTreasurer(){
        tbm_ass_trea.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.astre " +
                       "WHERE c.position = 'ASSISTANT TREASURER' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_ass_trea.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetAuditor(){
        tbm_auditor.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.aud " +
                       "WHERE c.position = 'AUDITOR' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_auditor.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetAssAuditor(){
        tbm_ass_auditor.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.asaud " +
                       "WHERE c.position = 'ASSISTANT AUDITOR' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_ass_auditor.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetBusinessManager(){
        tbm_businessmanager.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.bm " +
                       "WHERE c.position = 'BUSINESS MANAGER' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_businessmanager.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    public static void GetAssBusinessManager(){
        tbm_ass_bm.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.abm " +
                       "WHERE c.position = 'ASSISTANT BUSINESS MANAGER' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_ass_bm.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }
    
    
    public static void GetPio() {
        tbm_pio.setRowCount(0);

        String query = "SELECT c.fname, c.mname, c.lname, COUNT(v.voteid) AS votes " +
                       "FROM tb_candidates c " +
                       "JOIN tb_vote v ON CONCAT(c.fname, ' ', c.mname, ' ', c.lname) = v.pio " +
                       "WHERE c.position = 'PIO' " +
                       "GROUP BY c.fname, c.mname, c.lname";

        try {
            database.openConn();
            database.ps = database.conn.prepareStatement(query);
            database.rs = database.ps.executeQuery();

            while (database.rs.next()) {
                String fullName = database.rs.getString("fname") + " " +
                                  database.rs.getString("mname") + " " +
                                  database.rs.getString("lname");
                int votes = database.rs.getInt("votes");

                tbm_pio.addRow(new Object[]{fullName, votes});
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        } finally {
            database.closeConn();
        }
    }


}
