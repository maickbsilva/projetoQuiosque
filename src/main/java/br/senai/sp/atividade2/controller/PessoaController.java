package br.senai.sp.atividade2.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

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
			pessoa.setDataCadastro(Calendar.getInstance());
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
	
	@RequestMapping("estatisticas")
	public String estatistica(String genero, Model model) {
			int qtdMasc, qtdFem, jovem = 0, adulto = 0, idoso = 0, seg = 0, ter = 0, quar = 0, quin = 0, sex = 0, sab = 0, dom = 0, manha = 0, tarde = 0, noite = 0;
			
			PessoaDao dao = new PessoaDao();
			
			List<Pessoa> lista = dao.listar();
			
			for (Pessoa pessoa : lista) {
				if (pessoa.getIdade() < 18) {
					jovem++;
				}else if (pessoa.getIdade() < 60) {
					adulto++;
				}else {
					idoso++;
				}	
			
				//pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK);
				
				if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 1) {
					dom++;
				}else if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 2) {
					seg++;
				}else if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 3) {
					ter++;
				}else if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 4) {
					quar++;
				}else if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 5) {
					quin++;
				}else if (pessoa.getDataCadastro().get(Calendar.DAY_OF_WEEK) == 6) {
					sex++;
				}else {
					sab++;
				}
							
				//pessoa.getDataCadastro().get(Calendar.HOUR_OF_DAY);
				
				if (pessoa.getDataCadastro().get(Calendar.HOUR_OF_DAY) < 12) {
					manha++;
				}else if (pessoa.getDataCadastro().get(Calendar.HOUR_OF_DAY) < 18) {
					tarde++;
				}else {
					noite++;
				}
				
			}
			
			
			qtdMasc = dao.estatisticaGenero("masculino");
			qtdFem = dao.estatisticaGenero("feminino");
			
			//para retornar os dados no jsp
			model.addAttribute("pessoas", dao.listar());
			model.addAttribute("jovem", jovem);
			model.addAttribute("adulto", adulto);
			model.addAttribute("idoso", idoso);
			model.addAttribute("masculino", qtdMasc);
			model.addAttribute("feminino", qtdFem);
			model.addAttribute("domingo", dom);
			model.addAttribute("segunda", seg);
			model.addAttribute("terca", ter);
			model.addAttribute("quarta", quar);
			model.addAttribute("quinta", quin);
			model.addAttribute("sexta", sex);
			model.addAttribute("sabado", sab);
			model.addAttribute("manha", manha);
			model.addAttribute("tarde", tarde);
			model.addAttribute("noite", noite);
			
			return "estatisticas";	
	}

}

