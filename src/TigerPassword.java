import com.tigervnc.rfb.UserPasswdGetter;

public class TigerPassword implements UserPasswdGetter {
  private String pass_var;

  public TigerPassword(String pass) {
    pass_var = pass;
  }

  public final void getUserPasswd(boolean secure, StringBuffer user, StringBuffer password) {
    password.append(pass_var);
    password.setLength(pass_var.length());
    return;
  }

}
