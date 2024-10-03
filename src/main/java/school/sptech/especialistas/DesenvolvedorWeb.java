package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorWeb extends Desenvolvedor {
    private  String backend;
    private  String frontend;
    private String sgbd;
    private Integer horasMentoria;

    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + horasMentoria *300.00;
    }
    public Boolean isFullstack(){
        if (backend.isEmpty() || frontend.isEmpty() || sgbd.isEmpty()){
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DesenvolvedorWeb{" +
                "backend='" + backend + '\'' +
                ", frontend='" + frontend + '\'' +
                ", sgbd='" + sgbd + '\'' +
                ", horasMentoria=" + horasMentoria +
                ", nome='" + nome + '\'' +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                "} " + super.toString();
    }
}
