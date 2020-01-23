package backend;

public class user {



    private String userId;
    private String token;
    private String name;
    private String familyName;
    private int isAdmin;

    public user() {     //default constructor
    }

    public user(String userid, String token, String name, String familyname, int isAdmin) {         //user and admin constructor
        this.userId = userid;
        this.token = token;
        this.name = name;
        this.familyName = familyname;
        this.isAdmin = isAdmin;
    }

    public user(String userid, int isAdmin) {              //isNoUser constructor
        this.userId = userid;
        this.isAdmin = isAdmin;
    }


    public String getUserid() {
        return userId;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
}
