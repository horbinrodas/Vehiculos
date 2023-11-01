/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gt.edu.umg.vehiculosapi.service;

import com.google.gson.Gson;
import gt.edu.umg.vehiculosapi.DAO.VehiculoDAO;
import gt.edu.umg.vehiculosapi.DTO.VehiculoDTO;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author 50231
 */
@Path("service")
public class RestService {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    public RestService() {
    }

    /**
     * Retrieves representation of an instance of gt.edu.umg.vehiculosapi.service.RestService
     * @return an instance of java.lang.String
     */
    @GET
    @Path("getVehiculos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getVehiculos() {
        try {
            List<VehiculoDTO> vehiculos = new VehiculoDAO().getVehiculos();
    
            String json = new Gson().toJson(vehiculos);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (Exception e) {
            return Response.status(Response.Status.SEE_OTHER).entity("Error: " + e.toString()).build();
        }
    }

    /**
     * PUT method for updating or creating an instance of RestService
     * @param json
     */
    @POST
    @Path("updateVehiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    public int updateVehiculo(String json) {
        try {
            Gson gson = new Gson();
            VehiculoDTO vehiculo = (VehiculoDTO) gson.fromJson(json, VehiculoDTO.class);
            return new VehiculoDAO().updateVehiculo(vehiculo);
        } catch (Exception e) {
            return -1;
        }
    }
    
    @POST
    @Path("setVehiculo")
    @Consumes(MediaType.APPLICATION_JSON)
    public int setVehiculo(String json) {
        try {
            Gson gson = new Gson();
            VehiculoDTO vehiculo = (VehiculoDTO) gson.fromJson(json, VehiculoDTO.class);
            return new VehiculoDAO().setVehiculo(vehiculo);
        } catch (Exception e) {
            return -1;
        }
    }
}
