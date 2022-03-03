package model;

public class Consulta {

    private int codigoConsulta;
    private String dataConsulta;
    private String horarioConsulta;
    private String situacaoConsulta;
    private String observacoesConsulta;

    public Consulta(int codigoConsulta, String dataConsulta, String horarioConsulta, String situacaoConsulta, String observacoesConsulta) {
        this.codigoConsulta = codigoConsulta;
        this.dataConsulta = dataConsulta;
        this.horarioConsulta = horarioConsulta;
        this.situacaoConsulta = situacaoConsulta;
        this.observacoesConsulta = observacoesConsulta;
    }

    public int getCodigoConsulta() {
        return codigoConsulta;
    }

    public void setCodigoConsulta(int codigoConsulta) {
        this.codigoConsulta = codigoConsulta;
    }

    public String getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(String dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getHorarioConsulta() {
        return horarioConsulta;
    }

    public void setHorarioConsulta(String horarioConsulta) {
        this.horarioConsulta = horarioConsulta;
    }

    public String getSituacaoConsulta() {
        return situacaoConsulta;
    }

    public void setSituacaoConsulta(String situacaoConsulta) {
        this.situacaoConsulta = situacaoConsulta;
    }

    public String getObservacoesConsulta() {
        return observacoesConsulta;
    }

    public void setObservacoesConsulta(String observacoesConsulta) {
        this.observacoesConsulta = observacoesConsulta;
    }

}