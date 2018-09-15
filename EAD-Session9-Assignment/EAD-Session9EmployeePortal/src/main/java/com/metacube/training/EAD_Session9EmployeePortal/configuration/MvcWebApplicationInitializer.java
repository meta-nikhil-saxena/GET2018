package com.metacube.training.EAD_Session9EmployeePortal.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MvcWebApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

   @Override
   protected Class<?>[] getRootConfigClasses() {
      return null;
   }

   @Override
   protected Class<?>[] getServletConfigClasses() {
      return new Class[] { MvcWebConfig.class };
   }

   @Override
   protected String[] getServletMappings() {
      return new String[] { "/" };
   }
   

}
