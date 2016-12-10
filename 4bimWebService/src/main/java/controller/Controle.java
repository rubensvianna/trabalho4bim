package controller;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import modelo.Usuario;

public class Controle {
	private static List<Usuario> listaUsuario = new ArrayList<>();

	public void cadastrar(Usuario objeto) {
        try {
            listaUsuario.add(objeto);
            System.out.println(listaUsuario.size());
        	
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public String exibirLista() {
		String usuarios = "";
		try {
			for (Usuario lista : listaUsuario) {
				usuarios = "Nome: " + lista.getNome() + "\nCPF: " + lista.getCpf() + "\ne-mail: " + lista.getEmail()
						+ "\nSenha: " + lista.getSenha()+ "\n-----------------------------------------------------"; 
				System.out.println(usuarios);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usuarios;
	}
	
	public void logar(String usuario, String senha) {
        try {
        	listaUsuario.forEach(new Consumer<Usuario>() {
				@Override
				public void accept(Usuario t) {
					System.out.println(t.getNome());	
				}	
			});
        	     
            if(listaUsuario.stream().filter(login -> login.getEmail().equals(usuario) && login.getSenha().equals(senha)) != null);{
              	  		System.out.println("Logado com sucesso");
            }
            
        } catch (Exception e) {
            e.printStackTrace();   
       }
    }
}