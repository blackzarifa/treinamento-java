package teste.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;

abstract public class superRest {
	@Context
    private HttpServletRequest request;

    @Context
    private HttpServletResponse response;
}
