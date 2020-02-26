package co.com.k4soft.loginmvp;

import co.com.k4soft.loginmvp.dto.LoginDTO;

public interface Login {

    interface View{

        LoginDTO getLogin();

        void solicitarCredenciales();

        void solicitarUsuario();
    }

    interface Presenter{

        void solicitarCredenciales();

        void solicitarUsuario();

        void validarInformacion();
    }

    interface Model{

        void setLogin(LoginDTO login);

        void validarInformacion();
    }


}
