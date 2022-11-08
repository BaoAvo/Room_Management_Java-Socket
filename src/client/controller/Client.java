package client.controller;

import javax.swing.JFrame;
import client.model.User;
import client.view.CreateRoomPasswordView;
import client.view.FindRoomView;
import client.view.GameClientView;
import client.view.GameNoticeView;
import client.view.HomePageView;
import client.view.JoinRoomPasswordView;
import client.view.LoginView;
import client.view.RoomListView;
import client.view.RoomNameView;
import client.view.WaitingRoomView;

public class Client {

    public enum View {
        LOGIN,
        HOMEPAGE,
        ROOMLIST,
        FINDROOM,
        WAITINGROOM,
        GAMECLIENT,
        CREATEROOMPASSWORD,
        JOINROOMPASSWORD,
        GAMENOTICE,
        ROOMNAMEFRM
    }
    public static User user;
    //Danh sách giao diện
    public static LoginView loginView;
    public static HomePageView homePageView;
    public static RoomListView roomListView;
    public static FindRoomView findRoomView;
    public static WaitingRoomView waitingRoomView;
    public static GameClientView gameClientView;
    public static CreateRoomPasswordView createRoomPasswordView;
    public static JoinRoomPasswordView joinRoomPasswordView;
    public static GameNoticeView gameNoticeView;
    public static RoomNameView roomNameView;
    //Thiết lập socket
    public static SocketHandle socketHandle;

    public Client() {
    }

    public static JFrame getVisibleJFrame() {
        if (roomListView != null && roomListView.isVisible()) {
            return roomListView;
        }
        if (createRoomPasswordView != null && createRoomPasswordView.isVisible()) {
            return createRoomPasswordView;
        }
        if (joinRoomPasswordView != null && joinRoomPasswordView.isVisible()) {
            return joinRoomPasswordView;
        }
        return homePageView;
    }

    public void initView() {
        loginView = new LoginView();
        loginView.setVisible(true);
        socketHandle = new SocketHandle();
        socketHandle.run();
    }

    public static void openView(View viewName) {
        if (viewName != null) {
            switch (viewName) {
                case LOGIN:
                    loginView = new LoginView();
                    loginView.setVisible(true);
                    break;
                case HOMEPAGE:
                    homePageView = new HomePageView();
                    homePageView.setVisible(true);
                    break;
                case ROOMLIST:
                    roomListView = new RoomListView();
                    roomListView.setVisible(true);
                    break;
                case FINDROOM:
                    findRoomView = new FindRoomView();
                    findRoomView.setVisible(true);
                    break;
                case WAITINGROOM:
                    waitingRoomView = new WaitingRoomView();
                    waitingRoomView.setVisible(true);
                    break;

                case CREATEROOMPASSWORD:
                    createRoomPasswordView = new CreateRoomPasswordView();
                    createRoomPasswordView.setVisible(true);
                    break;
                case ROOMNAMEFRM:
                    roomNameView = new RoomNameView();
                    roomNameView.setVisible(true);
            }
        }
    }

    public static void openView(View viewName, int arg1, String arg2) {
        if (viewName != null) {
            switch (viewName) {
                case JOINROOMPASSWORD:
                    joinRoomPasswordView = new JoinRoomPasswordView(arg1, arg2);
                    joinRoomPasswordView.setVisible(true);
                    break;
            }
        }
    }

    public static void openView(View viewName, User competitor, int room_ID, int isStart, String competitorIP) {
        if (viewName != null) {
            switch (viewName) {
                case GAMECLIENT:
                    gameClientView = new GameClientView(competitor, room_ID, isStart, competitorIP);
                    gameClientView.setVisible(true);
                    break;
            }
        }
    }


    public static void openView(View viewName, String arg1, String arg2) {
        if (viewName != null) {
            switch (viewName) {
                case GAMENOTICE:
                    gameNoticeView = new GameNoticeView(arg1, arg2);
                    gameNoticeView.setVisible(true);
                    break;
                case LOGIN:
                    loginView = new LoginView(arg1, arg2);
                    loginView.setVisible(true);
            }
        }
    }

    public static void closeView( 
        View viewName){
        if (viewName != null) {
            switch (viewName) {
                case LOGIN:
                    loginView.dispose();
                    break;
                case HOMEPAGE:
                    homePageView.dispose();
                    break;
                case ROOMLIST:
                    roomListView.dispose();
                    break;
                case FINDROOM:
                    findRoomView.stopAllThread();
                    findRoomView.dispose();
                    break;
                case WAITINGROOM:
                    waitingRoomView.dispose();
                    break;
                case GAMECLIENT:
                    gameClientView.stopAllThread();
                    gameClientView.dispose();
                    break;
                case CREATEROOMPASSWORD:
                    createRoomPasswordView.dispose();
                    break;
                case JOINROOMPASSWORD:
                    joinRoomPasswordView.dispose();
                    break;
                case GAMENOTICE:
                    gameNoticeView.dispose();
                    break;
                case ROOMNAMEFRM:
                    roomNameView.dispose();
                    break;
            }

        }
    }

    public static void closeAllViews() {
        if (loginView != null) {
            loginView.dispose();
        }
        if (homePageView != null) {
            homePageView.dispose();
        }
        if (roomListView != null) {
            roomListView.dispose();
        }
        if (findRoomView != null) {
            findRoomView.stopAllThread();
            findRoomView.dispose();
        }
        if (waitingRoomView != null) {
            waitingRoomView.dispose();
        }
        if (gameClientView != null) {
            gameClientView.stopAllThread();
            gameClientView.dispose();
        }
        if (createRoomPasswordView != null) {
            createRoomPasswordView.dispose();
        }
        if (joinRoomPasswordView != null) {
            joinRoomPasswordView.dispose();
        }
        if (gameNoticeView != null) {
            gameNoticeView.dispose();
        }
        if (roomNameView != null) {
            roomNameView.dispose();
        }
    }

    public static void main(String[] args) {
        new Client().initView();
    }
}
