package service;
import java.time.LocalDate;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import controller.Controle;
import modelo.Usuario;

@Path("/WebService")
@ApplicationPath("/resource")
public class WebService extends Application {
	Controle controle = new Controle();

	 //http://localhost:8080/4bimWebService/resource/WebService/cadastrar	 
	 @POST
	 @Path("/cadastrar")
	 @Consumes("application/json")
	 public Response addUsuario(
	 @FormParam("nome") String nome,
	 @FormParam("cpf") String cpf,
	 @FormParam("email") String email,
	 @FormParam("senha") String senha,
	 @FormParam("ano") Integer ano,
	 @FormParam("mes") Integer mes,
	 @FormParam("dia") Integer dia) {
	 try{
	 Usuario usuario= new Usuario();
	 usuario.setNome(nome);
	 usuario.setCpf(cpf);
	 usuario.setEmail(email);
	 usuario.setSenha(senha);
	 usuario.setDataNascimento(LocalDate.of(ano, mes, dia));
	 controle.cadastrar(usuario);
	 return Response.status(200).entity("Inserido com sucesso!").build();
	 }catch(Exception e){
	 throw new WebApplicationException(500);
	 }
}
	
	//http://localhost:8080/4bimWebService/resource/WebService/listaUsuarios
	@GET
	@Path("/listaUsuarios")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String exibirCadastro() {
		return controle.exibirLista();
	}

	//http://localhost:8080/4bimWebService/resource/WebService/autenticar
	@GET
	@Path("/autenticar/{login}")
	@Produces("application/json")
	public Response logarUsuario(@PathParam("login") String login) {
		try {
			String[] partes = login.split(":");
			controle.logar(partes[0], partes[1]);

			return Response.status(200).entity("Logado com sucesso").build();

		} catch (Exception e) {
			//throw new WebApplicationException(500);
			return Response.status(200).entity("Erro ao Logar").build();
		}
	}
}