package controller;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.Bebida;

import service.BebidaService;

@ManagedBean(name = "cadastrarBebida")
@SessionScoped
public class CadastrarBebidaBean {
	
	private Bebida bebida;
	private FacesMessage mensagem = null;
	private FacesContext context = null;
	
	public void prepararCadastro() {
			this.bebida = new Bebida();
			if (mensagem != null) {
				context = FacesContext.getCurrentInstance();
				context.addMessage("messages", mensagem);
			}
	}

	public void salvar() {
		BebidaService.salvarBebida(bebida);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Salvo com Sucesso!", null);
		FacesContext.getCurrentInstance().addMessage(null, message);
		this.bebida = bebida;
	}

	public Bebida getBebida() {
		return this.bebida;
	}

	public void setBebida(Bebida bebida) {
		this.bebida = bebida;
	}


	public void limparDados() {
		this.bebida = new Bebida();
	}
}
