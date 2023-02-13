package com.example.LoginSystem;

public class User {

    private String userId;         /* 회원 아이디 */
    private String userPassword;       /* 회원 비밀번호 */
    private String userName;       /* 회원 이름 */
    private String userEmail;       /* 이메일 */

    public User(String userId, String userPassword, String userName, String userEmail) {
        this.userId = userId;
        this.userPassword = userPassword;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public User() {}

    /* getter */
    public String getUserId() {
        return userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }


}