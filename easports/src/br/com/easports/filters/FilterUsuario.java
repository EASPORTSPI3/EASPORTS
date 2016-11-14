package br.com.easports.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


//quando acessar qualquer coisa dentro do arearestrita, ele começa a olhar

@WebFilter("/arearestrita/*")
public class FilterUsuario implements Filter {


    public FilterUsuario() {
        
    }

	public void destroy() {
		
	}

	//método executado quando a pasta arearestrita for acessada

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		
		//converter os parametros do filtrar para ficarem comptiveis com os parametros de 
		//um servlet (HttpServletRequest e HttpServletRsponse)
		
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		//instanciar a session
		
		HttpSession session = req.getSession();
		
		//verificar se existe na sessão um objeto -> usuariologado
		
		if(session.getAttribute("usuarioLogado") != null){
			
			chain.doFilter(request, response);
			
		}
		else{
			
			//redirecionar de volta para a página de login
			
			resp.sendRedirect("/easports/login.jsp");
			
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
