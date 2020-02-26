package co.com.k4soft.loginmvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.k4soft.loginmvp.dto.LoginDTO;

public class MainActivity extends AppCompatActivity implements Login.View {

    @BindView(R.id.txtUser)
    public EditText txtUser;
    @BindView(R.id.txtPassword)
    public EditText txtPassword;



    private LoginDTO loginDTO;
    private Login.Presenter presenter;

    @Override
    public LoginDTO getLogin() {
        return loginDTO;
    }

    public void onClikBtnAceptar(View view) {
        setLogin();
        presenter.validarInformacion();
    }

    private void setLogin() {
       loginDTO.setUser(txtUser.getText().toString());
       loginDTO.setPassword(txtPassword.getText().toString());
    }

    @Override
    public void solicitarCredenciales() {
        Toast.makeText(getApplicationContext(),R.string.credenciales_requeridas,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void solicitarUsuario() {
        txtUser.setError(getString(R.string.requerido));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = new LoginPresenter(this);
        loginDTO = new LoginDTO();
    }
}
