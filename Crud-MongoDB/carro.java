public class carro {
    private String motor;
    private String nome;
    private String cor;
    private int serial;

    public carro(String motor, String nome, String cor, int serial) {
        this.motor = motor;
        this.nome = nome;
        this.cor = cor;
        this.serial = serial;
    }

    public String getMotor() {
        return motor;
    }

    public String getNome() {
        return nome;
    }

    public String getCor() {
        return cor;
    }

    public int getSerial() {
        return serial;
    }

}
