package Users;

public class Users {

    final String STANDARD_USER_USERNAME = "standard_user";
    final String LOCKED_OUT_USERNAME = "locked_out_user";
    final String PROBLEM_USER_USERNAME = "problem_user";
    final String PERFORMANCE_GLITCH_USER_USERNAME = "performance_glitch_user";
    final String PASSWORD = "secret_sauce";


    public String getPassword(String user) {
        return PASSWORD;
    }

    public String getUsername(String user) {
        switch (user) {
            case STANDARD_USER_USERNAME:
                user = STANDARD_USER_USERNAME;
                break;
            case PROBLEM_USER_USERNAME:
                user = PROBLEM_USER_USERNAME;
                break;
            case LOCKED_OUT_USERNAME:
                user = LOCKED_OUT_USERNAME;
                break;
            case PERFORMANCE_GLITCH_USER_USERNAME:
                user = PERFORMANCE_GLITCH_USER_USERNAME;
                break;
            default:
                System.out.println("FAIL");
                break;
        }
        return user;
    }
}
