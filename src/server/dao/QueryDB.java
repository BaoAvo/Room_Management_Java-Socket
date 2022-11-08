package server.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import server.model.UserServer;

public class QueryDB extends ConnectDB{
    public QueryCommand queryCommand = new QueryCommand();

    public QueryDB() {
        super();
    }
    
    //get user inf by username and password
    public UserServer verifyUser(UserServer user) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getUserByUsernameAndPassword);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UserServer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        (rs.getInt(9) != 0),
                        (rs.getInt(10) != 0),
                        1);    
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // get User by ID
    public UserServer getUserByID(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getUserByID);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new UserServer(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        rs.getInt(7),
                        rs.getInt(8),
                        (rs.getInt(9) != 0),
                        (rs.getInt(10) != 0),
                        1);
                        
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    // add user by register
    public void addUser(UserServer user) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.addUserInformation);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNickname());
            ps.setString(4, user.getAvatar());
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // check duplicate 
    public boolean checkDuplicated(String username){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getUserByUsername);
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean checkIsBanned(UserServer user){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getBannedUserByID);
            ps.setInt(1, user.getID());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    
    public void updateBannedStatus(UserServer user,boolean ban){
        try {
            PreparedStatement ps1 = conn.prepareStatement(queryCommand.addBannedUserByID);
            PreparedStatement ps2 = conn.prepareStatement(queryCommand.deleteBannedUserByID);
            if(ban){
                ps1.setInt(1, user.getID());
                ps1.executeUpdate();
            } else{
                ps2.setInt(1, user.getID());
                ps2.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
        // status : online
    public void updateToOnline(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateStatusOnlineByID);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // status : offline
    public void updateToOffline(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateStatusOfflineByID);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // set status play
    public void updateToPlaying(int ID){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateStatusPlayingByID);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // set status not play
    public void updateToNotPlaying(int ID){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateStatusNotPlayingByID);
            ps.setInt(1, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // get total numbar win
    public int getNumberOfWin(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getNumberWin);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    // get total numbar draw
    public int getNumberOfDraw(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getNumberDraw);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    
    // draw +1
    public void addDrawGame(int ID){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateNumberDraw);
            ps.setInt(1, new QueryDB().getNumberOfDraw(ID)+1);
            ps.setInt(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    // win +1
    public void addWinGame(int ID){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateNumberWin);
            ps.setInt(1, new QueryDB().getNumberOfWin(ID)+1);
            ps.setInt(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //get total game played
    public int getNumberOfGame(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getTotalGamePlayed);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    //increase the game +1
    public void addGame(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateTotalGamePlayedIncrease);
            ps.setInt(1, new QueryDB().getNumberOfGame(ID) + 1);
            ps.setInt(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    //decrease the game -1
    public void decreaseGame(int ID){
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.updateTotalGamePlayedDecrease);
            ps.setInt(1, new QueryDB().getNumberOfGame(ID) - 1);
            ps.setInt(2, ID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    //get nickname by id
    public String getNickNameByID(int ID) {
        try {
            PreparedStatement ps = conn.prepareStatement(queryCommand.getNickNameByID);
            ps.setInt(1, ID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
}
