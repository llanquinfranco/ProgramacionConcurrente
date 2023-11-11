package TP8.Ejercicio2;

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

    public Observatorio() {
        this.capacidad = 50;
        this.cantPersonas = 0;
        this.cantDiscapacitados = 0;
        this.cantMantenimiento = 0;
        this.hayInvestigador = false;
    }

    public synchronized void entrarPersona() throws InterruptedException {
        while (cantPersonas >= capacidad || hayInvestigador || cantMantenimiento > 0) {
            this.wait();
        }
        cantPersonas++;
        System.out.println("El " + Thread.currentThread().getName() + " esta estudiando las Estrellas");
        System.out.println("Cantidad de personas en la sala: " + cantPersonas);
    }

    public synchronized void salirPersona() {
        cantPersonas--;
        System.out.println("El " + Thread.currentThread().getName() + " salio de la sala");
        System.out.println("Cantidad de personas en la sala: " + cantPersonas);
        this.notifyAll();
    }

    public synchronized void entrarDiscapacitado() throws InterruptedException {
        // cantPersonas >= 30
        while (cantPersonas >= capacidad || hayInvestigador || cantMantenimiento > 0) {
            this.wait();
        }
        cantPersonas++;
        cantDiscapacitados++;
        System.out.println("El " + Thread.currentThread().getName() + " (en silla de ruedas) esta estudiando las Estrellas");
        System.out.println("Cantidad de personas en la sala: " + cantPersonas);
        if (capacidad == 50) {
            capacidad = 30;
            System.out.println("La capacidad se redujo a 30 personas");
        }
    }

    public synchronized void salirDiscapacitado() {
        cantPersonas--;
        cantDiscapacitados--;
        System.out.println("El " + Thread.currentThread().getName() + " (en silla de ruedas) salio de la sala");
        System.out.println("Cantidad de personas en la sala: " + cantPersonas);
        if (cantDiscapacitados == 0) {
            capacidad = 50;
            System.out.println("La capacidad se aumento a 50 personas");
        }
        this.notifyAll();
    }

    public synchronized void entrarMantenimiento() throws InterruptedException {
        while (cantPersonas > 0 || hayInvestigador || cantMantenimiento >= capacidad) {
            this.wait();
        }
        cantMantenimiento++;
        System.out.println("La " + Thread.currentThread().getName() + " esta limpiando la sala");
        System.out.println("Gente limpiando la sala: " + cantMantenimiento);
    }

    public synchronized void salirMantenimiento() {
        cantMantenimiento--;
        System.out.println("La " + Thread.currentThread().getName() + " termino de limpiar");
        System.out.println("Gente limpiando la sala: " + cantMantenimiento);
        this.notifyAll();
    }

    public synchronized void entrarInvestigador() throws InterruptedException {
        while (cantPersonas > 0 || cantMantenimiento > 0 || hayInvestigador) {
            this.wait();
        }
        hayInvestigador = true;
        System.out.println("El " + Thread.currentThread().getName() + " esta analizando las estrellas");
    }

    public synchronized void salirInvestigador() {
        hayInvestigador = false;
        System.out.println("El " + Thread.currentThread().getName() + " realizo su trabajo de investigacion");
        this.notifyAll();
    }

}
