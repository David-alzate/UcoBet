package co.edu.uco.ucobet.generales.crosscutting.messagecatalog;

import co.edu.uco.ucobet.generales.crosscutting.exception.CroscutingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.Mensaje;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.impl.MessageCatalogBase;

public class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();

	static {
		inicializar();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.inicializar();

	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return base;
	}

	private static final Mensaje getMensaje(final CodigoMensaje codigo, final String... parametros) {
		if (ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(CodigoMensaje.M00001);
			throw new CroscutingUcobetException(mensajeTecnico, mensajeUsuario, new Exception());
		}

		return getStrategy(codigo.isBase()).obtenerMensaje(codigo, parametros);

	}

	public static final String getContenidoMensaje(final CodigoMensaje codigo, final String... parametros) {
		return getMensaje(codigo, parametros).getContenido();

	}
	
	

}
