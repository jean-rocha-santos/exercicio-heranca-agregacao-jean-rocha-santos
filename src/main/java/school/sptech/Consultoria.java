package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas;

    private List<Consultoria> desenvolvedores = new ArrayList<>();


    public Consultoria(String nome, Integer vagas, List<Consultoria> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = desenvolvedores;
    }

    public Consultoria() {
    }


    public void contratar(Desenvolvedor dev) {
        if (vagas - desenvolvedores.size() > 0) {
            desenvolvedores.add(dev);
        }
    }

    public void contratarFullstack(DesenvolvedorWeb dev) {
        if (vagas - desenvolvedores.size() > 0) {
            if (dev.isFullstack()) {
                desenvolvedores.add(dev);
            }
        }

    }

    public Double getTotalSalarios() {
        Double totalSalario = 0.0;
        for (Consultoria devs : desenvolvedores) {
            if (devs instanceof Desenvolvedor) {
                Double salDev = ((Desenvolvedor) devs).calcularSalario();
                totalSalario += salDev;
            }

        }
        return totalSalario;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer qtdDevMob = 0;
        for (Consultoria desenvolvedores : desenvolvedores) {
            if (desenvolvedores instanceof DesenvolvedorMobile) {
                qtdDevMob++;
            }
        }
        return qtdDevMob;
    }


    public List<Desenvolvedor> buscarPorSalarioMaiorQue(Double salario) {
        List<Desenvolvedor> maiorSalarios = new ArrayList<>();

        for (Consultoria dev : desenvolvedores) {
            if (dev instanceof Desenvolvedor) {
                Desenvolvedor desenvolvedor = (Desenvolvedor) dev;
                Double salarioDesenvolvedor = desenvolvedor.calcularSalario();
                if (salarioDesenvolvedor >= salario) {
                    maiorSalarios.add(desenvolvedor);
                }
            }
        }

        return maiorSalarios;
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        List<Desenvolvedor> menorSalarios = new ArrayList<>();

        Double menorSalario = 9999.0;
        Desenvolvedor devComMenorSalario = (Desenvolvedor) desenvolvedores.get(0);

        for (Consultoria dev : desenvolvedores) {
            if (dev instanceof Desenvolvedor) {
                Desenvolvedor devDaVez = new Desenvolvedor();
                Double salarioAtual = devDaVez.calcularSalario();
                if (salarioAtual < menorSalario) {
                    menorSalario = salarioAtual;
                    menorSalarios.add(devComMenorSalario);

                }
            }
        }
            return devComMenorSalario;
    }

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        List<Desenvolvedor> tecnologiaEncontrada = new ArrayList<>();

        for (Consultoria devs : desenvolvedores) {
            if(devs instanceof DesenvolvedorWeb){
                DesenvolvedorWeb devTec = (DesenvolvedorWeb) devs;
                if(
                        devTec.getBackend().equalsIgnoreCase(tecnologia) ||
                                devTec.getFrontend().equalsIgnoreCase(tecnologia) ||
                                    devTec.getSgbd().equalsIgnoreCase(tecnologia)
                ){
                    tecnologiaEncontrada.add(devTec);
                }
            }

        }
        return tecnologiaEncontrada;
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double totalSalarios = 0.0;

        for (Consultoria dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devTec = (DesenvolvedorWeb) dev;
                if (devTec.getBackend().equals(tecnologia) ||
                        devTec.getFrontend().equals(tecnologia) ||
                        devTec.getSgbd().equals(tecnologia)) {
                    totalSalarios += devTec.calcularSalario();
                }
            }
        }

        return totalSalarios;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }

    public List<Consultoria> getDesenvolvedores() {
        return desenvolvedores;
    }

    public void setDesenvolvedores(List<Consultoria> desenvolvedores) {
        this.desenvolvedores = desenvolvedores;
    }
}
