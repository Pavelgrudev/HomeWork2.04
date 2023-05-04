import exception.WrongPasswordException;
import exception.WrongLoginException;
public class Main {

    private static final String VALIDATE_PATTERN="^[a-z,A-Z0-9_]+$";
    public static void main(String[] args) throws WrongPasswordException {

        check("gggggg", "pass","pass");
        check("111111111111111111111111111111", "pass","pass");
        check("11111111","passpasspasspasspasspass","passpasspasspasspasspasspass");
        check("ЯЯпппПП","pass","pass");
        check("ffffff","pass","pass2");
    }
    private static boolean check(String login,String pass, String confirmPass) {
        boolean isValid=true;
        try {
            checkLogin(login);
            checkPass(pass, confirmPass);
        } catch (WrongLoginException e) {
            System.out.println("Ошибка с введённым логином " + e.getMessage());
            isValid=false;
        } catch (WrongPasswordException e) {
            System.out.println("Ошибка с введённым паролем " + e.getMessage());
            isValid=false;
        }
        return isValid;
    }

    private static void checkLogin(String login) throws WrongLoginException {
        if(!login.matches(VALIDATE_PATTERN)){
            throw new WrongLoginException("Параметр Логин может  содержать в себе только латинские буквы, цифры и знак подчеркивания. ");
        } else if (login.length()>20) {
            throw new WrongLoginException("Логин не может быть более 20 символов");
        }}
    private static void checkPass(String password, String confirmPassword) throws WrongPasswordException {
        if(!password.matches(VALIDATE_PATTERN)){
            throw new WrongPasswordException("Параметр пароль может содержать только латинские буквы, цифры и знак подчеркивания. ");
        } else if (password.length()>20) {
            throw new WrongPasswordException("Пароль не может быть более 20 символов");} else if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли не совпадают");
        }

    }

}
