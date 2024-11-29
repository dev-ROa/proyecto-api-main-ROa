package fca.suayed.dto;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class ClientDto {
    private Long id;
    private String name;
    private String paternalSurname; // Usar camelCase
    private String maternalSurname; // Usar camelCase
    private String rfc;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    @ColumnName("nombre")
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    @ColumnName("apellido_paterno")
    public String getPaternalSurname() { return paternalSurname; }

    public void setPaternalSurname(String paternalSurname) { this.paternalSurname = paternalSurname; }

    @ColumnName("apellido_materno")
    public String getMaternalSurname() { return maternalSurname; }

    public void setMaternalSurname(String maternalSurname) { this.maternalSurname = maternalSurname; }

    @ColumnName("rfc")
    public String getRfc() { return rfc; }

    public void setRfc(String rfc) { this.rfc = rfc; } }