package manager;
import model.user;
import java.util.*;

public class loginmanager {
    public user login(String u,String p,ArrayList<user> users){
        for(user user: users){
            String tempUsername=user.getuserame();
            String tempPassword=user.getPassword();
            if(tempUsername.equals(u) && tempPassword.equals(p)){
                return user;
            }
        }
        return null;

    }
}
