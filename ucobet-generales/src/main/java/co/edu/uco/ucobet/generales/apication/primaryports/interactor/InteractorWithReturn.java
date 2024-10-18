package co.edu.uco.ucobet.generales.apication.primaryports.interactor;

public interface InteractorWithReturn<T, R>{
	
	R execute(T data);

}
