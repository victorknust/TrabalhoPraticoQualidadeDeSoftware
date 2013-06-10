package br.edu.uniritter.jefferson.imc.exception;

public class SituacaoIMCException extends Exception {

	private static final long serialVersionUID = 1L;
	private String mensagem;
	private Throwable causa;

	public SituacaoIMCException(String mensagem, Throwable causa) {
		this.mensagem = mensagem;
		this.causa = causa;
	}

	public SituacaoIMCException(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Throwable getCausa() {
		return causa;
	}

	public void setCausa(Throwable causa) {
		this.causa = causa;
	}
}
