package co.com.k4soft.loginmvp;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import co.com.k4soft.loginmvp.dto.LoginDTO;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class LoginModelTest {

    @Mock
    private Login.View view;
    private Login.Presenter presenter;
    private Login.Model model;

    @Before
    public void setUp(){
        presenter = new LoginPresenter(view);
        model = new LoginModel(presenter);
    }

    @Test
    public void verificarCredencialesNulas(){
        when(view.getLogin()).thenReturn(null);
        model.setLogin(view.getLogin());
        model.validarInformacion();
        verify(view).solicitarCredenciales();
    }

    @Test
    public void verificarCredencialesconUsuarioNull(){
        when(view.getLogin()).thenReturn(new LoginDTO(null,null));
        model.setLogin(view.getLogin());
        model.validarInformacion();
        verify(view).solicitarUsuario();
    }

    @Test
    public void verificarCredencialesconUsuarioVacio(){
        when(view.getLogin()).thenReturn(new LoginDTO("",null));
        model.setLogin(view.getLogin());
        model.validarInformacion();
        verify(view).solicitarUsuario();
    }

}