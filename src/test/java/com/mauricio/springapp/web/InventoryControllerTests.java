package com.mauricio.springapp.web;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Map;

import com.mauricio.springapp.domain.Product;
import com.mauricio.springapp.repository.InMemoryProductDao;
import com.mauricio.springapp.service.SimpleProductManager;
import com.mauricio.springapp.web.InventoryController;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;



public class InventoryControllerTests {
	@Test
    public void testHandleRequestView() throws Exception{		
        InventoryController controller = new InventoryController();
        SimpleProductManager spm = new SimpleProductManager();
        spm.setProductDao(new InMemoryProductDao(new ArrayList<Product>()));
        controller.setProductManager(spm);
        ModelAndView modelAndView = controller.handleRequest(null, null);		
        assertEquals("hello", modelAndView.getViewName());
        assertNotNull(modelAndView.getModel());
        @SuppressWarnings("unchecked")
		Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
        String nowValue = (String) modelMap.get("now");
        assertNotNull(nowValue);

    }
}
