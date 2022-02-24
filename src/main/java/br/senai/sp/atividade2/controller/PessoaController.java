package br.senai.sp.atividade2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.senai.sp.atividade2.dao.PessoaDao;
import br.senai.sp.atividade2.model.Pessoa;

@Controller
public class PessoaController {
		
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "salvarObj", method = RequestMethod.POST)
	public String salvar(Pessoa pessoa) {
		
		System.out.println(pessoa.getNome());
		System.out.println(pessoa.getEndereco());
		System.out.println(pessoa.getEmail());
		System.out.println(pessoa.getGenero());		
		System.out.println(pessoa.getCelular());
		System.out.println(pessoa.getNascimento());
		System.out.println(pessoa.getProdInteresse());
		
		PessoaDao dao = new PessoaDao();
		
		if (pessoa.getId() == null) {
			dao.inserir(pessoa);	
		}else {
			dao.atualizar(pessoa);
		}
				
		return "sucesso";
	}
	
	@RequestMapping("lista_pessoa")
	public String listar(Model model) {
			PessoaDao dao = new PessoaDao();
			model.addAttribute("pessoas", dao.listar());
			return "lista_pessoa";
		
	}
	
	@RequestMapping("excluirPessoa")
	public String excluir(long idPessoa) {
		PessoaDao dao = new PessoaDao();
		dao.excluir(idPessoa);
		return "redirect:lista_pessoa";
		
	}
	
	@RequestMapping("alterarPessoa")
	public String alterar(long idPessoa, Model model) {
		PessoaDao dao = new PessoaDao();
		model.addAttribute("pessoa", dao.buscar(idPessoa));
		
		return "forward:/";
	}
	
	@RequestMapping("filtroGenero")
	public String filtroGenero(Model model) {
		PessoaDao dao = new PessoaDao();
		model.addAttribute("pessoas", dao.filtroGenero());
		
		return "lista_pessoa";
	}
	
	@RequestMapping("estatisticaGenero")
	public String estatistica(String genero, Model model) {
			int qtdMasc, qtdFem;
			PessoaDao dao = new PessoaDao();
			
			qtdMasc = dao.estatisticaGenero("masculino");
			qtdFem = dao.estatisticaGenero("feminino");
			
			//para retornar os dados no jsp
			model.addAttribute("masculino", qtdMasc);
			model.addAttribute("feminino", qtdFem);

			
			return "estatisticas";
		
	}

}
