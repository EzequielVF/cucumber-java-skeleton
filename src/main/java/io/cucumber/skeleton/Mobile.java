package io.cucumber.skeleton;
public class Mobile {

    public int bateria;

    public Mobile(int porcentage){

        if(porcentage > 100 || porcentage < 0) {
            this.bateria = -1; //Rompiste la bateria!! >.<
        }
        this.bateria = porcentage;
    }

    public int mandarMensaje() {
        if (this.bateria <= 0)
            return -1;

        this.bateria--;
        return 0;
    }

    public int llamar(int duracion) {
        if (duracion < 0) {
            System.out.printf("No puedo llamar tiempo negativo");
            return -1;
        }

        int total = duracion * 3;
        if (total > this.bateria) {
            this.bateria = 0;
            System.out.printf("No pude terminar la llamada");
            return -2;
        }
        this.bateria -= total;
        return 0;

    }

    public int preguntarCarga() {
        return this.bateria;
    }

    public int cargar() { // Lo cree pero no lo use
        this.bateria = 100;
        return 0;
    }
}
