package co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data;

import co.edu.uco.ucobet.generales.crosscutting.helpers.TextHelper;

public enum CodigoMensaje {

	M00001(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00001", true),
	M00002(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00002", true),
	M00003(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00003", true),
	M00004(TipoMensaje.TECNICO, CategoriaMensaje.ERROR, "00004", true),
	M00005(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00005", true),
	M00006(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00006", true),
	M00007(TipoMensaje.USUARIO, CategoriaMensaje.EXITO, "00007", true),
	M00008(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00008", true),
	M00009(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "00009", true),
	M000010(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000010", true),
	M000011(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000011", true),
	M000012(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000012", true),
	M000013(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000013", true),
	M000014(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000014", true),
	M000015(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000015", true),
	M000016(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000016", true),
	M000017(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000017", true),
	M000018(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000018", true),
	M000019(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000019", true),
	M000020(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000020", true),
	M000021(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000021", true),
	M000022(TipoMensaje.USUARIO, CategoriaMensaje.ERROR, "000022", true);

	private TipoMensaje tipo;
	private CategoriaMensaje categoria;
	private String codigo;
	private boolean base;

	private CodigoMensaje(TipoMensaje tipo, CategoriaMensaje categoria, String codigo, boolean base) {
		setTipo(tipo);
		setCategoria(categoria);
		setCodigo(codigo);
		setBase(base);
	}

	public final TipoMensaje getTipo() {
		return tipo;
	}

	public final CategoriaMensaje getCategoria() {
		return categoria;
	}

	public final String getCodigo() {
		return codigo;
	}

	public final boolean isBase() {
		return base;
	}

	private final void setTipo(TipoMensaje tipo) {
		this.tipo = tipo;
	}

	private final void setCategoria(CategoriaMensaje categoria) {
		this.categoria = categoria;
	}

	private final void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	private final void setBase(boolean base) {
		this.base = base;
	}

	public String getIdentificador() {
		return TextHelper.concatenate(getTipo().name(), TextHelper.UNDERLINE, getCategoria().name(),
				TextHelper.UNDERLINE, getCodigo());
	}

}
