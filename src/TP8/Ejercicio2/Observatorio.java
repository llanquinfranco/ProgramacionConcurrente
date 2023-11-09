package TP8.Ejercicio2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Fran
 */
public class Observatorio {

    private int capacidad;
    private int cantPersonas;
    private int cantDiscapacitados;
    private int cantMantenimiento;
    private boolean hayInvestigador;
    private Lock accesoObservatorio;
    private Condition visitantes;
    private Condition mantenimiento;
    private Condition investigadores;

    public Observatorio() {
        this.capacidad = 50;
        this.cantPersonas = 0;
        this.cantDiscapacitados = 0;
        this.cantMantenimiento = 0;
        this.hayInvestigador = false;
        this.accesoObservatorio = new ReentrantLock();
        this.visitantes = accesoObservatorio.newCondition();
        this.mantenimiento = accesoObservatorio.newCondition();
        this.visitantes = accesoObservatorio.newCondition();
    }

    public void entrarPersona() {
        try {
            accesoObservatorio.lock();
            while (cantPersonas >= capacidad || hayInvestigador || cantMantenimiento > 0) {
                visitantes.await();
            }
            cantPersonas++;
            System.out.println("El " + Thread.currentThread().getName() + " esta estudiando las Estrellas");
            System.out.println("Cantidad de personas en la sala: " + cantPersonas);
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void salirPersona() {
        try {
            accesoObservatorio.lock();
            cantPersonas--;
            System.out.println("El " + Thread.currentThread().getName() + " salio de la sala");
            System.out.println("Cantidad de personas en la sala: " + cantPersonas);
            if (cantPersonas == 0) {
                investigadores.signal();
            } else {
                visitantes.signal();
                mantenimiento.signal();
            }
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void entrarDiscapacitado() {
        try {
            accesoObservatorio.lock();
            // cantPersonas >= 30
            while (cantPersonas >= capacidad || hayInvestigador || cantMantenimiento > 0) {
                visitantes.await();
            }
            cantPersonas++;
            cantDiscapacitados++;
            System.out.println("El " + Thread.currentThread().getName() + " (en silla de ruedas) esta estudiando las Estrellas");
            System.out.println("Cantidad de personas en la sala: " + cantPersonas);
            if (capacidad == 50) {
                capacidad = 30;
                System.out.println("La capacidad se redujo a 30 personas");
            }
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void salirDiscapacitado() {
        try {
            accesoObservatorio.lock();
            cantPersonas--;
            cantDiscapacitados--;
            System.out.println("El " + Thread.currentThread().getName() + " (en silla de ruedas) salio de la sala");
            System.out.println("Cantidad de personas en la sala: " + cantPersonas);
            if (cantDiscapacitados == 0) {
                capacidad = 50;
                System.out.println("La capacidad se aumento a 50 personas");
            }
            if (cantPersonas == 0) {
                investigadores.signal();
            } else {
                visitantes.signal();
                mantenimiento.signal();
            }
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void entrarMantenimiento() {
        try {
            accesoObservatorio.lock();
            while (cantPersonas > 0 || hayInvestigador || cantMantenimiento >= capacidad) {
                mantenimiento.await();
            }
            cantMantenimiento++;
            System.out.println("La " + Thread.currentThread().getName() + " esta limpiando la sala");
            System.out.println("Gente limpiando la sala: " + cantMantenimiento);
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void salirMantenimiento() {
        try {
            accesoObservatorio.lock();
            cantMantenimiento--;
            System.out.println("La " + Thread.currentThread().getName() + " termino de limpiar");
            System.out.println("Gente limpiando la sala: " + cantMantenimiento);
            if (cantMantenimiento == 0) {
                investigadores.signal();
                visitantes.signal();
            } else {
                mantenimiento.signal();
            }
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void entrarInvestigador() {
        try {
            accesoObservatorio.lock();
            while (cantPersonas > 0 || cantMantenimiento > 0 || hayInvestigador) {
                investigadores.await();
            }
            hayInvestigador = true;
            System.out.println("El " + Thread.currentThread().getName() + " esta analizando las estrellas");
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

    public void salirInvestigador() {
        try {
            accesoObservatorio.lock();
            hayInvestigador = false;
            System.out.println("El " + Thread.currentThread().getName() + " realizo su trabajo de investigacion");
            mantenimiento.signal();
            investigadores.signal();
            visitantes.signal();
        } catch (Exception ex) {

        } finally {
            accesoObservatorio.unlock();
        }
    }

}
