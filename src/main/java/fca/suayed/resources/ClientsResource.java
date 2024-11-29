package fca.suayed.resources;

import fca.suayed.dal.StoreDal;
import fca.suayed.dto.ClientDto; // Importa ClientDto
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("/clients") // Cambia el path a /clients
public class ClientsResource {

    @Inject
    StoreDal storeDal;

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Get all clients") // Resumen de la operación
    @APIResponses(value = {
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
    })
    public Response getClients() {
        var responseDto = storeDal.getClients(); // Llama a la forma getClients en StoreDal
        return Response.ok(responseDto).build(); // Devuelve la respuesta con el DTO
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Operation(summary = "Add a new client")
    @APIResponses(value = {
            @APIResponse(responseCode = "200", content = @Content(mediaType = MediaType.APPLICATION_JSON)),
    })
    public Response registerClient(ClientDto clientDto) {
        var responseDto = storeDal.addClient(clientDto); // Nos Asegúramos de implementar esta forma en StoreDal
        return Response.ok(responseDto).build();
    }
}