/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.vehiculosapi.DTO;

/**
 *
 * @author 50231
 */
public class VehiculoDTO {
    private int id;
    private String placa;
    private String modelo;
    private String color;
    private int puertas;

    public VehiculoDTO(int id, String placa, String modelo, String color, int puertas) {
        this.id = id;
        this.placa = placa;
        this.modelo = modelo;
        this.color = color;
        this.puertas = puertas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPuertas() {
        return puertas;
    }

    public void setPuertas(int puertas) {
        this.puertas = puertas;
    }
    
}
