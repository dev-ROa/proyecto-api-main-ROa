package fca.suayed.dal;

import fca.suayed.dao.StoreDao;
import fca.suayed.dto.ProductDto;
import fca.suayed.dto.ClientDto; // Importación de ClientDto para manejar clientes
import fca.suayed.dto.ResponseDto;
import fca.suayed.services.JdbiService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.jboss.logging.Logger;
import org.jdbi.v3.core.Jdbi;

import java.util.List;

@ApplicationScoped
public class StoreDal {

    private static final Logger LOGGER = Logger.getLogger(StoreDal.class);

    @Inject
    JdbiService jdbiService;

    public ResponseDto<List<ProductDto>> getProducts() {
        ResponseDto<List<ProductDto>> responseDto = new ResponseDto<>();
        responseDto.setSuccess(true);
        Jdbi jdbi = jdbiService.getInstance();

        // Obtiene la lista de productos
        var products = jdbi.withExtension(StoreDao.class, StoreDao::getProducts);
        responseDto.setData(products);
        return responseDto;
    }

    public ResponseDto<String> addProduct(final ProductDto productDto) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setSuccess(false);

        Jdbi jdbi = jdbiService.getInstance();
        jdbi.useExtension(StoreDao.class, dao -> {
            dao.addProduct(productDto); // Añade el producto
            responseDto.setSuccess(true);
            responseDto.setData("Producto agregado exitosamente"); // Mensaje de éxito
        });

        return responseDto;
    }

    // Nueva forma para obtener todos los clientes
    public ResponseDto<List<ClientDto>> getClients() {
        ResponseDto<List<ClientDto>> responseDto = new ResponseDto<>(); // Se crea un nuevo objeto ResponseDto para clientes
        responseDto.setSuccess(true); // Se establece que la operación es exitosa
        Jdbi jdbi = jdbiService.getInstance(); // Se obtiene la instancia de JDBI

        // Se llama a la forma getClients() del DAO para obtener la lista de clientes
        var clients = jdbi.withExtension(StoreDao.class, StoreDao::getClients);
        responseDto.setData(clients); // Se asigna la lista de clientes al objeto ResponseDto

        return responseDto; // Se retorna el objeto ResponseDto con los datos de los clientes
    }

    // Nueva forma para agregar un nuevo cliente
    public ResponseDto<String> addClient(final ClientDto clientDto) {
        ResponseDto<String> responseDto = new ResponseDto<>();
        responseDto.setSuccess(false);

        Jdbi jdbi = jdbiService.getInstance();
        jdbi.useExtension(StoreDao.class, dao -> {
            dao.addClient(clientDto); // Cambiado a addClient para agregar un cliente
            responseDto.setSuccess(true);
            responseDto.setData("Cliente agregado exitosamente"); // Mensaje de éxito
        });

        return responseDto; // Retorna el objeto ResponseDTO con el resultado
    }
}