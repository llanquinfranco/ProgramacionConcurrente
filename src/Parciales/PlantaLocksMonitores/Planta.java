package Parciales.PlantaLocksMonitores;

/**
 *
 * @author Fran
 */
public class Planta {

    private int cajaAgua;
    private int cajaVino;
    private int almacen;

    public Planta() {
        this.cajaAgua = 0;
        this.cajaVino = 0;
        this.almacen = 0;
    }

    public synchronized void prepararBotellaAgua() throws InterruptedException {
        while (cajaAgua == 10) {
            this.wait();
        }
        cajaAgua++;
        System.out.println("El " + Thread.currentThread().getName() + " ubico"
                + " una botella de agua saborizada en la caja");
        System.out.println("Caja de agua saborizada: " + cajaAgua + "/10");
        if (cajaAgua == 10) {
            this.notifyAll();
        }

    }

    public synchronized void prepararBotellaVino() throws InterruptedException {
        while (cajaVino == 10) {
            this.wait();
        }
        cajaVino++;
        System.out.println("El " + Thread.currentThread().getName() + " ubico"
                + " una botella de vino en la caja");
        System.out.println("Caja de vino: " + cajaVino + "/10");
        if (cajaVino == 10) {
            this.notifyAll();
        }

    }

    public synchronized void retirarCaja() throws InterruptedException {
        while (cajaAgua < 10 && cajaVino < 10) {
            this.wait();
        }
        if (cajaAgua == 10) {
            System.out.println("Se lleno la caja de agua saborizada y el empaquetador la retiro");
            almacen++;
            System.out.println("La caja de agua se guardo en el deposito");
            System.out.println("Almacen: " + almacen + "/10");
            if (almacen == 10) {
                this.notifyAll();
            }
        } else if (cajaVino == 10) {
            System.out.println("Se lleno la caja de vino y el empaquetador la retiro");
            almacen++;
            System.out.println("La caja de vino se guardo en el deposito");
            System.out.println("Almacen: " + almacen + "/10");
            if (almacen == 10) {
                this.notifyAll();
            }
        }
    }

    public synchronized void reponerCaja() {
        if (cajaAgua == 10) {
            cajaAgua = 0;
            System.out.println("Se repuso la caja de agua");
            this.notifyAll();
        } else if (cajaVino == 10) {
            cajaVino = 0;
            System.out.println("Se repuso la caja de vino");
            this.notifyAll();
        }
    }

    public synchronized void transportar() throws InterruptedException {
        while (almacen < 10) {
            this.wait();
        }
        almacen = 0;
        System.out.println("El almacen se lleno, un camion salio a repatir"
                + " todo el contenido del almacen");
        this.notifyAll();
    }
}

/*
public class Planta {

    private int cajaAgua;
    private int cajaVino;
    private int almacen;
    private Lock lockAgua;
    private Lock lockVino;
    private Lock lockAlmacen;
    private Condition empaquetador;
    private Condition transportador;
    private Condition embotelladoresAgua;
    private Condition embotelladoresVino;

    public Planta() {
        this.cajaAgua = 0;
        this.cajaVino = 0;
        this.almacen = 0;
        this.lockAgua = new ReentrantLock();
        this.lockVino = new ReentrantLock();
        this.lockAlmacen = new ReentrantLock();
        this.empaquetador = lockAlmacen.newCondition();
        this.transportador = lockAlmacen.newCondition();
        this.embotelladoresAgua = lockAgua.newCondition();
        this.embotelladoresVino = lockVino.newCondition();
    }

    public void prepararBotellaAgua() throws InterruptedException {
        try {
            lockAgua.lock();
            while (cajaAgua == 10) {
                embotelladoresAgua.await();
            }
            cajaAgua++;
            System.out.println("El " + Thread.currentThread().getName() + " ubico"
                    + " una botella de agua saborizada en la caja");
            System.out.println("Caja de agua saborizada: " + cajaAgua + "/10");
            if (cajaAgua == 10) {
                empaquetador.signal();
            }
        } finally {
            lockAgua.unlock();
        }

    }

    public void prepararBotellaVino() throws InterruptedException {
        try {
            lockVino.lock();
            while (cajaVino == 10) {
                embotelladoresVino.await();
            }
            cajaVino++;
            System.out.println("El " + Thread.currentThread().getName() + " ubico"
                    + " una botella de vino en la caja");
            System.out.println("Caja de vino: " + cajaVino + "/10");
            if (cajaVino == 10) {
                empaquetador.signal();
            }
        } finally {
            lockVino.unlock();
        }

    }

    public void retirarCaja() throws InterruptedException {
        try {
            lockAlmacen.lock();
            while (cajaAgua < 10 && cajaVino < 10) {
                empaquetador.await();
            }
            if (cajaAgua == 10) {
                System.out.println("Se lleno la caja de agua saborizada y el empaquetador la retiro");
                almacen++;
                System.out.println("La caja de agua se guardo en el deposito");
                System.out.println("Almacen: " + almacen + "/10");
                if (almacen == 10) {
                    transportador.signal();
                }
            } else if (cajaVino == 10) {
                System.out.println("Se lleno la caja de vino y el empaquetador la retiro");
                almacen++;
                System.out.println("La caja de vino se guardo en el deposito");
                System.out.println("Almacen: " + almacen + "/10");
                if (almacen == 10) {
                    transportador.signal();
                }
            }
        } finally {
            lockAlmacen.unlock();
        }
    }

    public void reponerCaja() {
        try {
            lockAlmacen.lock();
            if (cajaAgua == 10) {
                cajaAgua = 0;
                System.out.println("Se repuso la caja de agua");
                embotelladoresAgua.signalAll();
            } else if (cajaVino == 10) {
                cajaVino = 0;
                System.out.println("Se repuso la caja de vino");
                embotelladoresVino.signalAll();
            }
        } finally {
            lockAlmacen.unlock();
        }
    }

    public void transportar() throws InterruptedException {
        try {
            lockAlmacen.lock();
            while (almacen < 10) {
                transportador.await();
            }
            almacen = 0;
            System.out.println("El almacen se lleno, un camion salio a repatir"
                    + " todo el contenido del almacen");
            empaquetador.signal();
        } finally {
            lockAlmacen.unlock();
        }
    }
}
*/
