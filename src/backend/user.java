package backend;

public class user {



    private String userid;
    private String servicetoken;
    private String name;
    private String familyname;
    private int isAdmin;

    public user() {     //default constructor
    }

    public user(String userid, String token, String name, String familyname, int isAdmin) {         //user and admin constructor
        this.userid = userid;
        this.servicetoken = token;
        this.name = name;
        this.familyname = familyname;
        this.isAdmin = isAdmin;
    }

    public user(String userid, int isAdmin) {              //isNoUser constructor
        this.userid = userid;
        this.isAdmin = isAdmin;
    }


    public String getUserid() {
        return userid;
    }

    public String getServicetoken() {
        return servicetoken;
    }

    public String getName() {
        return name;
    }

    public String getFamilyname() {
        return familyname;
    }

    public int getIsAdmin() {
        return isAdmin;
    }
}
