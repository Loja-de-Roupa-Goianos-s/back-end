package com.ecommerce.lojavirtual.dto;

import com.ecommerce.lojavirtual.model.Entrega;

import java.time.LocalDateTime;

public class EntregaDTO {
    private Long id;
    private Entrega.StatusEntrega statusEntrega;
    private LocalDateTime dataEnvio;
    private LocalDateTime dataPrevistaEntrega;
    private LocalDateTime dataEntregaEfetiva;
    private String codigoRastreio;

    public EntregaDTO(Long id, Entrega.StatusEntrega statusEntrega, LocalDateTime dataEnvio, LocalDateTime dataPrevistaEntrega, LocalDateTime dataEntregaEfetiva, String codigoRastreio) {
        this.id = id;
        this.statusEntrega = statusEntrega;
        this.dataEnvio = dataEnvio;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataEntregaEfetiva = dataEntregaEfetiva;
        this.codigoRastreio = codigoRastreio;
    }

    public EntregaDTO() {
    }

    public Long getId() {
        return this.id;
    }

    public Entrega.StatusEntrega getStatusEntrega() {
        return this.statusEntrega;
    }

    public LocalDateTime getDataEnvio() {
        return this.dataEnvio;
    }

    public LocalDateTime getDataPrevistaEntrega() {
        return this.dataPrevistaEntrega;
    }

    public LocalDateTime getDataEntregaEfetiva() {
        return this.dataEntregaEfetiva;
    }

    public String getCodigoRastreio() {
        return this.codigoRastreio;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStatusEntrega(Entrega.StatusEntrega statusEntrega) {
        this.statusEntrega = statusEntrega;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public void setDataPrevistaEntrega(LocalDateTime dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public void setDataEntregaEfetiva(LocalDateTime dataEntregaEfetiva) {
        this.dataEntregaEfetiva = dataEntregaEfetiva;
    }

    public void setCodigoRastreio(String codigoRastreio) {
        this.codigoRastreio = codigoRastreio;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof EntregaDTO)) return false;
        final EntregaDTO other = (EntregaDTO) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$statusEntrega = this.getStatusEntrega();
        final Object other$statusEntrega = other.getStatusEntrega();
        if (this$statusEntrega == null ? other$statusEntrega != null : !this$statusEntrega.equals(other$statusEntrega))
            return false;
        final Object this$dataEnvio = this.getDataEnvio();
        final Object other$dataEnvio = other.getDataEnvio();
        if (this$dataEnvio == null ? other$dataEnvio != null : !this$dataEnvio.equals(other$dataEnvio)) return false;
        final Object this$dataPrevistaEntrega = this.getDataPrevistaEntrega();
        final Object other$dataPrevistaEntrega = other.getDataPrevistaEntrega();
        if (this$dataPrevistaEntrega == null ? other$dataPrevistaEntrega != null : !this$dataPrevistaEntrega.equals(other$dataPrevistaEntrega))
            return false;
        final Object this$dataEntregaEfetiva = this.getDataEntregaEfetiva();
        final Object other$dataEntregaEfetiva = other.getDataEntregaEfetiva();
        if (this$dataEntregaEfetiva == null ? other$dataEntregaEfetiva != null : !this$dataEntregaEfetiva.equals(other$dataEntregaEfetiva))
            return false;
        final Object this$codigoRastreio = this.getCodigoRastreio();
        final Object other$codigoRastreio = other.getCodigoRastreio();
        if (this$codigoRastreio == null ? other$codigoRastreio != null : !this$codigoRastreio.equals(other$codigoRastreio))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof EntregaDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $statusEntrega = this.getStatusEntrega();
        result = result * PRIME + ($statusEntrega == null ? 43 : $statusEntrega.hashCode());
        final Object $dataEnvio = this.getDataEnvio();
        result = result * PRIME + ($dataEnvio == null ? 43 : $dataEnvio.hashCode());
        final Object $dataPrevistaEntrega = this.getDataPrevistaEntrega();
        result = result * PRIME + ($dataPrevistaEntrega == null ? 43 : $dataPrevistaEntrega.hashCode());
        final Object $dataEntregaEfetiva = this.getDataEntregaEfetiva();
        result = result * PRIME + ($dataEntregaEfetiva == null ? 43 : $dataEntregaEfetiva.hashCode());
        final Object $codigoRastreio = this.getCodigoRastreio();
        result = result * PRIME + ($codigoRastreio == null ? 43 : $codigoRastreio.hashCode());
        return result;
    }

    public String toString() {
        return "EntregaDTO(id=" + this.getId() + ", statusEntrega=" + this.getStatusEntrega() + ", dataEnvio=" + this.getDataEnvio() + ", dataPrevistaEntrega=" + this.getDataPrevistaEntrega() + ", dataEntregaEfetiva=" + this.getDataEntregaEfetiva() + ", codigoRastreio=" + this.getCodigoRastreio() + ")";
    }
}