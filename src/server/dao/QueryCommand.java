package server.dao;

public class QueryCommand {
    String getUserByUsernameAndPassword = "SELECT * FROM user WHERE username=? AND password=?";
    String getUserByID = "SELECT * FROM user WHERE ID=?";
    String addUserInformation = "INSERT INTO user(username, password, nickname, avatar) VALUES(?,?,?,?)";
    String getUserByUsername = "SELECT * FROM user WHERE username = ?";
    String getBannedUserByID = "SELECT * FROM banned_user WHERE ID_User = ?";
    String addBannedUserByID = "INSERT INTO `banned_user`(`ID_User`) VALUES (?)";
    String deleteBannedUserByID = "DELETE FROM `banned_user` WHERE ID_User=?";
    String updateStatusOnlineByID = "UPDATE user SET IsOnline = 1 WHERE ID = ?";
    String updateStatusOfflineByID = "UPDATE user SET IsOnline = 0 WHERE ID = ?";
    String updateStatusPlayingByID = "UPDATE user SET IsPlaying = 1 WHERE ID = ?";
    String updateStatusNotPlayingByID = "UPDATE user SET IsPlaying = 0 WHERE ID = ?";
    String getListFriend = "SELECT User.ID, User.NickName, User.IsOnline, User.IsPlaying FROM user WHERE User.ID IN (SELECT ID_User1 FROM friend WHERE ID_User2 = ?)OR User.ID IN(SELECT ID_User2 FROM friend WHERE ID_User1 = ?)";
    String getIDToCheckFriend = "SELECT Friend.ID_User1 FROM friend WHERE (ID_User1 = ? AND ID_User2 = ?) OR (ID_User1 = ? AND ID_User2 = ?)";
    String getNumberWin = "SELECT user.NumberOfWin FROM user WHERE user.ID = ?";
    String getNumberDraw = "SELECT user.NumberOfDraw FROM user WHERE user.ID = ?";
    String updateNumberDraw = "UPDATE user SET user.NumberOfDraw = ? WHERE user.ID = ?";
    String updateNumberWin = "UPDATE user SET user.NumberOfWin = ? WHERE user.ID = ?";
    String getTotalGamePlayed = "SELECT user.NumberOfGame FROM user WHERE user.ID = ?";
    String updateTotalGamePlayedIncrease = "UPDATE user SET user.NumberOfGame = ? WHERE user.ID = ?";
    String updateTotalGamePlayedDecrease = "UPDATE user SET user.NumberOfGame = ? WHERE user.ID = ?";
    String getNickNameByID = "SELECT user.NickName FROM user WHERE user.ID=?";
}
                   
