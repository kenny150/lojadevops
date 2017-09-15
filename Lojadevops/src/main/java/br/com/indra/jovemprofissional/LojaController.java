package br.com.indra.jovemprofissional;

//rhino
import java.io.FileNotFoundException;
import groovy.util.ScriptException;

//classes minhas
import br.com.indra.jovemprofissional.repository.*;
import br.com.indra.jovemprofissional.model.*;

//spring
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LojaController{
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

	@RequestMapping(value= "logar", method = RequestMethod.POST)
	public String verificar(@RequestParam("Username") String nome, @RequestParam("Password") String senha, Model model)
	{
		String resul="teste";
		repository.exists(nome);
		
		if(nome.equals(resul) && senha.equals(resul))
		{	        
			System.out.println("logou");
			//Proxima pagina-->
			return "/produtos";

		}else{	    		
			System.out.println("erro login");
			
			return "indexLoja";
		}

	}
	

	//mapeamento cadastro
	@RequestMapping("cadastro")
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
	

	
	//Mapeamento do ListaClientes
	/*@RequestMapping("listaconvidados")
	public String listaConvidados(Model model){

		Iterable<Cliente> clientes = repositoryCli.findAll();
		model.addAttribute("listaClientes", clientes);

		return "listaconvidados";
	}*/

	//Mapeamento do listaequipamentos
	/*@RequestMapping("listaequipamentos")
	public String listaEquipamentos(Model model){

		Iterable<Equipamento> equips = repositoryEquip.findAll();
		model.addAttribute("listaEquipamentos", equips);


		return "listaequipamentos";
	}*/

	//Mapeamento para o metodo salvar
	/*@RequestMapping(value= "salvar", method = RequestMethod.POST)
	public String salvar(@RequestParam("ID_CLIENTE") int ID_CLIENTE, @RequestParam("NO_CLIENTE") String NO_CLIENTE, Model model){

		Cliente novoCliente = new Cliente(ID_CLIENTE, NO_CLIENTE);
		repositoryCli.save(novoCliente);

		Iterable<Cliente> clientes = repositoryCli.findAll();
		model.addAttribute("listaClientes", clientes);

		return "listaconvidados";
	}*/
	//Mapeamento para o metodo deletar
	/*@RequestMapping(value= "deletar", method = RequestMethod.POST)
	public String deletar(@RequestParam("ID_CLIENTE") int ID_CLIENTE, Model model){

		Cliente delCliente = repositoryCli.findOne(ID_CLIENTE);
		repositoryCli.delete(delCliente);	

		Iterable<Cliente> clientes = repositoryCli.findAll();
		model.addAttribute("listaClientes", clientes);

		return "listaconvidados";
	}*/

	/*@Autowired											//
	private ClienteRepository repositoryCli;				//
															//Amarra��o com objeto do BD
	@Autowired												//
	private EquipamentoRepository repositoryEquip;			//
	 */



}
