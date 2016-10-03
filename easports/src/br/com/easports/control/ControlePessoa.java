package br.com.easports.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.easports.entities.ClientePF;
import br.com.easports.entities.Endereco;
import br.com.easports.entities.PessoaFisica;
import br.com.easports.persistence.ClientePFDAO;
import br.com.easports.persistence.EnderecoDAO;
import br.com.easports.util.ConverteData;

@WebServlet("/ControlePessoa")
public class ControlePessoa extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ControlePessoa() {
        super();
    }

    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
    	String acao = request.getParameter("acao");
    	
    	if(acao != null){
    		
    		if(acao.equalsIgnoreCase("cadastrarpf")){
    			
    			try {
					
    				Endereco endereco = new Endereco();
        			
        			endereco.setLogradouro(request.getParameter("logradouro"));
        			endereco.setNumero(Integer.parseInt(request.getParameter("numero")));
        			endereco.setCep(request.getParameter("cep"));
        			endereco.setBairro(request.getParameter("bairro"));
        			endereco.setCidade(request.getParameter("cidade"));
        			endereco.setEstado(request.getParameter("estado"));
        			endereco.setPais(request.getParameter("pais"));
        			
        			EnderecoDAO enderecoDao = new EnderecoDAO();
        			
        			int idEndereço = enderecoDao.insert(endereco);
        			
        			ClientePF clientePf = new ClientePF();
        			
        			clientePf.setNome(request.getParameter("nome"));
        			clientePf.setTelefone(request.getParameter("telefone"));
        			clientePf.setCpf(request.getParameter("cpf"));
        			clientePf.setDataNasc(ConverteData.stringToDate(request.getParameter("datanasc")));
        			clientePf.setEndereco(endereco);
        			
        			ClientePFDAO clientePfDao = new ClientePFDAO();
        			
        			clientePfDao.insert(clientePf, idEndereço);
    				
				} 
    			catch (Exception e) {

					System.out.println(e.getMessage());
					
				}
    			
    		}
    		
    	}
    	
	}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
