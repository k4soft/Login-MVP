package co.com.k4soft.loginmvp;

public class LoginPresenter implements Login.Presenter{


    private final Login.View view;
    private final Login.Model model;

    public LoginPresenter(Login.View view) {
        this.view = view;
        model = new LoginModel(this);
    }

    @Override
    public void solicitarCredenciales() {
        if(view != null){
            view.solicitarCredenciales();
        }
    }

    @Override
    public void solicitarUsuario() {
        if(view != null){
            view.solicitarUsuario();
        }
    }

    @Override
    public void validarInformacion() {
        if(view != null){
            model.setLogin(view.getLogin());
            model.validarInformacion();
        }
    }
}
