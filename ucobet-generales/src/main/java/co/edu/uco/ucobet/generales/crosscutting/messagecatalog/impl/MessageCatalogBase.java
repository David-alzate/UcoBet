package co.edu.uco.ucobet.generales.crosscutting.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.edu.uco.ucobet.generales.crosscutting.exception.CroscutingUcobetException;
import co.edu.uco.ucobet.generales.crosscutting.helpers.ObjectHelper;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.MessageCatalog;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.CodigoMensaje;
import co.edu.uco.ucobet.generales.crosscutting.messagecatalog.data.Mensaje;

public class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Mensaje> mensajes = new HashMap<>();

	@Override
	public void inicializar() {
		mensajes.clear();
		mensajes.put(CodigoMensaje.M00001.getIdentificador(), new Mensaje(CodigoMensaje.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		mensajes.put(CodigoMensaje.M00002.getIdentificador(), new Mensaje(CodigoMensaje.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		mensajes.put(CodigoMensaje.M00003.getIdentificador(), new Mensaje(CodigoMensaje.M00003,
				"El identificador del mensaje \"${1}\" que se intentó obtener, no está en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00004.getIdentificador(), new Mensaje(CodigoMensaje.M00004,
				"El mensaje con identificador \"${1}\" que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		mensajes.put(CodigoMensaje.M00005.getIdentificador(),
				new Mensaje(CodigoMensaje.M00005, "Ciudad Registrada Con Exito"));
		mensajes.put(CodigoMensaje.M00006.getIdentificador(), new Mensaje(CodigoMensaje.M00006,
				"Se ha presentado un problema tratando de registrar la nueva ciudad"));
		mensajes.put(CodigoMensaje.M00007.getIdentificador(),
				new Mensaje(CodigoMensaje.M00007, "Estados consultados exitosamente"));
		mensajes.put(CodigoMensaje.M00008.getIdentificador(),
				new Mensaje(CodigoMensaje.M00008, "Se ha presentado un problema tratando de consultar los estados"));
		mensajes.put(CodigoMensaje.M00009.getIdentificador(), new Mensaje(CodigoMensaje.M00009,
				"Se ha presentado un problema INESPERADO tratando de Registrar la información de la ciudad."));
		mensajes.put(CodigoMensaje.M000010.getIdentificador(), new Mensaje(CodigoMensaje.M000010,
				"El repository o las rules para Registrar el cliente llegó nulo..."));
		mensajes.put(CodigoMensaje.M000011.getIdentificador(),
				new Mensaje(CodigoMensaje.M000011, "Ya existe una ciudad con este id"));
		mensajes.put(CodigoMensaje.M000012.getIdentificador(),
				new Mensaje(CodigoMensaje.M000012, "No existe la ciudad con el id indicado"));
		mensajes.put(CodigoMensaje.M000013.getIdentificador(),
				new Mensaje(CodigoMensaje.M000013, "El Id de la ciudad no puede ser Nulo"));
		mensajes.put(CodigoMensaje.M000014.getIdentificador(),
				new Mensaje(CodigoMensaje.M000014, "La ciudad esta siendo utilizada en otra parte del sistema"));
		mensajes.put(CodigoMensaje.M000015.getIdentificador(),
				new Mensaje(CodigoMensaje.M000015, "El formato del nombre no es valido"));
		mensajes.put(CodigoMensaje.M000016.getIdentificador(),
				new Mensaje(CodigoMensaje.M000016, "El nombre de la ciudad para este departamento ya existe"));
		mensajes.put(CodigoMensaje.M000017.getIdentificador(),
				new Mensaje(CodigoMensaje.M000017, "El nombre de la ciudad no puede ser vacio"));
		mensajes.put(CodigoMensaje.M000018.getIdentificador(),
				new Mensaje(CodigoMensaje.M000018, "El nombre de la ciudad no puede ser nulo"));
		mensajes.put(CodigoMensaje.M000019.getIdentificador(),
				new Mensaje(CodigoMensaje.M000019, "El tamaño para el nombre de la ciudad no es valido"));
		mensajes.put(CodigoMensaje.M000020.getIdentificador(),
				new Mensaje(CodigoMensaje.M000020, "El estado no existe."));
		mensajes.put(CodigoMensaje.M000021.getIdentificador(),
				new Mensaje(CodigoMensaje.M000021, "El estado no pueder ser el valor por defecto"));
		mensajes.put(CodigoMensaje.M000022.getIdentificador(),
				new Mensaje(CodigoMensaje.M000022, "El Id del estado no puede ser nulo"));

	}

	@Override
	public String obtenerContenidoMensaje(CodigoMensaje codigo, String... parametros) {
		return obtenerMensaje(codigo, parametros).getContenido();
	}

	@Override
	public Mensaje obtenerMensaje(CodigoMensaje codigo, String... parametros) {
		if (ObjectHelper.isNull(codigo)) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00001);
			throw new CroscutingUcobetException(mensajeTecnico, mensajeUsuario, new Exception());
		}

		if (!codigo.isBase()) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00004, codigo.getIdentificador());
			throw new CroscutingUcobetException(mensajeTecnico, mensajeUsuario, new Exception());
		}

		if (!mensajes.containsKey(codigo.getIdentificador())) {
			var mensajeUsuario = obtenerContenidoMensaje(CodigoMensaje.M00002);
			var mensajeTecnico = obtenerContenidoMensaje(CodigoMensaje.M00003, codigo.getIdentificador());
			throw new CroscutingUcobetException(mensajeTecnico, mensajeUsuario, new Exception());
		}
		return mensajes.get(codigo.getIdentificador());
	};
}
