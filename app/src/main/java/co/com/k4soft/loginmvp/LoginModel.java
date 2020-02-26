package co.com.k4soft.loginmvp;

import co.com.k4soft.loginmvp.dto.LoginDTO;

public class LoginModel implements Login.Model {


    private final Login.Presenter presenter;
    private LoginDTO login;

    public LoginModel(Login.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void setLogin(LoginDTO login) {

        this.login = login;
    }

    @Override
    public void validarInformacion() {
        if (loginIsNull()) {
            presenter.solicitarCredenciales();
        } else if (usuarioIsNull() || usuarioIsEmpty()) {
            presenter.solicitarUsuario();
        }


    }

    private boolean usuarioIsEmpty() {
        return "".equals(login.getUser());
    }

    private boolean usuarioIsNull() {
        return login.getUser() == null;
    }

    private boolean loginIsNull() {
        return login == null;
    }
}
