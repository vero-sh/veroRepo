package CCmanagement;

public class CCmanagement {
    private String nome;
    private double saldo;

    public CCmanagement(String nome) {
        this.nome = nome;
        saldo = 0;
    }

    @Override
    public String toString() {
        return "informazioni conto corrente{" +
                "nome='" + nome + '\'' +
                ", saldo=" + saldo +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    public void preleva (double qta) throws CifraNegativaException, SaldoInsufficienteException{
        if(qta<0){
            throw new CifraNegativaException("Impossibile prelevare una cifra negativa");
        }
        if(qta>saldo){
            throw new SaldoInsufficienteException("impossibile prelevare, saldo insufficiente ");
        }
        saldo = saldo - qta;
    }
    public void deposita (double qta) throws CifraNegativaException{
        if(qta<0){
            throw new CifraNegativaException("Impossibile depositare una cifra negativa");
        }
        saldo = saldo + qta;
    }
}
