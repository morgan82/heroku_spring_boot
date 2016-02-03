package com.globallogic.orders.web.controller;

import com.globallogic.orders.domain.Order;
import com.globallogic.orders.exception.EntityNotFoundException;
import com.globallogic.orders.exception.ErrorOrder;
import com.globallogic.orders.service.OrderServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author facundo.ferro. Maximiliano Alexandroff, Matias Rodriguez, Federico Giangarra, Mario Urtado
 */
// Usar la extensión Postman de Google Chrome para tirar POSTs y GETs
// @RestController combina @ResponseBody y @Controller

@RestController
@RequestMapping("/api")        // indicamos que todos los "handling methods" en este controlador estan en "/api"
public class OrderController { // podriamos indicar que todos los metodos van a ser POST (por ejemplo)

    private static final Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderServices orderServices;

    @RequestMapping(method = {RequestMethod.GET})
    public String home() {
        return "api up and running";
    }

	/*@RequestBody convierte el body del Request (de la URL de @RequestMapping) a objetos de dominio (Por ej: Order).        
     * Esto lo hace "deserializando" el Request.
     * Básicamente, transforma el HTTP Post Request en el Objeto de Dominio.
     */

    @RequestMapping(value = "/orders", method = {RequestMethod.POST}, headers = "Accept=application/json")
    public Order add(@RequestBody @Validated Order order, BindingResult bindingResult) {
        return orderServices.add(order);
    }

    @RequestMapping(value = "/orders", method = {RequestMethod.GET})
    public List<Order> list() {
        return orderServices.getAll();
    }

    @RequestMapping(value = "/orders/{id}", method = {RequestMethod.PUT})
    public Order update(@RequestBody @Validated Order order, @PathVariable(value = "id") String id)
            throws EntityNotFoundException {
        return orderServices.update(order, id);
    }

    @RequestMapping(value = "/orders/{id}", method = {RequestMethod.DELETE})
    public void delete(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        orderServices.delete(id);
    }

    @RequestMapping(value = "/orders/{id}/register", method = {RequestMethod.PUT})
    public Order increment(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        return orderServices.increment(id);
    }

    @RequestMapping(value = "/orders/{id}/unregister", method = {RequestMethod.PUT})
    public Order decrement(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        return orderServices.decrement(id);
    }

    @RequestMapping(value = "/orders/{id}", method = {RequestMethod.GET})
    public Order get(@PathVariable(value = "id") String id) throws EntityNotFoundException {
        return orderServices.get(id);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler(value = EntityNotFoundException.class)
    public ErrorOrder entityNotFoundExceptionHandler(Exception e) {
        return new ErrorOrder(e.getMessage(), "404");
    }

    @ResponseStatus(value = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {TransactionSystemException.class, DataIntegrityViolationException.class})
    public ErrorOrder errorHandler(Exception exception) {
        return new ErrorOrder("Error en la validacionde losdatos enviados" + exception.getClass().getSimpleName(), "422");
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = {Exception.class})
    public ErrorOrder genericErrorHandler(Exception exception) {
        log.error("Error generic error", exception);
        return new ErrorOrder("Error desconocido", "500");
    }

}

    