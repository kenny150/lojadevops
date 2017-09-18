package br.com.indra.jovemprofissional;


//classes minhas
import br.com.indra.jovemprofissional.repository.*;
import br.com.indra.jovemprofissional.model.*;

//spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LojaController {
	
	@Autowired
	private UserRepository repository;
	
	//Mapeamento do Index
	@RequestMapping("/")
	public String index(){
		return "indexLoja";
	}
	//mapeamento da pagina de produtos
	@RequestMapping("/produtos")
	public String produtos(){
		return "produtos";
	}
	//mapeamento da pagina de cadastros
	@RequestMapping("cadastro")
	public String cadastro(){
		return "cadastro";
	}

	//Metodo de checagem do login com o banco de dados
	@RequestMapping(value= "logar", method = RequestMethod.POST)
	public String verificar(@RequestParam("Username") String nome, @RequestParam("Password") String senha, Model model)
	{
		
		System.out.println("Login...");
		
		if(repository.exists(nome))
		{
			
			if(senha.equals(repository.findOne(nome).getPASSWORD()))
			{	        
				System.out.println("logou");
				//Proxima pagina-->
				return "/produtos";

			}
			
		}else{
			
		
		System.out.println("erro login");
		return "indexLoja";
			
		}
		return "indexLoja";		

	}

	//mapeamento cadastro
	@RequestMapping("cadastrado")
	public String salvar(@RequestParam("username") String nome, @RequestParam("password") String senha){

		if(valida(nome) && valida(senha)){
			if(!repository.exists(nome)){

				Usuario novoUsuario = new Usuario();

				novoUsuario.setUSERNAME(nome);
				novoUsuario.setPASSWORD(senha);
				repository.save(novoUsuario);

			}
			System.out.println("Sucesso");	    	
			return "indexloja";

		} else{	


			System.out.println("erro cadastro");
			return "cadastro";
		}
	}

	//metodo de valida��o para inputs diferentes de null
	public Boolean valida(String entrada)
	{
		if(!entrada.isEmpty())
		{
			return true;
		}else {
			return false;
		}
	}

	
}