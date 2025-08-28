package android.murilo.loginmvc.view;

import android.content.Intent;
import android.murilo.loginmvc.R;
import android.murilo.loginmvc.controller.UsuarioController;
import android.murilo.loginmvc.model.Usuario;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    Usuario usuario;
    UsuarioController controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        usuario = new Usuario();
        controller = new UsuarioController(getApplicationContext());

        String user = usuario.getUserEmail().toString();
        String pass = usuario.getPassword().toString();

        usuario.setUserEmail(user);
        usuario.setPassword(pass);

        boolean isCheckUser = controller.usuarioeSenha(user, pass);

        if(!isCheckUser){

        }else{
            Intent home = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(home);
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}