package spring;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EciSpringBoot {
    // Contendrá los pares URL - Método
    private Map<String, Method> services = new HashMap<>();

    private static EciSpringBoot _instance = new EciSpringBoot();

    private EciSpringBoot(){}

    public static EciSpringBoot getInstance() {
        return _instance;
    }

    public void startServer() {
        loadComponents();


        try {
            HttpServer httpServer = new HttpServer();
            httpServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadComponents() {
        String[] componentList = searchComponentList();

        for(String component : componentList) {
            // Cargar todos los servicios del componente
            loadServices(component);
        }
        /**
         * Explorar una lista de clases para ver si lo cargamos o no
         * Lo que tenga @Service se carga
         *
         * // El directorio debe estar en el classpath de la máquina virtual
         */
    }


    private String[] searchComponentList() {
        return new String[]{"spring.examples.StatusService"};
    }

    private void loadServices(String component) {
        try {
            Class c = Class.forName(component);

            for (Method method: c.getDeclaredMethods()) {
                if (method.isAnnotationPresent(Service.class)) {
                    Service annotation = method.getAnnotation(Service.class);
                    services.put(annotation.value(), method);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
