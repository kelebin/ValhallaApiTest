package Utils;

public enum TiposStatus {
	
	OK(200, "Sucesso"),
	Created(201, "Criado"),
	NoContent(204, "No content"),
	BadRequest(400,"Requisicao invalida"),
	NotFound(404,"Nao encontrado"),
	InternalError(500,"Erro interno");
	
	
	private Integer codigo;
	
	private String descricao;
	
	TiposStatus(Integer codigo, String descricao) {
		
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return this.codigo;
	}

}
