package co.edu.uco.ucobet.generales.apication.usecase;

public interface UseCaseWithReturn<D, R> {
	R execute(D domain);
}
