package android.murilo.loginmvc.controller;


import android.content.ContentValues;
import android.content.Context;

import android.murilo.loginmvc.datamodel.UsuarioDataModel;
import android.murilo.loginmvc.datasource.AppDataBase;
import android.murilo.loginmvc.model.Usuario;

import androidx.annotation.NonNull;

import java.util.Collections;
import java.util.List;


public class UsuarioController extends AppDataBase implements iCrud<Usuario> {

     ContentValues dadosDoObjeto;
    public UsuarioController(Context context) {
        super(context);
    }

    @Override
    public boolean incluir(Usuario obj) {
        dadosDoObjeto = new ContentValues();
        dadosDoObjeto.put(UsuarioDataModel.NOME, obj.getUserName());
        dadosDoObjeto.put(UsuarioDataModel.EMAIL, obj.getUserEmail());
        dadosDoObjeto.put(UsuarioDataModel.SENHA, obj.getPassword());
        return false;
    }

    @Override
    public boolean alterar(Usuario obj) {
        return false;
    }

    @Override
    public boolean deletar(Usuario obj) {
        return false;
    }

    @Override
    public List<Usuario> listar() {
        return Collections.emptyList();
    }
    public boolean usuarioeSenha(String username, String password){
        return checkUserPassword(username, password);
    }
    public boolean usuario(String user){
        return checkUser(user);
    }
}
