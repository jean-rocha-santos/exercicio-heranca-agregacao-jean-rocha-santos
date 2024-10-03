package school.sptech.especialistas;

import school.sptech.Desenvolvedor;

public class DesenvolvedorMobile extends Desenvolvedor  {
    private String plataforma;
    private  String linguagem;
    private  Integer horasPrototipacao;


    @Override
    public Double calcularSalario() {
        return super.calcularSalario() + horasPrototipacao * 200.00;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }

    public Integer getHorasPrototipacao() {
        return horasPrototipacao;
    }

    public void setHorasPrototipacao(Integer horasPrototipacao) {
        this.horasPrototipacao = horasPrototipacao;
    }

    @Override
    public String toString() {
        return "DesenvolvedorMobile{" +
                "plataforma='" + plataforma + '\'' +
                ", linguagem='" + linguagem + '\'' +
                ", nome='" + nome + '\'' +
                ", qtdHoras=" + qtdHoras +
                ", valorHora=" + valorHora +
                "} " + super.toString();
    }
}
