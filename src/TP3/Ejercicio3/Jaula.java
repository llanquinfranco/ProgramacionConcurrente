package TP3.Ejercicio3;

/**
 *
 * @author Fran
 */
public class Jaula {

    Hamaca hamaquita = new Hamaca();
    Plato platito = new Plato();
    Rueda ruedita = new Rueda();
    // que se hace en la jaula

    // NO son SYNCHRONIZED por que sino seguiria pasando que hay un solo hamster en la jaula
    public void comer(int numeroHamster) {
        platito.usarPlato(numeroHamster);
    }

    public void correr(int numeroHamster) {
        ruedita.usarRueda(numeroHamster);
    }

    public void dormir(int numeroHamster) {
        hamaquita.usarHamaca(numeroHamster);
    }

}
